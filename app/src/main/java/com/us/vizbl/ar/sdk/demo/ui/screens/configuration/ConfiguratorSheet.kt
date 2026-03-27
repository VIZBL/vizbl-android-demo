package com.us.vizbl.ar.sdk.demo.ui.screens.configuration

import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.ModalBottomSheet
import androidx.compose.material3.rememberModalBottomSheetState
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import com.us.vizbl.ar.sdk.api.config.`object`.ObjectConfig
import com.us.vizbl.ar.sdk.api.config.view.ViewConfig
import com.us.vizbl.ar.sdk.demo.ui.theme.AppTheme
import kotlin.collections.listOf

@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun ConfiguratorSheet(
    modifier: Modifier = Modifier,
    viewConfig: ViewConfig,
    objectConfig: ObjectConfig,

    isShowModelAddButton: Boolean = false,
    isShowAction: Boolean = false,

    onChangeTips: (Boolean) -> Unit,
    onChangeScreenshot: (Boolean) -> Unit,
    onChangeMultipleModels: (Boolean) -> Unit,
    onChangeTap: (Boolean) -> Unit,
    onChangeMove: (Boolean) -> Unit,
    onChangeRotation: (Boolean) -> Unit,
    onChangeQRScan: (Boolean) -> Unit,

    onDismiss: () -> Unit
) {
    val sheetState = rememberModalBottomSheetState()

    ModalBottomSheet(
        sheetState = sheetState,
        onDismissRequest = onDismiss
    ) {
        Column(modifier = modifier.padding(horizontal = 16.dp, vertical = 16.dp)) {
            ConfiguratorOptionsContent(
                enableTips = viewConfig.popoverTipsEnabled,
                enableScreenshot = viewConfig.screenshotEnabled,
                enableMultipleModels = viewConfig.multipleModelsEnabled,
                enableQRScan = viewConfig.qrCodeEnabled,
                enableTap = objectConfig.allowsTapToSelected,
                enableMove = objectConfig.allowsMove,
                enableRotation = objectConfig.allowRotation,
                isShowModelAddButton = isShowModelAddButton,
                isShowAction = isShowAction,
                onChangeTips = onChangeTips,
                onChangeScreenshot = onChangeScreenshot,
                onChangeTap = onChangeTap,
                onChangeMove = onChangeMove,
                onChangeRotation = onChangeRotation,
                selectedQuality = "Modern Lamp",
                qualityItems = listOf(
                    Pair("Modern Lamp", "d6742149-c4df-4ab5-81f4-233d31670284"),
                    Pair("Round Table", "fae3b456-4b25-463c-bbdd-199286a35cd0"),
                    Pair("Husk Armchair", "38a6f514-ea43-4673-8c8d-74061b873eb2"),
                    Pair("Sarah - Breeze", "46714f6f-58c1-4c36-98e3-1d168c698c8d")
                ),
                onQualityChanged = {},
                onChangeQRScan = onChangeQRScan,
                onChangeMultipleModels = onChangeMultipleModels
            )
        }
    }
}

@Preview
@Composable
private fun ConfiguratorSheetPreview_Light() {
    AppTheme(darkTheme = false) {
        ConfiguratorSheet(
            viewConfig = ViewConfig(),
            objectConfig = ObjectConfig(),
            onDismiss = {},
            onChangeTips = {  },
            onChangeScreenshot = {  },
            onChangeTap = {  },
            onChangeMove = {  },
            onChangeRotation = {  },
            onChangeMultipleModels = {},
            onChangeQRScan = {}
        )
    }
}