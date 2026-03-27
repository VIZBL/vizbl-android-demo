package com.us.vizbl.ar.sdk.demo.ui.component

import androidx.compose.foundation.layout.*
import androidx.compose.material3.*
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import com.us.vizbl.ar.sdk.demo.ui.theme.AppTheme

@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun CategorySection(
    modifier: Modifier = Modifier,
    categoryName: String,
    content: @Composable ColumnScope.() -> Unit
) {
    Column(
        modifier = modifier.fillMaxWidth()
    ) {
        Text(
            text = categoryName,
            style = MaterialTheme.typography.titleMedium,
            fontWeight = FontWeight.SemiBold,
            color = MaterialTheme.colorScheme.primary,
            modifier = Modifier.padding(start = 16.dp, bottom = 8.dp)
        )

        Column(verticalArrangement = Arrangement.spacedBy(8.dp)) {
            content()
        }
    }
}

@Preview
@Composable
private fun CategorySectionPreview_Light() {
    AppTheme(darkTheme = false) {
        CategorySection(
            categoryName = "Getting started",
            content = {}
        )
    }
}

@Preview
@Composable
private fun CategorySectionPreview_Dark() {
    AppTheme(darkTheme = true) {
        CategorySection(
            categoryName = "Getting started",
            content = {}
        )
    }
}