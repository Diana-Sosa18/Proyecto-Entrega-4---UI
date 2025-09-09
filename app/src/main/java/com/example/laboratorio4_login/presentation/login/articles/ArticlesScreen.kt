package com.example.laboratorio4_login.presentation.login.articles


import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Text
import androidx.compose.material3.TopAppBar
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.res.stringResource
import androidx.navigation.NavController
import androidx.navigation.NavHostController
import com.example.laboratorio4_login.R




@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun ArticlesScreen() {
    val screenName = stringResource(id = R.string.title_articles_screen)

    Scaffold(
        topBar = {
            TopAppBar(title = { Text(screenName) })
        }
        // SIN bottomBar
    ) { innerPadding ->
        Box(
            modifier = Modifier
                .fillMaxSize()
                .padding(innerPadding),
            contentAlignment = Alignment.Center
        ) {
            Text("Contenido de: $screenName")
        }
    }
}