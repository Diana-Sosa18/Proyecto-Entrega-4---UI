package com.uvg.rachapp.ui.screens.home

import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxHeight
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.shape.CircleShape
import androidx.compose.material3.Button
import androidx.compose.material3.Icon
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.NavigationBar
import androidx.compose.material3.NavigationBarItem
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableIntStateOf
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.rememberCoroutineScope
import androidx.compose.runtime.setValue
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
import com.uvg.rachapp.PlaceholderScreen
import com.uvg.rachapp.R
import kotlinx.coroutines.launch

@Composable
fun AppScreen(
    onLogout: () -> Unit
) {
    var selectedTab by remember { mutableIntStateOf(2) } // Pantalla activa

    val tabItems = listOf(
        "Notas" to R.drawable.journal_con_fondo,
        "Noticias" to R.drawable.noticias_con_fondo,
        "Inicio" to R.drawable.home_con_fondo,
        "Perfil" to R.drawable.perfil_con_fondo
    )

    Scaffold(
        bottomBar = {
            NavigationBar (
                containerColor = Color(0xFF091f5B)
            ) {
                tabItems.forEachIndexed { index, (label, iconRes) ->
                    val isSelected = selectedTab == index

                    NavigationBarItem(
                        selected = isSelected,
                        onClick = { selectedTab = index },
                        icon = {
                            Column(horizontalAlignment = Alignment.CenterHorizontally) {
                                Icon(
                                    painter = painterResource(id = iconRes),
                                    contentDescription = label,
                                    modifier = Modifier.size(if (isSelected) 20.dp else 28.dp)
                                )
                                if (isSelected) {
                                    Text(
                                        text = label,
                                        style = MaterialTheme.typography.labelSmall,
                                        fontSize = 10.sp
                                    )
                                }
                            }
                        },
                        alwaysShowLabel = false // desactiva el label por defecto
                    )
                }
            }
        }
    ) { padding ->
        Box(modifier = Modifier.padding(padding)) {
            when (selectedTab) {
                2 -> HomeScreen(onLogout) // Pantalla del perro
                else -> PlaceholderScreen("Pantalla $selectedTab")
            }
        }
    }
}

// ---- Pantalla Home ----
@Composable
fun HomeScreen(onLogout: () -> Unit) {
    val scope = rememberCoroutineScope()
    var scale by remember { mutableStateOf(1f) }

    Column(
        modifier = Modifier
            .fillMaxSize()
            .padding(16.dp),
        horizontalAlignment = Alignment.CenterHorizontally
    ) {
        // Título
        Text(
            text = "Racha",
            fontSize = 28.sp,
            fontWeight = FontWeight.Bold,
            color = Color(0xFF002366)
        )

        Spacer(modifier = Modifier.height(16.dp))

        // Calendario simulado en lo que termino el oficial (6x7 grid)
        CalendarView()

        Spacer(modifier = Modifier.height(16.dp))
        Button(onClick = { onLogout() }) {
            Text("Cerrar sesión")
        }
        Spacer(modifier = Modifier.height(16.dp))
        // Botón + texto
        Row(
            verticalAlignment = Alignment.CenterVertically,
            horizontalArrangement = Arrangement.Center
        ) {
            Image(
                painter = painterResource(id = R.drawable.buttoncroqueta),
                contentDescription = "botón",
                modifier = Modifier
                    .scale(scale)
                    .clickable {
                        scope.launch {
                            // animación simple al tocar
                            scale = 1.2f
                            kotlinx.coroutines.delay(200)
                            scale = 1f
                        }
                    }
            )
            Spacer(modifier = Modifier.width(8.dp))

            Text(
                "<-",
                fontSize = 26.sp
            )
            Spacer(modifier = Modifier.width(8.dp))
            Text(
                "¡Dale una croqueta a Destiny, si superaste otro día más!" +
                        "\nPuedes darle todas las croquetas que quieras ^_^",
                fontSize = 14.sp
            )
        }

        Spacer(modifier = Modifier.height(20.dp))

        // Imagen animada (1/3 de pantalla)
        Box(
            modifier = Modifier
                .fillMaxSize()
                .fillMaxHeight(0.33f),
            contentAlignment = Alignment.Center
        ) {
            Image(
                painter = painterResource(id = R.drawable.perrito),
                contentDescription = "Perro",
                contentScale = ContentScale.Crop,
                modifier = Modifier
                    .fillMaxSize()
                    .clickable {
                        scope.launch {
                            // animación simple al tocar
                            scale = 1.2f
                            kotlinx.coroutines.delay(200)
                            scale = 1f
                        }
                    }
            )
        }
    }
}

// ---- Calendario fake ----
@Composable
fun CalendarView() {
    val PrimaryBlue = Color(0x091f5B)
    Column (
        horizontalAlignment = Alignment.CenterHorizontally
    ){
        Spacer(modifier = Modifier.height(20.dp))
        for (week in 0 until 2) { // 2 semanas de ejemplo
            Row(
                horizontalArrangement = Arrangement.SpaceEvenly,
                modifier = Modifier.fillMaxWidth()
            ) {
                for (day in 1..4) {
                    Box(
                        modifier = Modifier
                            .size(60.dp)
                            .background(Color.LightGray, shape = CircleShape),
                        contentAlignment = Alignment.Center
                    ) {
                        Text("${week * 4 + day}")
                    }
                }
            }
            Spacer(modifier = Modifier.height(8.dp))
        }
        Spacer(modifier = Modifier.height(8.dp))
        Text(text ="Agosto",
            fontWeight = FontWeight.Bold,
            fontSize = 20.sp,
            color = Color(0xff091F5B))
    }
}

@Preview
// ---- Calendario fake prev en lo que lo logro modificar Datepicker o encuentro otro método XD----
@Composable
fun CalendarViewPrew() {
    val PrimaryBlue = Color(0x091f5B)
    Column (
        horizontalAlignment = Alignment.CenterHorizontally
    ){
        Spacer(modifier = Modifier.height(20.dp))
        for (week in 0 until 2) { // 2 semanas de ejemplo
            Row(
                horizontalArrangement = Arrangement.SpaceEvenly,
                modifier = Modifier.fillMaxWidth()
            ) {
                for (day in 1..4) {
                    Box(
                        modifier = Modifier
                            .size(60.dp)
                            .background(Color.LightGray, shape = CircleShape),
                        contentAlignment = Alignment.Center
                    ) {
                        Text("${week * 4 + day}")
                    }
                }
            }
            Spacer(modifier = Modifier.height(8.dp))
        }
        Spacer(modifier = Modifier.height(8.dp))
        Text(text ="Agosto",
            fontWeight = FontWeight.Bold,
            fontSize = 20.sp,
            color = Color(0xff091F5B))
    }
}




