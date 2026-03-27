package com.us.vizbl.ar.sdk.demo.ui.screens.main

import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.rememberScrollState
import androidx.compose.foundation.verticalScroll
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.navigation.NavHostController
import androidx.navigation.compose.rememberNavController
import com.us.vizbl.ar.sdk.demo.R
import com.us.vizbl.ar.sdk.demo.ui.component.CategorySection
import com.us.vizbl.ar.sdk.demo.ui.component.VizblCategory
import com.us.vizbl.ar.sdk.demo.ui.component.button.VizblLinkButton
import com.us.vizbl.ar.sdk.demo.ui.theme.AppTheme

@Composable
fun MainScreen(
    modifier: Modifier = Modifier,
    navController: NavHostController = rememberNavController()
) {
    Column(
        modifier = modifier
            .fillMaxSize()
            .padding(horizontal = 16.dp)
            .verticalScroll(rememberScrollState())
    ) {
        Spacer(Modifier.height(56.dp))
        Text(
            text = "Vizbl SDK",
            style = MaterialTheme.typography.displayMedium,
            fontWeight = FontWeight.Bold,
        )
        Spacer(Modifier.height(24.dp))

        CategorySection(categoryName = stringResource(R.string.main_getting_started_category)) {
            VizblLinkButton(
                title = stringResource(R.string.main_quick_start_title),
                subtitle = stringResource(R.string.main_quick_start_body)
            ) {
                navController.navigate("QuickStartScreen")
            }
        }

        Spacer(Modifier.height(24.dp))

        CategorySection(categoryName = stringResource(R.string.main_shop_integration_category)) {
            VizblLinkButton(
                title = stringResource(R.string.main_shop_preview_title),
                subtitle = stringResource(R.string.main_shop_preview_body)
            ) {
                navController.navigate("StoreIntegrationScreen")
            }
        }

        Spacer(Modifier.height(24.dp))

        CategorySection(categoryName = stringResource(R.string.main_configuration_lab_category)) {
            VizblLinkButton(
                title = stringResource(R.string.main_configuration_lab_title),
                subtitle = stringResource(R.string.main_configuration_lab_body)
            ) {
                navController.navigate("ConfiguratorScreen")
            }
        }

        Spacer(Modifier.height(24.dp))

        CategorySection(categoryName = stringResource(R.string.main_advanced_category)) {
            VizblLinkButton(
                title = stringResource(R.string.main_object_actions_title),
                subtitle = stringResource(R.string.main_object_actions_body)
            ) {
                navController.navigate("AdvancedScreen")
            }
        }
    }
}



@Preview(showBackground = true, showSystemUi = true)
@Composable
private fun MainScreenPreview_Light() {
    AppTheme(darkTheme = false) {
        MainScreen()
    }
}

@Preview(showBackground = true, showSystemUi = true)
@Composable
private fun MainScreenPreview_Night() {
    AppTheme(darkTheme = true) {
        MainScreen()
    }
}