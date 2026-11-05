package com.example.biblioteca.ui.composable

import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.example.biblioteca.ui.theme.VerdeClaro
import com.example.biblioteca.ui.theme.VerdeExito

@Composable
fun EstadoChip(
    estado: String,
    modifier: Modifier = Modifier
) {
    Box(
        modifier = modifier
            .background(VerdeClaro, RoundedCornerShape(50))
            .padding(horizontal = 12.dp, vertical = 4.dp)
    ) {
        Text(
            text = estado,
            fontSize = 13.sp,
            fontWeight = FontWeight.SemiBold,
            color = VerdeExito
        )
    }
}