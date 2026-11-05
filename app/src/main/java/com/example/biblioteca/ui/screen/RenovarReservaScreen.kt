package com.example.biblioteca.ui.screen

import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
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
import com.example.biblioteca.ui.section.FechasRenovacionSection
import com.example.biblioteca.ui.section.ResumenLibroSection
import com.example.biblioteca.ui.theme.BibliotecaTheme
import com.example.biblioteca.ui.theme.NaranjaPrimario

@Composable
fun RenovarReservaScreen(
    nombreLibro: String,
    fechaReserva: String,
    onConfirmar: (String) -> Unit,
    onVolver: () -> Unit
) {
    val fechaNueva = DatosEstaticos.FECHA_RENOVACION

    Column(
        modifier = Modifier
            .fillMaxSize()
            .statusBarsPadding()
            .navigationBarsPadding()
            .verticalScroll(rememberScrollState())
            .padding(24.dp)
    ) {
        Row(
            modifier = Modifier.fillMaxWidth(),
            verticalAlignment = Alignment.CenterVertically
        ) {
            Text(
                text = "←",
                fontSize = 24.sp,
                modifier = Modifier
                    .clickable { onVolver() }
                    .padding(end = 16.dp)
            )
            Text(
                text = "Renovar Reserva",
                fontSize = 22.sp,
                fontWeight = FontWeight.Bold
            )
        }

        Spacer(modifier = Modifier.height(20.dp))

        ResumenLibroSection(nombreLibro = nombreLibro)

        Spacer(modifier = Modifier.height(16.dp))

        FechasRenovacionSection(
            fechaActual = fechaReserva,
            fechaNueva = fechaNueva
        )

        Spacer(modifier = Modifier.height(32.dp))

        Button(
            onClick = { onConfirmar(fechaNueva) },
            modifier = Modifier
                .fillMaxWidth()
                .height(52.dp),
            shape = RoundedCornerShape(12.dp),
            colors = ButtonDefaults.buttonColors(containerColor = NaranjaPrimario)
        ) {
            Text(
                text = "✔  Confirmar Renovación",
                fontSize = 16.sp,
                fontWeight = FontWeight.SemiBold
            )
        }
    }
}

@Preview(showBackground = true)
@Composable
fun RenovarReservaScreenPreview() {
    BibliotecaTheme {
        RenovarReservaScreen(
            nombreLibro = "Clean Code",
            fechaReserva = "15/06/2026",
            onConfirmar = {},
            onVolver = {}
        )
    }
}