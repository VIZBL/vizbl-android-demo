package com.us.vizbl.ar.sdk.demo.ui.component.sheet

import androidx.compose.foundation.layout.PaddingValues
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.ModalBottomSheet
import androidx.compose.material3.Text
import androidx.compose.material3.rememberModalBottomSheetState
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import com.us.vizbl.ar.sdk.api.ARPlacedObject
import com.us.vizbl.ar.sdk.api.InstanceId
import com.us.vizbl.ar.sdk.demo.R
import com.us.vizbl.ar.sdk.demo.ui.theme.AppTheme

@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun ManageModelSheet(
    modifier: Modifier = Modifier,
    placedModels: List<ARPlacedObject> = emptyList(),
    onAddModel: (String) -> Unit,
    onRemoveModel: (InstanceId) -> Unit,
    onDismiss: () -> Unit
) {
    val sheetState = rememberModalBottomSheetState()

    ModalBottomSheet(
        sheetState = sheetState,
        onDismissRequest = onDismiss
    ) {
        LazyColumn(
            modifier = modifier,
            contentPadding = PaddingValues(horizontal = 16.dp, vertical = 16.dp)
        ) {
            item {
                Text(
                    text = stringResource(R.string.add_manage_title),
                    style = MaterialTheme.typography.headlineLarge,
                    fontWeight = FontWeight.Bold,
                )
                Spacer(Modifier.height(32.dp))
            }

            item {
                AddObjectSection(onAddModel = onAddModel)
                Spacer(Modifier.height(24.dp))
            }

            placedObjectsSection(
                placedModels = placedModels,
                onRemoveModel = onRemoveModel
            )
        }
    }
}