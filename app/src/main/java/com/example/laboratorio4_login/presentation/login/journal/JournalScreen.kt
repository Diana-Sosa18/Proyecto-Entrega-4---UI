package com.example.laboratorio4_login.presentation.login.journal


import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Text
import androidx.compose.material3.TopAppBar
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.navigation.NavController

@OptIn(ExperimentalMaterial3Api::class) // Necesario para TopAppBar y Scaffold en Material 3
@Composable
fun JournalScreen(navController: NavController, mainNavController: NavController) { // mainNavController para la navegación principal
    Scaffold(
        topBar = {
            TopAppBar(title = { Text("Journal") })
        },
        // Aquí irá tu BottomNavigationBar más adelante
        bottomBar = {
            // De momento vacío, o un Text placeholder
            // MyBottomNavigationBar(navController = navController) // Cuando la tengas
        }
    ) { paddingValues ->
        Box(
            modifier = Modifier
                .fillMaxSize()
                .padding(paddingValues), // Aplicar padding del Scaffold
            contentAlignment = Alignment.Center
        ) {
            Text("Contenido de Journal Screen")
            // Aquí desarrollarás el contenido específico de tu JournalScreen
        }
    }
}

