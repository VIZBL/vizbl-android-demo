package com.us.vizbl.ar.sdk.demo.ui.component

import androidx.annotation.StringRes
import androidx.compose.foundation.layout.PaddingValues
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.LargeTopAppBar
import androidx.compose.material3.ListItem
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Text
import androidx.compose.material3.TopAppBarDefaults
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.input.nestedscroll.nestedScroll
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.style.TextOverflow
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import com.us.vizbl.ar.sdk.demo.R
import com.us.vizbl.ar.sdk.demo.ui.component.button.VizblBackButton
import com.us.vizbl.ar.sdk.demo.ui.theme.AppTheme

@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun Header(
    @StringRes title: Int,
    paddingValues: PaddingValues,
    content: @Composable (innerPadding: PaddingValues) -> Unit,
    onBackClick: () -> Unit
) {
    val scrollBehavior = TopAppBarDefaults.exitUntilCollapsedScrollBehavior()
    val collapsedFraction = scrollBehavior.state.collapsedFraction

    Scaffold(
        modifier = Modifier
            .padding(paddingValues)
            .nestedScroll(scrollBehavior.nestedScrollConnection),
        topBar = {
            LargeTopAppBar(
                title = {
                    Text(
                        modifier = Modifier.padding(start = if (collapsedFraction > 0.5f) 12.dp else 0.dp),
                        text = stringResource(title),
                        style = if (collapsedFraction > 0.5f)
                            MaterialTheme.typography.titleLarge
                        else
                            MaterialTheme.typography.headlineLarge,
                        maxLines = 1,
                        overflow = TextOverflow.Ellipsis,
                        fontWeight = FontWeight.Bold,
                    )
                },
                navigationIcon = {
                    VizblBackButton(onClick = onBackClick)
                },
                scrollBehavior = scrollBehavior,
                colors = TopAppBarDefaults.largeTopAppBarColors(
                    scrolledContainerColor = MaterialTheme.colorScheme.background
                )
            )
        }
    ) { innerPadding ->
        content(innerPadding)
    }
}

@Preview
@Composable
private fun HeaderPreview_Light() {
    AppTheme(darkTheme = false) {
        Header(
            title = R.string.main_quick_start_title,
            paddingValues = PaddingValues(),
            content = {
                LazyColumn(
                    contentPadding = it,
                    modifier = Modifier.fillMaxSize()
                ) {
                    items(50) { index ->
                        ListItem(
                            headlineContent = { Text("Параметр настройки $index") },
                            supportingContent = { Text("Описание того, как это влияет на AR") }
                        )
                    }
                }
            },
            onBackClick = {}
        )
    }
}

@Preview
@Composable
private fun HeaderPreview_Night() {
    AppTheme(darkTheme = true) {
        Header(
            title = R.string.main_quick_start_title,
            paddingValues = PaddingValues(),
            content = {
                LazyColumn(
                    contentPadding = it,
                    modifier = Modifier.fillMaxSize()
                ) {
                    items(50) { index ->
                        ListItem(
                            headlineContent = { Text("Параметр настройки $index") },
                            supportingContent = { Text("Описание того, как это влияет на AR") }
                        )
                    }
                }
            },
            onBackClick = {}
        )
    }
}