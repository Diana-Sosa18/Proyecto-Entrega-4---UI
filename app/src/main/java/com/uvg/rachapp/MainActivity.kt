package com.uvg.rachapp

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.shape.CircleShape
import androidx.compose.material3.*
import androidx.compose.runtime.*
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.scale
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.navigation.compose.rememberNavController
import com.uvg.rachapp.ui.navigation.AppNavHost
import com.uvg.rachapp.ui.theme.RachAppTheme
import kotlinx.coroutines.launch
import com.uvg.rachapp.ui.screens.home.AppScreen
import com.uvg.rachapp.ui.navigation.AppNavigation
import com.uvg.rachapp.ui.navigation.AuthNavHost

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            RachAppTheme {
                var isLoggedIn by remember { mutableStateOf(false) } // Estado de autenticación
                val navController = rememberNavController()

                if (isLoggedIn) {
                    AppNavigation (
                        modifier = Modifier.fillMaxSize(),
                        onLogout = { isLoggedIn = false }
                        )
                } else {
                    AuthNavHost(
                        navController = navController,
                        modifier = Modifier.fillMaxSize(),
                        onLoginSuccess = { isLoggedIn = true })
                }
            }
        }
    }
}

@Composable
fun PlaceholderScreen(title: String) {
    Box(
        modifier = Modifier.fillMaxSize(),
        contentAlignment = Alignment.Center
    ) {
        Text(title)
    }
}

