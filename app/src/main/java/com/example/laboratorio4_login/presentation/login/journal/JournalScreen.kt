package com.example.laboratorio4_login.presentation.login.journal


import androidx.compose.foundation.Image
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Text
import androidx.compose.material3.TopAppBar
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.NavigationBar
import androidx.compose.material3.NavigationBarItem
import androidx.compose.material3.NavigationBarItemDefaults
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.alpha
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.unit.dp
import androidx.navigation.NavController
import androidx.navigation.compose.currentBackStackEntryAsState
import com.example.laboratorio4_login.R
import com.example.laboratorio4_login.ROUTE_ARTICLES
import com.example.laboratorio4_login.ROUTE_HOME
import com.example.laboratorio4_login.ROUTE_JOURNAL
import com.example.laboratorio4_login.ROUTE_PROFILE
import com.example.laboratorio4_login.presentation.login.BottomNavItem

@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun JournalScreen(navController: NavController, mainNavController: NavController) {

    val bottomNavItems = listOf(
        BottomNavItem(
            label = stringResource(id = R.string.bottom_nav_journal), // "Diario"
            iconResId = R.drawable.iconjournal,
            route = ROUTE_JOURNAL
        ),
        BottomNavItem(
            label = stringResource(id = R.string.bottom_nav_articles), // "Artículos"
            iconResId = R.drawable.iconarticles,
            route = ROUTE_ARTICLES
        ),
        BottomNavItem(
            label = stringResource(id = R.string.bottom_nav_home), // "Inicio"
            iconResId = R.drawable.iconhome,
            route = ROUTE_HOME
        ),
        BottomNavItem(
            label = stringResource(id = R.string.bottom_nav_profile), // "Perfil"
            iconResId = R.drawable.iconprofile,
            route = ROUTE_PROFILE
        )
    )
    val navBackStackEntry by mainNavController.currentBackStackEntryAsState()
    val currentRoute = navBackStackEntry?.destination?.route


    //navegacion principal
    Scaffold(
        topBar = {
            TopAppBar(title = {
                Text(text = stringResource(id = R.string.title_journal_screen))
            })
        },

        bottomBar = {
            NavigationBar(

                containerColor = MaterialTheme.colorScheme.primary
            ) {
                bottomNavItems.forEach { item ->
                    val isSelected = currentRoute == item.route
                    NavigationBarItem(
                        selected = isSelected,
                        onClick = {
                            if (currentRoute != item.route) { // Evita navegar a la misma pantalla
                                mainNavController.navigate(item.route) {

                                    popUpTo(mainNavController.graph.startDestinationId) {
                                        saveState = true
                                    }

                                    launchSingleTop = true

                                    restoreState = true
                                }
                            }
                        },
                        icon = {
                            Image(
                                painter = painterResource(id = item.iconResId),
                                contentDescription = item.label,
                                modifier = Modifier
                                    .size(30.dp)
                                    .alpha(if (isSelected) 1f else 0.6f)
                            )
                        },
                        label = {
                            // Solo muestra la etiqueta si el ítem está seleccionado
                            if (isSelected) {
                                Text(text = item.label, style = MaterialTheme.typography.labelSmall)
                            }
                        },
                        colors = NavigationBarItemDefaults.colors(
                            // Colores para el ítem seleccionado (activo)
                            selectedIconColor = MaterialTheme.colorScheme.onPrimary,
                            selectedTextColor = MaterialTheme.colorScheme.onPrimary,
                            indicatorColor = Color.Transparent,

                            // Colores para el ítem no seleccionado (inactivo)
                            unselectedIconColor = MaterialTheme.colorScheme.onPrimary.copy(alpha = 0.6f),
                            unselectedTextColor = Color.Transparent
                        )
                    )
                }
            }
        }
    ) { paddingValues ->
        Box(
            modifier = Modifier
                .fillMaxSize()
                .padding(paddingValues),
            contentAlignment = Alignment.Center
        ) {
            Text("Contenido de Journal Screen")

        }
    }
}

