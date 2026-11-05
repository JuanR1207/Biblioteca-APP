package com.example.biblioteca.ui.composable

import androidx.compose.foundation.border
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.example.biblioteca.ui.theme.BibliotecaTheme
import com.example.biblioteca.ui.theme.NaranjaPrimario

@Composable
fun CampoFecha(
    etiqueta: String,
    fecha: String,
    modifier: Modifier = Modifier,
    resaltado: Boolean = false
) {
    val colorBorde = if (resaltado) NaranjaPrimario else Color.LightGray

    Column(modifier = modifier.fillMaxWidth()) {
        Text(
            text = etiqueta,
            fontSize = 14.sp,
            fontWeight = FontWeight.SemiBold
        )

        Spacer(modifier = Modifier.height(6.dp))

        Row(
            modifier = Modifier
                .fillMaxWidth()
                .border(1.dp, colorBorde, RoundedCornerShape(10.dp))
                .padding(horizontal = 14.dp, vertical = 12.dp),
            verticalAlignment = Alignment.CenterVertically
        ) {
            Text(text = "📅", fontSize = 18.sp)
            Spacer(modifier = Modifier.width(10.dp))
            Text(text = fecha, fontSize = 16.sp)
        }
    }
}

@Preview(showBackground = true)
@Composable
fun CampoFechaPreview() {
    BibliotecaTheme {
        CampoFecha(etiqueta = "Nueva Fecha:", fecha = "30/06/2026", resaltado = true)
    }
}