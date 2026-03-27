package com.us.vizbl.ar.sdk.demo.ui.component.button

import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.PaddingValues
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Switch
import androidx.compose.material3.SwitchDefaults
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.scale
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.style.TextOverflow
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import com.us.vizbl.ar.sdk.demo.ui.theme.AppTheme

@Composable
fun VizblToggleButton(
    modifier: Modifier = Modifier,
    title: String,
    subtitle: String? = null,
    isCanToggle: Boolean = true,
    enabled: Boolean,
    onCheckedChange: (Boolean) -> Unit
) {
    Row(
        modifier = modifier
            .fillMaxWidth()
            .padding(PaddingValues(vertical = 8.dp))
        ,
        verticalAlignment = Alignment.CenterVertically,
        horizontalArrangement = Arrangement.SpaceBetween,
    ) {
        Column(modifier = Modifier.weight(1f)) {
            Text(
                text = title,
                style = MaterialTheme.typography.bodyLarge,
                color = MaterialTheme.colorScheme.onSurfaceVariant,
                maxLines = 1,
                overflow = TextOverflow.Ellipsis,
                fontWeight = FontWeight.Medium
            )
            if (subtitle != null) {
                Text(
                    text = subtitle,
                    style = MaterialTheme.typography.bodySmall,
                    color = MaterialTheme.colorScheme.onSurfaceVariant.copy(alpha = 0.5f),
                    overflow = TextOverflow.Ellipsis
                )
            }
        }
        Switch(
            modifier = Modifier
                .scale(0.8f)
                .padding(start = 8.dp),
            enabled = isCanToggle,
            checked = enabled,
            onCheckedChange = {
                onCheckedChange(it)
            },
            colors = SwitchDefaults.colors(
                checkedThumbColor = MaterialTheme.colorScheme.primary,
                uncheckedThumbColor = MaterialTheme.colorScheme.outline,

                checkedTrackColor = MaterialTheme.colorScheme.primaryContainer,
                uncheckedTrackColor = MaterialTheme.colorScheme.surfaceVariant,

                uncheckedBorderColor = MaterialTheme.colorScheme.outline,
            )
        )
    }
}

@Preview
@Composable
private fun VizblToggleBoxPreview_Light() {
    AppTheme(darkTheme = false) {
        VizblToggleButton(title = "Tips enabled", subtitle = "Hello", enabled = true) {}
    }
}

@Preview
@Composable
private fun VizblToggleBoxPreview_Night() {
    AppTheme(darkTheme = true) {
        VizblToggleButton(title = "Tips enabled", subtitle = "Hello", enabled = true) {}
    }
}