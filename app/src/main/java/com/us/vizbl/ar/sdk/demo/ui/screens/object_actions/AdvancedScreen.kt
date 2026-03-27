package com.us.vizbl.ar.sdk.demo.ui.screens.object_actions

import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.rememberScrollState
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.foundation.verticalScroll
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.automirrored.filled.ArrowBack
import androidx.compose.material.icons.filled.AddCircle
import androidx.compose.material.icons.filled.Delete
import androidx.compose.material.icons.filled.Refresh
import androidx.compose.material.icons.filled.Warning
import androidx.compose.material3.FilledTonalIconButton
import androidx.compose.material3.Icon
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.navigation.NavHostController
import androidx.navigation.compose.rememberNavController
import com.us.vizbl.ar.sdk.demo.R
import com.us.vizbl.ar.sdk.demo.core.LocalConfig
import com.us.vizbl.ar.sdk.demo.core.NavigationDataHolder
import com.us.vizbl.ar.sdk.demo.ui.component.CategorySection
import com.us.vizbl.ar.sdk.demo.ui.component.VizblSelectionToggle
import com.us.vizbl.ar.sdk.demo.ui.component.button.VizblLinkButton
import com.us.vizbl.ar.sdk.demo.ui.theme.AppTheme

@Composable
fun AdvancedScreen(
    modifier: Modifier = Modifier,
    navController: NavHostController = rememberNavController()
) {
    Column(
        modifier = modifier
            .fillMaxSize()
            .padding(horizontal = 16.dp)
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
        Text(
            text = stringResource(R.string.advanced_headline),
            style = MaterialTheme.typography.headlineLarge,
            fontWeight = FontWeight.Bold
        )

        Spacer(Modifier.height(24.dp))
        CategorySection(categoryName = stringResource(R.string.advanced_info_category)) {
            Box(modifier =
                Modifier
                    .clip(RoundedCornerShape(16.dp))
                    .background(MaterialTheme.colorScheme.surfaceVariant)
                    .padding(16.dp)
            ) {
                Text(
                    text = stringResource(R.string.advanced_info),
                    style = MaterialTheme.typography.bodyMedium,
                    color = MaterialTheme.colorScheme.onSurfaceVariant
                )
            }
        }

        Spacer(Modifier.height(24.dp))
        CategorySection(categoryName = stringResource(R.string.advanced_mode_category)) {
            VizblSelectionToggle(
                selectedIndex = 1,
                isLocked = true
            ) {
                // TODO: Сделать переключение режима
            }
        }

        Spacer(Modifier.height(24.dp))
        CategorySection(categoryName = stringResource(R.string.advanced_available_in_ar_category)) {
            Column(modifier =
                Modifier
                    .fillMaxWidth()
                    .clip(RoundedCornerShape(16.dp))
                    .background(MaterialTheme.colorScheme.surfaceVariant)
                    .padding(16.dp)
            ) {
                Row {
                    Icon(
                        imageVector = Icons.Default.AddCircle,
                        contentDescription = null,
                        modifier = Modifier.size(20.dp),
                        tint = MaterialTheme.colorScheme.onSurfaceVariant
                    )
                    Spacer(Modifier.width(8.dp))
                    Column {
                        Text(
                            text = stringResource(R.string.advanced_add_button_title),
                            style = MaterialTheme.typography.bodyLarge,
                            color = MaterialTheme.colorScheme.onSurfaceVariant,
                            fontWeight = FontWeight.Medium

                        )
                        Text(
                            text = stringResource(R.string.advanced_add_button_body),
                            style = MaterialTheme.typography.bodyMedium,
                            color = MaterialTheme.colorScheme.onSurfaceVariant.copy(alpha = 0.5f)
                        )
                    }
                }
                Spacer(modifier = Modifier.height(16.dp))
                Row {
                    Icon(
                        imageVector = Icons.Default.Refresh,
                        contentDescription = null,
                        modifier = Modifier.size(20.dp),
                        tint = MaterialTheme.colorScheme.onSurfaceVariant
                    )
                    Spacer(Modifier.width(8.dp))
                    Column {
                        Text(
                            text = stringResource(R.string.advanced_replace_title),
                            style = MaterialTheme.typography.bodyLarge,
                            color = MaterialTheme.colorScheme.onSurfaceVariant,
                            fontWeight = FontWeight.Medium

                        )
                        Text(
                            text = stringResource(R.string.advanced_replace_body),
                            style = MaterialTheme.typography.bodyMedium,
                            color = MaterialTheme.colorScheme.onSurfaceVariant.copy(alpha = 0.5f)
                        )
                    }
                }
                Spacer(modifier = Modifier.height(16.dp))
                Row {
                    Icon(
                        imageVector = Icons.Default.Delete,
                        contentDescription = null,
                        modifier = Modifier.size(20.dp),
                        tint = MaterialTheme.colorScheme.onSurfaceVariant
                    )
                    Spacer(Modifier.width(8.dp))
                    Column {
                        Text(
                            text = stringResource(R.string.advanced_remove_title),
                            style = MaterialTheme.typography.bodyLarge,
                            color = MaterialTheme.colorScheme.onSurfaceVariant,
                            fontWeight = FontWeight.Medium

                        )
                        Text(
                            text = stringResource(R.string.advanced_remove_body),
                            style = MaterialTheme.typography.bodyMedium,
                            color = MaterialTheme.colorScheme.onSurfaceVariant.copy(alpha = 0.5f)
                        )
                    }
                }
                Spacer(modifier = Modifier.height(16.dp))
                Row {
                    Icon(
                        imageVector = Icons.Default.Warning,
                        contentDescription = null,
                        modifier = Modifier.size(20.dp),
                        tint = MaterialTheme.colorScheme.onSurfaceVariant
                    )
                    Spacer(Modifier.width(8.dp))
                    Column {
                        Text(
                            text = stringResource(R.string.advanced_error_title),
                            style = MaterialTheme.typography.bodyLarge,
                            color = MaterialTheme.colorScheme.onSurfaceVariant,
                            fontWeight = FontWeight.Medium

                        )
                        Text(
                            text = stringResource(R.string.advanced_error_body),
                            style = MaterialTheme.typography.bodyMedium,
                            color = MaterialTheme.colorScheme.onSurfaceVariant.copy(alpha = 0.5f)
                        )
                    }
                }
            }
        }
        Spacer(Modifier.height(24.dp))

        CategorySection(categoryName = stringResource(R.string.action_category)) {
            VizblLinkButton(title = stringResource(R.string.advanced_open_ar_button)) {
                val configObject = LocalConfig(
                    objectId = "d6742149-c4df-4ab5-81f4-233d31670284",
                    showObjectPanel = true,
                    enableScreenshot = true,
                    enableMultipleObjects = true
                )
                NavigationDataHolder.arConfig = configObject
                navController.navigate("ARScreen")
            }
        }
        Spacer(Modifier.height(32.dp))
    }
}

@Preview
@Composable
private fun AdvancedScreenPreview_Light() {
    AppTheme(darkTheme = false) {
        AdvancedScreen()
    }
}

@Preview
@Composable
private fun AdvancedScreenPreview_Night() {
    AppTheme(darkTheme = true) {
        AdvancedScreen()
    }
}