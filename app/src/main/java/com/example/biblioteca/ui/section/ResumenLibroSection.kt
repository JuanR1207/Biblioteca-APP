package com.example.biblioteca.ui.section

import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.Card
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.example.biblioteca.ui.composable.FilaInfo
import com.example.biblioteca.ui.composable.PortadaLibro
import com.example.biblioteca.ui.theme.BibliotecaTheme

@Composable
fun ResumenLibroSection(
    nombreLibro: String,
    modifier: Modifier = Modifier
) {
    Card(
        modifier = modifier.fillMaxWidth(),
        shape = RoundedCornerShape(16.dp)
    ) {
        Row(
            modifier = Modifier.padding(16.dp),
            verticalAlignment = Alignment.CenterVertically
        ) {
            PortadaLibro(
                nombre = nombreLibro,
                ancho = 64.dp,
                alto = 88.dp,
                tamanoLetra = 10.sp
            )

            Spacer(modifier = Modifier.width(16.dp))

            FilaInfo(
                etiqueta = "Libro",
                valor = nombreLibro,
                anchoEtiqueta = 64.dp
            )
        }
    }
}

@Preview(showBackground = true)
@Composable
fun ResumenLibroSectionPreview() {
    BibliotecaTheme {
        ResumenLibroSection(nombreLibro = "Clean Code")
    }
}