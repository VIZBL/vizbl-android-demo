package com.us.vizbl.ar.sdk.demo.ui.screens.configuration

import androidx.compose.foundation.background
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.Card
import androidx.compose.material3.CardDefaults
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.HorizontalDivider
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.alpha
import androidx.compose.ui.draw.clip
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.style.TextOverflow
import androidx.compose.ui.unit.dp
import com.us.vizbl.ar.sdk.demo.R
import com.us.vizbl.ar.sdk.demo.ui.component.CategorySection
import com.us.vizbl.ar.sdk.demo.ui.component.button.VizblDropdown
import com.us.vizbl.ar.sdk.demo.ui.component.button.VizblLinkButton
import com.us.vizbl.ar.sdk.demo.ui.component.button.VizblToggleButton

@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun ConfiguratorOptionsContent(
    modifier: Modifier = Modifier,

    enableTips: Boolean,
    enableScreenshot: Boolean,
    enableMultipleModels: Boolean,
    enableQRScan: Boolean,

    enableTap: Boolean,
    enableMove: Boolean,
    enableRotation: Boolean,

    isShowModelAddButton: Boolean,
    isShowAction: Boolean,
    onOpenAR: () -> Unit = {},

    selectedQuality: String,
    qualityItems: List<Pair<String, String>>,
    onQualityChanged: (Pair<String, String>) -> Unit,

    onChangeTips: (Boolean) -> Unit,
    onChangeScreenshot: (Boolean) -> Unit,
    onChangeMultipleModels: (Boolean) -> Unit,
    onChangeQRScan: (Boolean) -> Unit,
    onChangeTap: (Boolean) -> Unit,
    onChangeMove: (Boolean) -> Unit,
    onChangeRotation: (Boolean) -> Unit
) {
    Column {
        Text(
            text = "Configuration",
            style = MaterialTheme.typography.headlineLarge,
            maxLines = 1,
            overflow = TextOverflow.Ellipsis,
            fontWeight = FontWeight.Bold
        )

        Spacer(Modifier.height(32.dp))

        CategorySection(categoryName = stringResource(R.string.config_view_config_category)) {
            Column(
                modifier = Modifier
                    .clip(RoundedCornerShape(16.dp))
                    .background(MaterialTheme.colorScheme.surfaceVariant)
                    .padding(16.dp)
            ) {
                VizblToggleButton(
                    title = "Tips",
                    subtitle = "Show interactive hints on screen",
                    enabled = enableTips,
                    onCheckedChange = onChangeTips
                )
                HorizontalDivider(
                    modifier = Modifier
                        .padding(horizontal = 12.dp)
                        .alpha(0.2f),
                )
                VizblToggleButton(
                    title = "Screenshot",
                    subtitle = "Show button screenshot on screen",
                    enabled = enableScreenshot,
                    onCheckedChange = onChangeScreenshot
                )
                HorizontalDivider(
                    modifier = Modifier
                        .padding(horizontal = 12.dp)
                        .alpha(0.2f),
                )
                VizblToggleButton(
                    title = "Multiple Models",
                    subtitle = "Allow loading several 3D models",
                    isCanToggle = false,
                    enabled = enableMultipleModels,
                    onCheckedChange = onChangeMultipleModels
                )
                HorizontalDivider(
                    modifier = Modifier
                        .padding(horizontal = 12.dp)
                        .alpha(0.2f),
                )
                VizblToggleButton(
                    title = "QR Scanner",
                    subtitle = "Allow display of the QR scanning button",
                    enabled = enableQRScan,
                    onCheckedChange = onChangeQRScan
                )
            }
        }

        Spacer(Modifier.height(24.dp))
        CategorySection(categoryName = stringResource(R.string.config_object_config_category)) {
            Column(
                modifier = Modifier
                    .clip(RoundedCornerShape(16.dp))
                    .background(MaterialTheme.colorScheme.surfaceVariant)
                    .padding(16.dp)
            ) {
                VizblToggleButton(
                    title = "Tap to Select",
                    subtitle = "Allow tapping objects to select them",
                    enabled = enableTap,
                    onCheckedChange = onChangeTap
                )
                HorizontalDivider(
                    modifier = Modifier
                        .padding(horizontal = 12.dp)
                        .alpha(0.2f),
                )
                VizblToggleButton(
                    title = "Move",
                    subtitle = "Enable drag gestures to move objects",
                    enabled = enableMove,
                    onCheckedChange = onChangeMove
                )
                HorizontalDivider(
                    modifier = Modifier
                        .padding(horizontal = 12.dp)
                        .alpha(0.2f),
                )
                VizblToggleButton(
                    modifier = Modifier.clickable(enabled = false, onClick = {}),
                    title = "Rotation",
                    subtitle = "Allow rotating objects with gestures",
                    enabled = enableRotation,
                    onCheckedChange = onChangeRotation
                )
            }
        }

        if (isShowAction) {
            Spacer(Modifier.height(24.dp))
            CategorySection(categoryName = stringResource(R.string.action_category)) {
                VizblLinkButton(
                    title = stringResource(R.string.advanced_open_ar_button),
                    onClick = onOpenAR
                )
            }
        }

        if (isShowModelAddButton) {
            Spacer(Modifier.height(24.dp))
            Card(
                modifier = modifier,
                shape = RoundedCornerShape(16.dp),
                colors = CardDefaults.cardColors(
                    containerColor = MaterialTheme.colorScheme.surfaceContainer
                )
            ) {
                VizblDropdown(
                    modifier = Modifier.padding(horizontal = 16.dp),
                    title = "Model",
                    subtitle = null,
                    selected = selectedQuality,
                    items = qualityItems,
                    onSelected = onQualityChanged
                )
            }
        }
    }
}