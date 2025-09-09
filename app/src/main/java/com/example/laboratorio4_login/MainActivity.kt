package com.example.laboratorio4_login

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.runtime.Composable
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import androidx.navigation.compose.rememberNavController
import com.example.laboratorio4_login.presentation.login.LoginScreen
import com.example.laboratorio4_login.presentation.login.RegisterScreen
import com.example.laboratorio4_login.ui.theme.Laboratorio4LoginTheme
import com.example.laboratorio4_login.presentation.login.journal.JournalScreen
import com.example.laboratorio4_login.presentation.login.LoginScreen
import com.example.laboratorio4_login.ui.theme.Laboratorio4LoginTheme


class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            Laboratorio4LoginTheme {
                Navigation()
            }
        }
    }
}

const val ROUTE_LOGIN = "login"
const val ROUTE_REGISTER = "register"
const val ROUTE_JOURNAL = "journal"
const val ROUTE_HOME = "home"
const val ROUTE_ARTICLES = "articles"
const val ROUTE_PROFILE = "profile"


@Composable
fun Navigation() {
    val navController = rememberNavController()

    NavHost(
        navController = navController,
        startDestination = ROUTE_LOGIN
    ) {
        composable(ROUTE_LOGIN) {
            LoginScreen(navController = navController)
        }
        composable(ROUTE_REGISTER) {
            RegisterScreen(navController = navController)
        }
        composable(ROUTE_JOURNAL) {
            JournalScreen(
                navController = navController,
                mainNavController = navController
            )
        }
    }
}
