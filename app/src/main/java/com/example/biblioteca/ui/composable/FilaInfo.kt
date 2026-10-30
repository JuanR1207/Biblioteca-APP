package com.example.biblioteca.ui.composable

import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.width
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.Dp
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp

@Composable
fun FilaInfo(
    etiqueta: String,
    valor: String,
    modifier: Modifier = Modifier,
    colorValor: Color = Color.Unspecified,
    anchoEtiqueta: Dp = 96.dp
) {
    Row(
        modifier = modifier
            .fillMaxWidth()
            .padding(vertical = 4.dp)
    ) {
        Text(
            text = "$etiqueta:",
            fontSize = 15.sp,
            fontWeight = FontWeight.SemiBold,
            modifier = Modifier.width(anchoEtiqueta)
        )
        Text(
            text = valor,
            fontSize = 15.sp,
            color = colorValor
        )
    }
}