package com.example.biblioteca.ui.screen

import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.navigationBarsPadding
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.statusBarsPadding
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.items
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.Card
import androidx.compose.material3.CardDefaults
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.example.biblioteca.data.DatosEstaticos
import com.example.biblioteca.data.Reserva
import com.example.biblioteca.ui.composable.ReservaItem
import com.example.biblioteca.ui.theme.BibliotecaTheme
import com.example.biblioteca.ui.theme.MoradoClaro
import com.example.biblioteca.ui.theme.MoradoPrimario

@Composable
fun MisReservasScreen(onVerReserva: (Reserva) -> Unit) {
    Column(
        modifier = Modifier
            .fillMaxSize()
            .statusBarsPadding()
            .navigationBarsPadding()
            .padding(horizontal = 24.dp, vertical = 16.dp)
    ) {
        Row(
            modifier = Modifier.fillMaxWidth(),
            verticalAlignment = Alignment.CenterVertically
        ) {
            Text(text = "☰", fontSize = 22.sp)
            Spacer(modifier = Modifier.width(16.dp))
            Text(
                text = "Mis Reservas",
                fontSize = 22.sp,
                fontWeight = FontWeight.Bold,
                modifier = Modifier.weight(1f)
            )
            Text(text = "📖", fontSize = 22.sp)
        }

        Spacer(modifier = Modifier.height(20.dp))

        Text(
            text = "📋 Lista de reservas activas",
            fontSize = 15.sp,
            fontWeight = FontWeight.SemiBold,
            color = MoradoPrimario
        )

        Spacer(modifier = Modifier.height(12.dp))

        LazyColumn(
            modifier = Modifier.weight(1f),
            verticalArrangement = Arrangement.spacedBy(12.dp)
        ) {
            items(DatosEstaticos.reservas) { reserva ->
                ReservaItem(
                    reserva = reserva,
                    onVerReserva = { onVerReserva(reserva) }
                )
            }
        }

        Spacer(modifier = Modifier.height(12.dp))

        Card(
            modifier = Modifier.fillMaxWidth(),
            shape = RoundedCornerShape(12.dp),
            colors = CardDefaults.cardColors(containerColor = MoradoClaro)
        ) {
            Text(
                text = "ℹ️  Aquí verás todas tus reservas activas.",
                fontSize = 14.sp,
                color = MoradoPrimario,
                modifier = Modifier.padding(16.dp)
            )
        }
    }
}

@Preview(showBackground = true)
@Composable
fun MisReservasScreenPreview() {
    BibliotecaTheme {
        MisReservasScreen(onVerReserva = {})
    }
}