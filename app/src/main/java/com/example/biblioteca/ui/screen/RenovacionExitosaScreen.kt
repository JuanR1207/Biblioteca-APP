package com.example.biblioteca.ui.screen

import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.navigationBarsPadding
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.statusBarsPadding
import androidx.compose.foundation.shape.RoundedCornerShape
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
import com.example.biblioteca.ui.composable.IconoResultado
import com.example.biblioteca.ui.section.ResumenRenovacionSection
import com.example.biblioteca.ui.theme.BibliotecaTheme
import com.example.biblioteca.ui.theme.VerdeClaro
import com.example.biblioteca.ui.theme.VerdeExito

@Composable
fun RenovacionExitosaScreen(
    nombreLibro: String,
    fechaNueva: String,
    onVolverMisReservas: () -> Unit
) {
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
        IconoResultado(simbolo = "✔", color = VerdeExito)

        Spacer(modifier = Modifier.height(32.dp))

        Text(
            text = "Reserva Renovada",
            fontSize = 26.sp,
            fontWeight = FontWeight.Bold,
            color = VerdeExito
        )

        Spacer(modifier = Modifier.height(24.dp))

        ResumenRenovacionSection(
            nombreLibro = nombreLibro,
            fechaNueva = fechaNueva
        )

        Spacer(modifier = Modifier.height(40.dp))

        Button(
            onClick = onVolverMisReservas,
            modifier = Modifier
                .fillMaxWidth()
                .height(52.dp),
            shape = RoundedCornerShape(12.dp),
            colors = ButtonDefaults.buttonColors(containerColor = VerdeExito)
        ) {
            Text(
                text = "🏠  Volver a Mis Reservas",
                fontSize = 16.sp,
                fontWeight = FontWeight.SemiBold
            )
        }
    }
}

@Preview(showBackground = true)
@Composable
fun RenovacionExitosaScreenPreview() {
    BibliotecaTheme {
        RenovacionExitosaScreen(
            nombreLibro = "Clean Code",
            fechaNueva = "30/06/2026",
            onVolverMisReservas = {}
        )
    }
}