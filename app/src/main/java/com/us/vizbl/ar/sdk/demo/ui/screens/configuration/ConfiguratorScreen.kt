package com.us.vizbl.ar.sdk.demo.ui.screens.configuration

import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.rememberScrollState
import androidx.compose.foundation.verticalScroll
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.automirrored.filled.ArrowBack
import androidx.compose.material3.FilledTonalIconButton
import androidx.compose.material3.Icon
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Modifier
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.navigation.NavHostController
import androidx.navigation.compose.rememberNavController
import com.us.vizbl.ar.sdk.api.VizblARController
import com.us.vizbl.ar.sdk.demo.core.LocalConfig
import com.us.vizbl.ar.sdk.demo.core.NavigationDataHolder
import com.us.vizbl.ar.sdk.demo.ui.theme.AppTheme

@Composable
fun ConfiguratorScreen(
    modifier: Modifier = Modifier,
    navController: NavHostController = rememberNavController()
) {
    var enableTips by remember { mutableStateOf(true) }
    var enableScreenshot by remember { mutableStateOf(true) }
    var enableMultipleModels by remember { mutableStateOf(true) }
    var enableQRScan by remember { mutableStateOf(true) }
    var enableTap by remember { mutableStateOf(true) }
    var enableMove by remember { mutableStateOf(true) }
    var enableRotation by remember { mutableStateOf(true) }

    var selectedModel by remember { mutableStateOf("d6742149-c4df-4ab5-81f4-233d31670284") }
    var selectedText by remember { mutableStateOf("Modern Lamp") }

    Box(modifier = modifier.fillMaxSize()) {
        Column(
            modifier = Modifier
                .fillMaxSize()
                .padding(start = 16.dp, end = 16.dp)
                .verticalScroll(rememberScrollState())
        ) {
            FilledTonalIconButton(
                onClick = {
                    navController.popBackStack()
                },
                modifier = modifier
            ) {
                Icon(
                    imageVector = Icons.AutoMirrored.Filled.ArrowBack,
                    contentDescription = null
                )
            }

            Spacer(Modifier.height(32.dp))

            ConfiguratorOptionsContent(
                enableTips = enableTips,
                enableScreenshot = enableScreenshot,
                enableMultipleModels = enableMultipleModels,
                enableQRScan = enableQRScan,
                enableTap = enableTap,
                enableMove = enableMove,
                enableRotation = enableRotation,
                isShowModelAddButton = true,
                isShowAction = true,
                onOpenAR = {
                    val configObject = LocalConfig(
                        objectId = selectedModel,
                        showObjectPanel = true,
                        enableScreenshot = enableScreenshot,
                        enableTips = enableTips,
                        enableMultipleObjects = enableMultipleModels,
                        enableMove = enableMove,
                        enableRotation = enableRotation,
                        enableTapToSelect = enableTap,
                        enableQRScan = enableQRScan
                    )
                    NavigationDataHolder.arConfig = configObject
                    navController.navigate("ARScreen")
                },
                onChangeTips = {
                    enableTips = it
                },
                onChangeScreenshot = {
                    enableScreenshot = it
                },
                onChangeMultipleModels = {
                    enableMultipleModels = it
                },
                onChangeTap = {
                    enableTap = it
                },
                onChangeMove = {
                    enableMove = it
                },
                selectedQuality = selectedText,
                qualityItems = listOf(
                    Pair("Modern Lamp", "d6742149-c4df-4ab5-81f4-233d31670284"),
                    Pair("Round Table", "fae3b456-4b25-463c-bbdd-199286a35cd0"),
                    Pair("Husk Armchair", "38a6f514-ea43-4673-8c8d-74061b873eb2"),
                    Pair("Sarah - Breeze", "46714f6f-58c1-4c36-98e3-1d168c698c8d")
                ),
                onQualityChanged = {
                    selectedText = it.first
                    selectedModel = it.second
                },
                onChangeRotation = {
                    enableRotation = it
                },
                onChangeQRScan = {
                    enableQRScan = it
                }
            )

            Spacer(modifier = Modifier.height(24.dp))
        }
    }
}

@Preview
@Composable
private fun ConfiguratorScreenPreview_Light() {
    AppTheme {
        ConfiguratorScreen()
    }
}