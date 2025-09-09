package com.uvg.rachapp.ui.navigation


import androidx.compose.material3.*
import androidx.compose.runtime.*
import androidx.compose.ui.Modifier
import androidx.compose.ui.res.painterResource
import androidx.navigation.compose.rememberNavController
import com.uvg.rachapp.R
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.*
import androidx.compose.runtime.*

import androidx.compose.ui.graphics.Color
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.navigation.compose.rememberNavController

import androidx.compose.foundation.Image
import androidx.compose.ui.draw.alpha
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.unit.Dp
import androidx.compose.ui.Alignment
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.layout.Column

@Composable
fun AppNavigation(
    modifier: Modifier = Modifier,
    onLogout: () -> Unit
) {
    val navController = rememberNavController()
    var selectedTab by remember { mutableStateOf(Screen.Home.route) }

    val tabItems = listOf(
        Screen.Journal to R.drawable.journal_con_fondo,
        Screen.News to R.drawable.noticias_con_fondo,
        Screen.Home to R.drawable.home_con_fondo,
        Screen.Profile to R.drawable.perfil_con_fondo
    )

    Scaffold(
        bottomBar = {
            NavigationBar(containerColor = MaterialTheme.colorScheme.primary) {
                tabItems.forEach { (screen, iconRes) ->
                    val isSelected = selectedTab == screen.route

                    NavigationBarItem(
                        selected = isSelected,
                        onClick = {
                            selectedTab = screen.route
                            navController.navigate(screen.route) {
                                popUpTo(navController.graph.startDestinationId) {
                                    saveState = true
                                }
                                launchSingleTop = true
                                restoreState = true
                            }
                        },
                        icon = {
                            Column(
                                horizontalAlignment = Alignment.CenterHorizontally
                            ) {
                                val iconSize: Dp = if (isSelected) 20.dp else 24.dp
                                val iconAlpha = if (isSelected) 1f else 0.5f

                                Image(
                                    painter = painterResource(id = iconRes),
                                    contentDescription = screen.route,
                                    modifier = Modifier
                                        .size(iconSize)
                                        .alpha(iconAlpha),
                                    contentScale = ContentScale.Fit
                                )

                                if (isSelected) {
                                    Text(
                                        text = screen.route,
                                        color = Color.White,
                                        fontSize = 10.sp
                                    )
                                }
                            }
                        },
                        label = null // Ocultamos el label del NavigationBarItem porque lo agregamos manualmente
                    )
                }
            }
        }
    ) { padding ->
        AppNavHost(
            navController = navController,
            modifier = modifier.padding(padding),
            onLogout = onLogout
        )
    }
}