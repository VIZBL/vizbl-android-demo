package com.us.vizbl.ar.sdk.demo.ui.component

import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.PaddingValues
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Text
import androidx.compose.material3.TextButton
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import com.us.vizbl.ar.sdk.api.ARPlacedObject
import com.us.vizbl.ar.sdk.api.InstanceId
import com.us.vizbl.ar.sdk.demo.ui.theme.AppTheme

@Composable
fun PlacedModel(
    modifier: Modifier = Modifier,
    model: ARPlacedObject,
    onRemoveClick: () -> Unit,
    onFavoriteClick: () -> Unit
) {
    Column(
        modifier = modifier
            .fillMaxWidth()
            .clip(RoundedCornerShape(24.dp))
            .background(MaterialTheme.colorScheme.secondary)
            .padding(top = 16.dp, start = 16.dp, end = 16.dp, bottom = 8.dp)
    ) {
        Text(
            text = model.name ?: model.instanceId.value,
            style = MaterialTheme.typography.titleMedium,
            fontWeight = FontWeight.Bold,
            color = MaterialTheme.colorScheme.onSecondary
        )

        if (model.name != null) {
            Text(
                text = "instanceId: ${model.instanceId.value}",
                style = MaterialTheme.typography.bodySmall,
                color = MaterialTheme.colorScheme.onSecondary.copy(alpha = 0.6f)
            )
        }

        Text(
            text = "objectId: ${model.objectId ?: model.tinuuid}",
            style = MaterialTheme.typography.bodySmall,
            color = MaterialTheme.colorScheme.onSecondary.copy(alpha = 0.6f)
        )

        Text(
            text = "materialHid: ${model.materialHid}",
            style = MaterialTheme.typography.bodySmall,
            color = MaterialTheme.colorScheme.onSecondary.copy(alpha = 0.6f)
        )

        Spacer(Modifier.height(8.dp))

        Row(
            modifier = Modifier.fillMaxWidth(),
            horizontalArrangement = Arrangement.SpaceBetween
        ) {
            TextButton(
                onClick = onRemoveClick,
                contentPadding = PaddingValues(0.dp)
            ) {
                Text(
                    text = "Remove",
                    style = MaterialTheme.typography.bodyLarge,
                    color = Color(0xFFEF5350)
                )
            }

            TextButton(
                onClick = onFavoriteClick,
                contentPadding = PaddingValues(0.dp)
            ) {
                Text(
                    text = "Favorite",
                    style = MaterialTheme.typography.bodyLarge,
                    color = Color(0xFF2196F3)
                )
            }
        }
    }
}

@Preview
@Composable
private fun PlacedModelPreview_Light() {
    AppTheme(darkTheme = false) {
        PlacedModel(
            model = ARPlacedObject(instanceId = InstanceId(""), null, null, null, null),
            onRemoveClick = {},
            onFavoriteClick = {}
        )
    }
}

@Preview
@Composable
private fun PlacedModelPreview_Night() {
    AppTheme(darkTheme = true) {
        PlacedModel(
            model = ARPlacedObject(instanceId = InstanceId(""), null, null, null, null),
            onRemoveClick = {},
            onFavoriteClick = {}
        )
    }
}