package com.example.biblioteca.ui.screen

import androidx.compose.foundation.background
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.navigationBarsPadding
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.layout.statusBarsPadding
import androidx.compose.foundation.rememberScrollState
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.foundation.verticalScroll
import androidx.compose.material3.Card
import androidx.compose.material3.CardDefaults
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.example.biblioteca.data.DatosEstaticos
import com.example.biblioteca.ui.section.AccionesReservaSection
import com.example.biblioteca.ui.section.DatosReservaSection
import com.example.biblioteca.ui.theme.BibliotecaTheme
import com.example.biblioteca.ui.theme.MoradoClaro
import com.example.biblioteca.ui.theme.MoradoPrimario
import com.example.biblioteca.ui.theme.VerdeClaro
import com.example.biblioteca.ui.theme.VerdeExito

@Composable
fun DetalleReservaScreen(
    nombreLibro: String,
    fechaReserva: String,
    codigoReserva: String,
    onRenovar: () -> Unit,
    onCancelar: () -> Unit,
    onVolver: () -> Unit
) {
    val reserva = DatosEstaticos.buscarReserva(codigoReserva)
    val autor = reserva?.autor ?: "Desconocido"
    val estado = reserva?.estado ?: "Activa"

    Column(
        modifier = Modifier
            .fillMaxSize()
            .statusBarsPadding()
            .navigationBarsPadding()
            .verticalScroll(rememberScrollState())
            .padding(24.dp),
        horizontalAlignment = Alignment.CenterHorizontally
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
                text = "Detalle de Reserva",
                fontSize = 22.sp,
                fontWeight = FontWeight.Bold
            )
        }

        Spacer(modifier = Modifier.height(20.dp))

        Box(
            modifier = Modifier
                .background(VerdeClaro, RoundedCornerShape(12.dp))
                .padding(horizontal = 16.dp, vertical = 8.dp)
        ) {
            Text(
                text = "✔ Argumentos recibidos",
                fontSize = 13.sp,
                fontWeight = FontWeight.Medium,
                color = VerdeExito
            )
        }

        Spacer(modifier = Modifier.height(20.dp))

        Box(
            modifier = Modifier
                .size(width = 140.dp, height = 190.dp)
                .background(Color(0xFF1B2A4A), RoundedCornerShape(8.dp)),
            contentAlignment = Alignment.Center
        ) {
            Text(
                text = nombreLibro,
                color = Color.White,
                fontSize = 18.sp,
                fontWeight = FontWeight.Bold,
                textAlign = TextAlign.Center,
                modifier = Modifier.padding(12.dp)
            )
        }

        Spacer(modifier = Modifier.height(20.dp))

        DatosReservaSection(
            nombreLibro = nombreLibro,
            autor = autor,
            fechaReserva = fechaReserva,
            codigoReserva = codigoReserva,
            estado = estado
        )

        Spacer(modifier = Modifier.height(16.dp))

        Card(
            modifier = Modifier.fillMaxWidth(),
            shape = RoundedCornerShape(12.dp),
            colors = CardDefaults.cardColors(containerColor = MoradoClaro)
        ) {
            Text(
                text = "ℹ️  Estos datos fueron enviados desde la pantalla anterior como parámetros.",
                fontSize = 13.sp,
                color = MoradoPrimario,
                modifier = Modifier.padding(16.dp)
            )
        }

        Spacer(modifier = Modifier.height(24.dp))

        AccionesReservaSection(
            onRenovar = onRenovar,
            onCancelar = onCancelar
        )
    }
}

@Preview(showBackground = true)
@Composable
fun DetalleReservaScreenPreview() {
    BibliotecaTheme {
        DetalleReservaScreen(
            nombreLibro = "Clean Code",
            fechaReserva = "15/06/2026",
            codigoReserva = "RES-2026-001",
            onRenovar = {},
            onCancelar = {},
            onVolver = {}
        )
    }
}