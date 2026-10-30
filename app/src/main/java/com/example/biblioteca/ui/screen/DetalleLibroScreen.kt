package com.example.biblioteca.ui.screen

import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.navigationBarsPadding
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.statusBarsPadding
import androidx.compose.foundation.rememberScrollState
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.foundation.verticalScroll
import androidx.compose.material3.Button
import androidx.compose.material3.ButtonDefaults
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.example.biblioteca.data.DatosEstaticos
import com.example.biblioteca.ui.section.InfoLibroSection
import com.example.biblioteca.ui.theme.BibliotecaTheme
import com.example.biblioteca.ui.theme.NaranjaClaro
import com.example.biblioteca.ui.theme.NaranjaPrimario

@Composable
fun DetalleLibroScreen(
    libroId: Int,
    onReservar: () -> Unit
) {
    val libro = DatosEstaticos.buscarLibro(libroId)

    if (libro == null) {
        Box(
            modifier = Modifier.fillMaxSize(),
            contentAlignment = Alignment.Center
        ) {
            Text(text = "Libro no encontrado")
        }
    } else {
        Column(
            modifier = Modifier
                .fillMaxSize()
                .statusBarsPadding()
                .navigationBarsPadding()
                .verticalScroll(rememberScrollState())
                .padding(24.dp),
            horizontalAlignment = Alignment.CenterHorizontally
        ) {
            Box(
                modifier = Modifier
                    .background(NaranjaClaro, RoundedCornerShape(12.dp))
                    .padding(horizontal = 16.dp, vertical = 8.dp)
            ) {
                Text(
                    text = "Parámetro recibido: libroId = $libroId",
                    fontSize = 13.sp,
                    fontWeight = FontWeight.Medium,
                    color = NaranjaPrimario
                )
            }

            Spacer(modifier = Modifier.height(24.dp))

            InfoLibroSection(libro = libro)

            Spacer(modifier = Modifier.height(32.dp))

            Button(
                onClick = onReservar,
                modifier = Modifier
                    .fillMaxWidth()
                    .height(52.dp),
                shape = RoundedCornerShape(12.dp),
                colors = ButtonDefaults.buttonColors(containerColor = NaranjaPrimario)
            ) {
                Text(
                    text = "🔖  Reservar Libro",
                    fontSize = 16.sp,
                    fontWeight = FontWeight.SemiBold
                )
            }
        }
    }
}

@Preview(showBackground = true)
@Composable
fun DetalleLibroScreenPreview() {
    BibliotecaTheme {
        DetalleLibroScreen(libroId = 1, onReservar = {})
    }
}