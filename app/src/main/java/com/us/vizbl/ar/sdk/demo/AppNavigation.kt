package com.us.vizbl.ar.sdk.demo

import androidx.compose.animation.core.tween
import androidx.compose.animation.fadeIn
import androidx.compose.animation.fadeOut
import androidx.compose.animation.slideInHorizontally
import androidx.compose.animation.slideOutHorizontally
import androidx.compose.foundation.layout.PaddingValues
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.padding
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import androidx.navigation.compose.rememberNavController
import com.us.vizbl.ar.sdk.demo.core.LocalConfig
import com.us.vizbl.ar.sdk.demo.core.NavigationDataHolder
import com.us.vizbl.ar.sdk.demo.ui.screens.ar.ARScreen
import com.us.vizbl.ar.sdk.demo.ui.screens.configuration.ConfiguratorScreen
import com.us.vizbl.ar.sdk.demo.ui.screens.main.MainScreen
import com.us.vizbl.ar.sdk.demo.ui.screens.object_actions.AdvancedScreen
import com.us.vizbl.ar.sdk.demo.ui.screens.quick_start.QuickStartScreen
import com.us.vizbl.ar.sdk.demo.ui.screens.shop.StoreIntegrationScreen

@Composable
fun AppNavigation(paddingValues: PaddingValues) {
    val navController = rememberNavController()
    NavHost(
        navController = navController,
        modifier = Modifier.fillMaxSize(),
        startDestination = "MainScreen",
        // Animation
        enterTransition = {
            slideInHorizontally(initialOffsetX = { it }) + fadeIn(animationSpec = tween(300))
        },
        exitTransition = {
            slideOutHorizontally(targetOffsetX = { -it }) + fadeOut(animationSpec = tween(300))
        },
        popEnterTransition = {
            slideInHorizontally(initialOffsetX = { -it }) + fadeIn(animationSpec = tween(300))
        },
        popExitTransition = {
            slideOutHorizontally(targetOffsetX = { it }) + fadeOut(animationSpec = tween(300))
        }
    ) {
        composable("MainScreen") {
            MainScreen(
                modifier = Modifier.padding(paddingValues),
                navController = navController
            )
        }

        composable("QuickStartScreen") {
            QuickStartScreen(
                modifier = Modifier.padding(paddingValues),
                navController = navController
            )
        }

        composable("StoreIntegrationScreen") {
            StoreIntegrationScreen(
                modifier = Modifier.padding(paddingValues),
                navController = navController
            )
        }

        composable("ConfiguratorScreen") {
            ConfiguratorScreen(
                modifier = Modifier.padding(paddingValues),
                navController = navController
            )
        }

        composable("AdvancedScreen") {
            AdvancedScreen(
                modifier = Modifier.padding(paddingValues),
                navController = navController
            )
        }

        composable(
            route = "ARScreen"
        ) {
            val config = NavigationDataHolder.arConfig ?: LocalConfig(
                objectId = "d6742149-c4df-4ab5-81f4-233d31670284"
            )
            ARScreen(
                navController = navController,
                localConfig = config
            )
        }
    }
}
