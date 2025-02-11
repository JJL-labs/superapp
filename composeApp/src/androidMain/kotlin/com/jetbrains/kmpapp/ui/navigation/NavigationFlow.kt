package com.jetbrains.kmpapp.ui.navigation

import androidx.compose.runtime.Composable
import androidx.navigation.NavHostController
import androidx.navigation.compose.NavHost
import com.jetbrains.kmpapp.ui.navigation.destination.Onboarding
import com.jetbrains.kmpapp.ui.navigation.graph.onBoardingNavigation

@Composable
fun MainNavigation(navController: NavHostController) {

    NavHost(navController = navController, startDestination = Onboarding.route) {
        onBoardingNavigation(navController)
    }
}