package com.us.vizbl.ar.sdk.demo.ui.screens.ar

import android.util.Log
import android.view.SurfaceView
import android.widget.Toast
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.PaddingValues
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.runtime.Composable
import androidx.compose.runtime.LaunchedEffect
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.platform.LocalUriHandler
import androidx.compose.ui.unit.dp
import androidx.navigation.NavHostController
import androidx.navigation.compose.rememberNavController
import com.us.vizbl.ar.sdk.api.ARObjectIdentifier
import com.us.vizbl.ar.sdk.api.ARObjectReference
import com.us.vizbl.ar.sdk.api.ARPlacedObject
import com.us.vizbl.ar.sdk.api.VizblARController
import com.us.vizbl.ar.sdk.api.VizblARScene
import com.us.vizbl.ar.sdk.api.VizblActionHandler
import com.us.vizbl.ar.sdk.demo.core.LocalConfig
import com.us.vizbl.ar.sdk.demo.ui.component.button.DemoControlsFab
import com.us.vizbl.ar.sdk.demo.ui.component.sheet.ManageModelSheet
import kotlinx.coroutines.CoroutineScope
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.launch
import java.util.UUID

@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun ARScreen(
    modifier: Modifier = Modifier,
    navController: NavHostController = rememberNavController(),
    localConfig: LocalConfig
) {
    val context = LocalContext.current
    var controller by remember { mutableStateOf<VizblARController?>(null) }

    val uriHandler = LocalUriHandler.current

    var showObjectPanel by remember { mutableStateOf(false) }
    var showPanelSheet by remember { mutableStateOf(false) }

    LaunchedEffect(Unit) {
        showObjectPanel = localConfig.showObjectPanel
    }

    Box(modifier = modifier) {
        VizblARScene(
            contentPadding = PaddingValues(top = 24.dp),
            onControllerReady = {
                controller = it
            },
            onSessionReady = {
                CoroutineScope(Dispatchers.Main).launch {
                    controller?.add(
                        model = ARObjectReference.Single(
                            id = ARObjectIdentifier.ObjectId(UUID.fromString(localConfig.objectId)),
                            materialId = null
                        ),
                        configuration = {
                            // Tap to Select
                            allowsTapToSelected(localConfig.enableTapToSelect)
                            // Move
                            allowsMove(localConfig.enableMove)
                            // Rotation
                            allowRotation(localConfig.enableRotation)
                        }
                    )
                }
            },
            viewConfiguration = {
                // Tips
                enableTips(localConfig.enableTips)
                // Screenshot
                enableScreenshot(localConfig.enableScreenshot)
                // Multiple Models
                enableMultipleModels(localConfig.enableMultipleObjects)
                // QR
                enableQRCode(localConfig.enableQRScan)
            },
            actionHandler = object : VizblActionHandler {
                override fun onAddObjectClick() {
                    showPanelSheet = true
                }

                override fun onScreenshotClick(view: SurfaceView?) {
                    view?.let {
                        controller?.capture(
                            view = it,
                            onSuccess = {
                                Toast.makeText(context, "Screenshot Saved!", Toast.LENGTH_SHORT).show()
                            }
                        )
                    }
                }

                override fun onBuyClick(url: String, previewUrl: String?) {
                    uriHandler.openUri(url)
                }

                override fun onCloseClick() {
                    navController.popBackStack()
                }

                override fun onQRScanned(url: String) {
                    uriHandler.openUri(url)
                }
            }
        )

        if (showObjectPanel) {
            Box(
                modifier = Modifier
                    .padding(PaddingValues(top = 24.dp))
                    .align(Alignment.TopCenter)
            ) {
                DemoControlsFab(
                    onClick = {
                        showPanelSheet = true
                    }
                )
            }
        }

        if (showPanelSheet) {
            var placedModels by remember {
                mutableStateOf(
                    controller?.placedObjects
                        ?.filterIsInstance<ARPlacedObject>() ?: emptyList()
                )
            }
            ManageModelSheet(
                placedModels = placedModels,
                onAddModel = { objectId ->
                    CoroutineScope(Dispatchers.Main).launch {
                        controller?.add(
                            model = ARObjectReference.Single(
                                id = ARObjectIdentifier.ObjectId(UUID.fromString(objectId)),
                                materialId = null
                            )
                        )
                    }
                    showPanelSheet = false
                },
                onRemoveModel = { instanceId ->
                    controller?.remove(instanceId)
                    placedModels = placedModels.filter { it.instanceId != instanceId }
                },
                onDismiss = {
                    showPanelSheet = false
                }
            )
        }
    }
}