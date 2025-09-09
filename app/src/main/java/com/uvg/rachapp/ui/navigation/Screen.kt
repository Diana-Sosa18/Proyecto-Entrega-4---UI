package com.uvg.rachapp.ui.navigation

sealed class Screen(val route: String) {
    // Auth
    object Login : Screen("login")
    object Register : Screen("register")

    // Main
    object Journal : Screen("journal")
    object News : Screen("news")
    object Home : Screen("home")
    object Profile : Screen("profile")
}
