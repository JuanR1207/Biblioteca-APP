package com.example.biblioteca.ui.section

import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.items
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import com.example.biblioteca.data.DatosEstaticos
import com.example.biblioteca.data.Libro
import com.example.biblioteca.ui.composable.LibroItem
import com.example.biblioteca.ui.theme.BibliotecaTheme

@Composable
fun ListaLibrosSection(
    libros: List<Libro>,
    onVerDetalle: (Int) -> Unit,
    modifier: Modifier = Modifier
) {
    LazyColumn(
        modifier = modifier,
        verticalArrangement = Arrangement.spacedBy(12.dp)
    ) {
        items(libros) { libro ->
            LibroItem(
                libro = libro,
                onVerDetalle = { onVerDetalle(libro.id) }
            )
        }
    }
}

@Preview(showBackground = true)
@Composable
fun ListaLibrosSectionPreview() {
    BibliotecaTheme {
        ListaLibrosSection(
            libros = DatosEstaticos.libros,
            onVerDetalle = {}
        )
    }
}