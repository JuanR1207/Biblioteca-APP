package com.example.biblioteca.ui.composable

import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.Dp
import androidx.compose.ui.unit.TextUnit
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.example.biblioteca.ui.theme.BibliotecaTheme

@Composable
fun PortadaLibro(
    nombre: String,
    ancho: Dp,
    alto: Dp,
    tamanoLetra: TextUnit,
    modifier: Modifier = Modifier
) {
    Box(
        modifier = modifier
            .size(width = ancho, height = alto)
            .background(Color(0xFF1B2A4A), RoundedCornerShape(6.dp)),
        contentAlignment = Alignment.Center
    ) {
        Text(
            text = nombre,
            color = Color.White,
            fontSize = tamanoLetra,
            fontWeight = FontWeight.Bold,
            textAlign = TextAlign.Center,
            modifier = Modifier.padding(6.dp)
        )
    }
}

@Preview(showBackground = true)
@Composable
fun PortadaLibroPreview() {
    BibliotecaTheme {
        PortadaLibro(
            nombre = "Clean Code",
            ancho = 64.dp,
            alto = 88.dp,
            tamanoLetra = 10.sp
        )
    }
}