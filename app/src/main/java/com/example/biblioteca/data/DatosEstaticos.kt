package com.example.biblioteca.data

object DatosEstaticos {

    val libros = listOf(
        Libro(
            id = 1,
            nombre = "Clean Code",
            autor = "Robert C. Martin",
            categoria = "Programación",
            descripcion = "Guía práctica para escribir código limpio, legible y mantenible. Un clásico imprescindible para desarrolladores."
        ),
        Libro(
            id = 2,
            nombre = "Kotlin para Android",
            autor = "Laura Gómez",
            categoria = "Desarrollo móvil",
            descripcion = "Aprende Kotlin desde cero y úsalo para crear aplicaciones Android modernas."
        ),
        Libro(
            id = 3,
            nombre = "Arquitectura de Software",
            autor = "Carlos Ramírez",
            categoria = "Arquitectura",
            descripcion = "Principios y patrones para diseñar sistemas organizados, escalables y fáciles de mantener."
        ),
        Libro(
            id = 4,
            nombre = "Jetpack Compose",
            autor = "Andrea Torres",
            categoria = "Desarrollo móvil",
            descripcion = "Construye interfaces de usuario declarativas para Android con Jetpack Compose."
        )
    )

    val reservas = listOf(
        Reserva(
            codigo = "RES-2026-001",
            nombreLibro = "Clean Code",
            autor = "Robert C. Martin",
            fecha = "15/06/2026",
            estado = "Activa"
        )
    )

    fun buscarLibro(id: Int): Libro? = libros.find { it.id == id }
}