package com.us.vizbl.ar.sdk.demo.ui.screens.shop

import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.rememberScrollState
import androidx.compose.foundation.verticalScroll
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.automirrored.filled.ArrowBack
import androidx.compose.material3.FilledTonalIconButton
import androidx.compose.material3.Icon
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Modifier
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
import com.us.vizbl.ar.sdk.demo.ui.component.VizblObjectListCard
import com.us.vizbl.ar.sdk.demo.ui.component.VizblSelectionToggle
import com.us.vizbl.ar.sdk.demo.ui.component.button.VizblLinkButton
import com.us.vizbl.ar.sdk.demo.ui.theme.AppTheme

@Composable
fun StoreIntegrationScreen(
    modifier: Modifier = Modifier,
    navController: NavHostController = rememberNavController()
) {
    val listOfModels = listOf<Pair<String, String>>(
        Pair("Modern Lamp", "d6742149-c4df-4ab5-81f4-233d31670284"),
        Pair("Round Table", "fae3b456-4b25-463c-bbdd-199286a35cd0"),
        Pair("Husk Armchair", "38a6f514-ea43-4673-8c8d-74061b873eb2"),
        Pair("Sarah - Breeze", "46714f6f-58c1-4c36-98e3-1d168c698c8d")
    )

    var selectedObjectId by remember {
        mutableStateOf(listOfModels.first().second)
    }

    Column(modifier =
        modifier
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
        Spacer(Modifier.height(40.dp))
        Text(
            text = stringResource(R.string.main_shop_preview_title),
            style = MaterialTheme.typography.headlineLarge,
            fontWeight = FontWeight.Bold,
        )
        Spacer(Modifier.height(32.dp))

        CategorySection(categoryName = stringResource(R.string.shop_preview_catalog_category)) {
            VizblObjectListCard(
                objectList = listOfModels,
                selectedObjectId = selectedObjectId,
                onObjectSelect = { newId -> selectedObjectId = newId }
            )
        }
        Spacer(Modifier.height(24.dp))

        CategorySection(categoryName = stringResource(R.string.shop_preview_mode_category)) {
            VizblSelectionToggle(
                selectedIndex = 1,
                isLocked = true
            ) {
                // TODO: Сделать переключение режима
            }
        }

        Spacer(Modifier.height(24.dp))

        CategorySection(categoryName = stringResource(R.string.action_category)) {
            VizblLinkButton(title = stringResource(R.string.advanced_open_ar_button)) {
                val selectedModel = listOfModels.find { it.second == selectedObjectId }?.second
                val configObject = selectedModel?.let {
                    LocalConfig(
                        objectId = it,
                        showObjectPanel = true,
                        enableScreenshot = true,
                        enableMultipleObjects = true,
                        enableQRScan = true
                    )
                }
                NavigationDataHolder.arConfig = configObject
                navController.navigate("ARScreen")
            }
        }
    }
}

@Preview
@Composable
private fun StoreIntegrationPreview() {
    AppTheme {
        StoreIntegrationScreen()
    }
}