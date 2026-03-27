package com.us.vizbl.ar.sdk.demo.ui.screens.quick_start

import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.automirrored.filled.ArrowBack
import androidx.compose.material3.FilledTonalIconButton
import androidx.compose.material3.Icon
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
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
import com.us.vizbl.ar.sdk.demo.ui.component.button.VizblSmallButton
import com.us.vizbl.ar.sdk.demo.ui.theme.AppTheme

@Composable
fun QuickStartScreen(
    modifier: Modifier = Modifier,
    navController: NavHostController = rememberNavController()
) {
    Column(modifier = modifier.fillMaxSize().padding(horizontal = 16.dp)) {
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
            text = stringResource(R.string.main_quick_start_title),
            style = MaterialTheme.typography.headlineLarge,
            fontWeight = FontWeight.Bold,
            color = MaterialTheme.colorScheme.onSurface
        )
        Spacer(Modifier.height(56.dp))

        Column(modifier = Modifier.fillMaxWidth(), horizontalAlignment = Alignment.CenterHorizontally) {
            Text(
                text = stringResource(R.string.quick_start_title),
                style = MaterialTheme.typography.bodyLarge,
                fontWeight = FontWeight.Medium,
                color = MaterialTheme.colorScheme.onSurface
            )
            Text(
                text = stringResource(R.string.quick_start_body),
                style = MaterialTheme.typography.bodySmall,
                fontWeight = FontWeight.Normal,
                color = MaterialTheme.colorScheme.onSurfaceVariant
            )
            Spacer(Modifier.height(12.dp))
            VizblSmallButton(text = stringResource(R.string.quick_start_button)) {
                val configObject = LocalConfig(
                    objectId = "d6742149-c4df-4ab5-81f4-233d31670284",
                    enableScreenshot = true,
                    enableMultipleObjects = false
                )
                NavigationDataHolder.arConfig = configObject
                navController.navigate("ARScreen")
            }
        }
    }
}

@Preview(showBackground = true)
@Composable
private fun QuickStartScreenPreview_Light() {
    AppTheme(darkTheme = false) {
        QuickStartScreen()
    }
}

@Preview
@Composable
private fun QuickStartScreenPreview_Night() {
    AppTheme(darkTheme = true) {
        QuickStartScreen()
    }
}