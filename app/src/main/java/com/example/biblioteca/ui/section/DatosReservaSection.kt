package com.example.biblioteca.ui.section

import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.Card
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.example.biblioteca.ui.composable.EstadoChip
import com.example.biblioteca.ui.composable.FilaInfo
import com.example.biblioteca.ui.theme.BibliotecaTheme

@Composable
fun DatosReservaSection(
    nombreLibro: String,
    autor: String,
    fechaReserva: String,
    codigoReserva: String,
    estado: String,
    modifier: Modifier = Modifier
) {
    Card(
        modifier = modifier.fillMaxWidth(),
        shape = RoundedCornerShape(16.dp)
    ) {
        Column(modifier = Modifier.padding(16.dp)) {
            FilaInfo(etiqueta = "Nombre", valor = nombreLibro, anchoEtiqueta = 130.dp)
            FilaInfo(etiqueta = "Autor", valor = autor, anchoEtiqueta = 130.dp)
            FilaInfo(etiqueta = "Fecha Reserva", valor = fechaReserva, anchoEtiqueta = 130.dp)
            FilaInfo(etiqueta = "Código Reserva", valor = codigoReserva, anchoEtiqueta = 130.dp)
            Row(
                modifier = Modifier.padding(vertical = 4.dp),
                verticalAlignment = Alignment.CenterVertically
            ) {
                Text(
                    text = "Estado:",
                    fontSize = 15.sp,
                    fontWeight = FontWeight.SemiBold,
                    modifier = Modifier.width(130.dp)
                )
                EstadoChip(estado = estado)
            }
        }
    }
}

@Preview(showBackground = true)
@Composable
fun DatosReservaSectionPreview() {
    BibliotecaTheme {
        DatosReservaSection(
            nombreLibro = "Clean Code",
            autor = "Robert C. Martin",
            fechaReserva = "15/06/2026",
            codigoReserva = "RES-2026-001",
            estado = "Activa"
        )
    }
}