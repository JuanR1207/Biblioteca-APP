package com.example.biblioteca.ui.section

import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.Card
import androidx.compose.material3.CardDefaults
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import com.example.biblioteca.ui.composable.FilaInfo
import com.example.biblioteca.ui.theme.BibliotecaTheme

@Composable
fun ResumenReservaSection(
    nombreLibro: String,
    fecha: String,
    modifier: Modifier = Modifier
) {
    Card(
        modifier = modifier.fillMaxWidth(),
        shape = RoundedCornerShape(16.dp),
        colors = CardDefaults.cardColors(containerColor = Color.White)
    ) {
        Column(modifier = Modifier.padding(20.dp)) {
            FilaInfo(etiqueta = "Libro", valor = nombreLibro)
            FilaInfo(etiqueta = "Fecha", valor = fecha)
        }
    }
}

@Preview(showBackground = true)
@Composable
fun ResumenReservaSectionPreview() {
    BibliotecaTheme {
        ResumenReservaSection(nombreLibro = "Clean Code", fecha = "15/06/2026")
    }
}