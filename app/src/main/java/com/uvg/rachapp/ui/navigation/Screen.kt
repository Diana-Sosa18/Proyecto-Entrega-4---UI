package com.uvg.rachapp.ui.navigation

sealed class Screen(val route: String) {
    object Journal : Screen("journal")
    object News : Screen("news")
    object Home : Screen("home")
    object Profile : Screen("profile")
}
