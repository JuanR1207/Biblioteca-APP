package com.example.biblioteca.ui.section

import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.items
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import com.example.biblioteca.data.DatosEstaticos
import com.example.biblioteca.data.Reserva
import com.example.biblioteca.ui.composable.ReservaItem
import com.example.biblioteca.ui.theme.BibliotecaTheme

@Composable
fun ListaReservasSection(
    reservas: List<Reserva>,
    onVerReserva: (Reserva) -> Unit,
    modifier: Modifier = Modifier
) {
    LazyColumn(
        modifier = modifier,
        verticalArrangement = Arrangement.spacedBy(12.dp)
    ) {
        items(reservas) { reserva ->
            ReservaItem(
                reserva = reserva,
                onVerReserva = { onVerReserva(reserva) }
            )
        }
    }
}

@Preview(showBackground = true)
@Composable
fun ListaReservasSectionPreview() {
    BibliotecaTheme {
        ListaReservasSection(
            reservas = DatosEstaticos.reservas,
            onVerReserva = {}
        )
    }
}