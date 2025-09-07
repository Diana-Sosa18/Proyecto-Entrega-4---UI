package com.uvg.rachapp.ui.navigation

import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.navigation.NavHostController
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import com.uvg.rachapp.ui.screens.home.HomeScreen
import com.uvg.rachapp.ui.screens.journal.JournalScreen
import com.uvg.rachapp.ui.screens.news.NewsScreen
import com.uvg.rachapp.ui.screens.profile.ProfileScreen

@Composable
fun AppNavHost(
    navController: NavHostController,
    modifier: Modifier = Modifier,
    startDestination: String = Screen.Home.route
) {
    NavHost(
        navController = navController,
        startDestination = startDestination,
        modifier = modifier
    ) {
        composable(Screen.Journal.route) { JournalScreen() }
        composable(Screen.News.route) { NewsScreen() }
        composable(Screen.Home.route) { HomeScreen() }
        composable(Screen.Profile.route) { ProfileScreen() }
    }
}
