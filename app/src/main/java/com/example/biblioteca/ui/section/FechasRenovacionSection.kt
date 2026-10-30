package com.example.biblioteca.ui.section

import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.Card
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import com.example.biblioteca.ui.composable.CampoFecha
import com.example.biblioteca.ui.theme.BibliotecaTheme

@Composable
fun FechasRenovacionSection(
    fechaActual: String,
    fechaNueva: String,
    modifier: Modifier = Modifier
) {
    Card(
        modifier = modifier.fillMaxWidth(),
        shape = RoundedCornerShape(16.dp)
    ) {
        Column(modifier = Modifier.padding(16.dp)) {
            CampoFecha(etiqueta = "Reserva Actual:", fecha = fechaActual)

            Spacer(modifier = Modifier.height(16.dp))

            CampoFecha(
                etiqueta = "Nueva Fecha:",
                fecha = fechaNueva,
                resaltado = true
            )
        }
    }
}

@Preview(showBackground = true)
@Composable
fun FechasRenovacionSectionPreview() {
    BibliotecaTheme {
        FechasRenovacionSection(
            fechaActual = "15/06/2026",
            fechaNueva = "30/06/2026"
        )
    }
}