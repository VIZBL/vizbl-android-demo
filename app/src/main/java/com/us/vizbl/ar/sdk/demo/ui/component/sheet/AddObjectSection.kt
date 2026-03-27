package com.us.vizbl.ar.sdk.demo.ui.component.sheet

import androidx.compose.animation.core.Spring
import androidx.compose.animation.core.spring
import androidx.compose.animation.core.tween
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.lazy.LazyListScope
import androidx.compose.foundation.lazy.items
import androidx.compose.material3.HorizontalDivider
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.alpha
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.dp
import com.us.vizbl.ar.sdk.api.ARPlacedObject
import com.us.vizbl.ar.sdk.api.InstanceId
import com.us.vizbl.ar.sdk.demo.R
import com.us.vizbl.ar.sdk.demo.ui.component.PlacedModel
import com.us.vizbl.ar.sdk.demo.ui.component.VizblCategory
import com.us.vizbl.ar.sdk.demo.ui.component.button.VizblAddButton

@Composable
fun AddObjectSection(
    onAddModel: (String) -> Unit
) {
    VizblCategory(category = R.string.manage_sheet_add_object_category) {
        Column {
            VizblAddButton(title = "Modern Lamp") {
                onAddModel("d6742149-c4df-4ab5-81f4-233d31670284")
            }
            HorizontalDivider(modifier = Modifier.padding(horizontal = 12.dp).alpha(0.2f))

            VizblAddButton(title = "Round Table") {
                onAddModel("fae3b456-4b25-463c-bbdd-199286a35cd0")
            }
            HorizontalDivider(modifier = Modifier.padding(horizontal = 12.dp).alpha(0.2f))

            VizblAddButton(title = "Husk Armchair") {
                onAddModel("38a6f514-ea43-4673-8c8d-74061b873eb2")
            }
            HorizontalDivider(modifier = Modifier.padding(horizontal = 12.dp).alpha(0.2f))

            VizblAddButton(title = "Sarah - Breeze") {
                onAddModel("46714f6f-58c1-4c36-98e3-1d168c698c8d")
            }
        }
    }
}

fun LazyListScope.placedObjectsSection(
    placedModels: List<ARPlacedObject>,
    onRemoveModel: (InstanceId) -> Unit
) {
    if (placedModels.isNotEmpty()) {
        item {
            Text(
                modifier = Modifier.padding(horizontal = 16.dp),
                text = stringResource(R.string.manage_sheet_placed_objects_category),
                fontWeight = FontWeight.Medium,
                style = MaterialTheme.typography.bodyLarge,
                color = MaterialTheme.colorScheme.secondary
            )
            Spacer(Modifier.height(8.dp))
        }
        items(
            items = placedModels,
            key = { it.instanceId.value }
        ) { model ->
            Box(
                modifier = Modifier
                    .animateItem(
                        fadeInSpec = tween(300),
                        fadeOutSpec = tween(300),
                        placementSpec = spring(stiffness = Spring.StiffnessLow)
                    )
                    .padding(bottom = 16.dp)
            ) {
                PlacedModel(
                    model = model,
                    onRemoveClick = { onRemoveModel(model.instanceId) },
                    onFavoriteClick = { /* TODO */ }
                )
            }
        }

        item {
            Spacer(Modifier.height(32.dp))
        }
    }
}