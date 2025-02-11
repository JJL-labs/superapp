package com.jetbrains.kmpapp.ui.navigation.destination

import androidx.navigation.NavType
import androidx.navigation.navArgument
import kotlinx.serialization.Serializable

sealed interface Destination {
    val route: String
}

@Serializable
data object Onboarding: Destination {
    override val route: String
        get() = "onboarding"
}

@Serializable
data object DetailDestination : Destination {
    override val route = "detail-destination"
    const val objectId = "objectId"
    val routeWithArgs = "$route/{$objectId}"
    val arguments = listOf(
        navArgument(objectId) {
            type = NavType.StringType
            nullable = true
        }
    )
}