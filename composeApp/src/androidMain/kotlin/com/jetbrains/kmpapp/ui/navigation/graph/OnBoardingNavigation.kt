package com.jetbrains.kmpapp.ui.navigation.graph


import OnBoardingScreen
import androidx.navigation.NavController
import androidx.navigation.NavGraphBuilder
import androidx.navigation.compose.composable
import com.jetbrains.kmpapp.screens.ListViewModel
import com.jetbrains.kmpapp.ui.navigation.destination.Onboarding
import org.koin.androidx.compose.koinViewModel

fun NavGraphBuilder.onBoardingNavigation(navController: NavController) {

    composable(route = Onboarding.route) {

        val viewModel: ListViewModel = koinViewModel()

        OnBoardingScreen(onClick = {})

    }
}