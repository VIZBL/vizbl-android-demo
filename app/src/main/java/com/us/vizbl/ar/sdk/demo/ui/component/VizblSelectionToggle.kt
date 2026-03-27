package com.us.vizbl.ar.sdk.demo.ui.component

import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.SegmentedButton
import androidx.compose.material3.SegmentedButtonDefaults
import androidx.compose.material3.SingleChoiceSegmentedButtonRow
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableIntStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import com.us.vizbl.ar.sdk.demo.ui.theme.AppTheme

@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun VizblSelectionToggle(
    modifier: Modifier = Modifier,
    options: List<String> = listOf("Single", "Multiple"),
    selectedIndex: Int,
    isLocked: Boolean = false,
    onSelectionChange: (Int) -> Unit
) {
    SingleChoiceSegmentedButtonRow(
        modifier = modifier.fillMaxWidth()
    ) {
        options.forEachIndexed { index, label ->
            SegmentedButton(
                enabled = !isLocked || index == selectedIndex,
                shape = SegmentedButtonDefaults.itemShape(index = index, count = options.size),
                onClick = {
                    if (!isLocked && index != selectedIndex) {
                        onSelectionChange(index)
                    }
                },
                selected = index == selectedIndex,
                colors = SegmentedButtonDefaults.colors(
                    activeBorderColor = MaterialTheme.colorScheme.surfaceVariant,
                    inactiveBorderColor = MaterialTheme.colorScheme.surfaceVariant,
                    disabledActiveBorderColor = MaterialTheme.colorScheme.surfaceVariant,
                    disabledInactiveBorderColor = MaterialTheme.colorScheme.surfaceVariant,

                    activeContainerColor = MaterialTheme.colorScheme.surfaceVariant,
                    activeContentColor = MaterialTheme.colorScheme.onSurfaceVariant,

                    inactiveContainerColor = MaterialTheme.colorScheme.surfaceVariant.copy(alpha = 5f),
                    inactiveContentColor = MaterialTheme.colorScheme.onSurfaceVariant.copy(alpha = 5f),
                )
            ) {
                Text(
                    text = label,
                    style = MaterialTheme.typography.bodyMedium,
                    fontWeight = FontWeight.Medium
                )
            }
        }
    }
}

@Preview(showBackground = true)
@Composable
private fun VizblSelectionTogglePreview_Light() {
    AppTheme(darkTheme = false) {
        var selected by remember { mutableIntStateOf(0) }

        VizblSelectionToggle(
            selectedIndex = selected,
            onSelectionChange = { selected = it },
            modifier = Modifier.padding(16.dp)
        )
    }
}

@Preview(showBackground = true)
@Composable
private fun VizblSelectionTogglePreview_Night() {
    AppTheme(darkTheme = true) {
        var selected by remember { mutableIntStateOf(1) }

        VizblSelectionToggle(
            selectedIndex = selected,
            onSelectionChange = { selected = it },
            modifier = Modifier.padding(16.dp)
        )
    }
}