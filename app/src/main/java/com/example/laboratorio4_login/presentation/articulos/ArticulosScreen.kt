package com.example.laboratorio4_login.presentation.articulos

import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.PaddingValues
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.items
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Surface
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.dp
import com.example.laboratorio4_login.R

data class Articulo(val titulo: Int, val descripcion: Int)

@Composable
fun ArticulosScreen() {
    val backgroundColor = Color(0xFFEDF0F5)   // Fondo general
    val cardColor = Color(0xFFD0D4D8)         // Fondo de cada artículo
    val titleColor = Color(0xFF091F5B)        // Azul para títulos y subtítulos

    val articulos = listOf(
        Articulo(R.string.articulo1_title, R.string.articulo1_desc),
        Articulo(R.string.articulo2_title, R.string.articulo2_desc),
        Articulo(R.string.articulo3_title, R.string.articulo3_desc),
        Articulo(R.string.articulo4_title, R.string.articulo4_desc),
    )

    Surface(
        modifier = Modifier
            .fillMaxSize()
            .background(backgroundColor)
    ) {
        Column(
            modifier = Modifier.padding(16.dp)
        ) {
            // Título principal
            Text(
                text = stringResource(R.string.articulos_title),
                style = MaterialTheme.typography.headlineMedium.copy(
                    color = titleColor,
                    fontWeight = FontWeight.Bold
                ),
                modifier = Modifier.padding(bottom = 16.dp)
            )

            // Lista de artículos
            LazyColumn(
                verticalArrangement = Arrangement.spacedBy(12.dp),
                contentPadding = PaddingValues(bottom = 16.dp),
                modifier = Modifier.fillMaxSize()
            ) {
                items(articulos) { articulo ->
                    Surface(
                        modifier = Modifier.fillMaxWidth(),
                        shape = RoundedCornerShape(12.dp),
                        color = cardColor,
                        shadowElevation = 2.dp
                    ) {
                        Column(
                            modifier = Modifier.padding(16.dp)
                        ) {
                            Text(
                                text = stringResource(articulo.titulo),
                                style = MaterialTheme.typography.titleMedium.copy(
                                    color = titleColor,
                                    fontWeight = FontWeight.Bold
                                ),
                                modifier = Modifier.padding(bottom = 6.dp)
                            )
                            Text(
                                text = stringResource(articulo.descripcion),
                                style = MaterialTheme.typography.bodyMedium.copy(
                                    color = Color.Black
                                )
                            )
                        }
                    }
                }
            }
        }
    }
}
