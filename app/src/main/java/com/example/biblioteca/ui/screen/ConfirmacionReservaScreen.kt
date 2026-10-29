package com.example.biblioteca.ui.screen

import androidx.compose.foundation.BorderStroke
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.navigationBarsPadding
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.layout.statusBarsPadding
import androidx.compose.foundation.shape.CircleShape
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.Button
import androidx.compose.material3.ButtonDefaults
import androidx.compose.material3.Card
import androidx.compose.material3.CardDefaults
import androidx.compose.material3.OutlinedButton
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.example.biblioteca.data.DatosEstaticos
import com.example.biblioteca.ui.composable.FilaInfo
import com.example.biblioteca.ui.theme.BibliotecaTheme
import com.example.biblioteca.ui.theme.VerdeClaro
import com.example.biblioteca.ui.theme.VerdeExito

@Composable
fun ConfirmacionReservaScreen(
    libroId: Int,
    onVolverInicio: () -> Unit,
    onVerMisReservas: () -> Unit
) {
    val libro = DatosEstaticos.buscarLibro(libroId)
    val nombreLibro = libro?.nombre ?: "Libro desconocido"

    Column(
        modifier = Modifier
            .fillMaxSize()
            .background(VerdeClaro)
            .statusBarsPadding()
            .navigationBarsPadding()
            .padding(24.dp),
        horizontalAlignment = Alignment.CenterHorizontally,
        verticalArrangement = Arrangement.Center
    ) {
        Box(
            modifier = Modifier
                .size(140.dp)
                .background(Color.White, CircleShape),
            contentAlignment = Alignment.Center
        ) {
            Text(
                text = "✔",
                fontSize = 72.sp,
                fontWeight = FontWeight.Bold,
                color = VerdeExito
            )
        }

        Spacer(modifier = Modifier.height(32.dp))

        Text(
            text = "Reserva Exitosa",
            fontSize = 26.sp,
            fontWeight = FontWeight.Bold,
            color = VerdeExito
        )

        Spacer(modifier = Modifier.height(24.dp))

        Card(
            modifier = Modifier.fillMaxWidth(),
            shape = RoundedCornerShape(16.dp),
            colors = CardDefaults.cardColors(containerColor = Color.White)
        ) {
            Column(modifier = Modifier.padding(20.dp)) {
                FilaInfo(etiqueta = "Libro", valor = nombreLibro)
                FilaInfo(etiqueta = "Fecha", valor = DatosEstaticos.FECHA_RESERVA)
            }
        }

        Spacer(modifier = Modifier.height(40.dp))

        Button(
            onClick = onVolverInicio,
            modifier = Modifier
                .fillMaxWidth()
                .height(52.dp),
            shape = RoundedCornerShape(12.dp),
            colors = ButtonDefaults.buttonColors(containerColor = VerdeExito)
        ) {
            Text(
                text = "🏠  Volver al Inicio",
                fontSize = 16.sp,
                fontWeight = FontWeight.SemiBold
            )
        }

        Spacer(modifier = Modifier.height(12.dp))

        OutlinedButton(
            onClick = onVerMisReservas,
            modifier = Modifier
                .fillMaxWidth()
                .height(52.dp),
            shape = RoundedCornerShape(12.dp),
            border = BorderStroke(1.dp, VerdeExito)
        ) {
            Text(
                text = "📋  Ver Mis Reservas",
                fontSize = 16.sp,
                fontWeight = FontWeight.SemiBold,
                color = VerdeExito
            )
        }
    }
}

@Preview(showBackground = true)
@Composable
fun ConfirmacionReservaScreenPreview() {
    BibliotecaTheme {
        ConfirmacionReservaScreen(
            libroId = 1,
            onVolverInicio = {},
            onVerMisReservas = {}
        )
    }
}