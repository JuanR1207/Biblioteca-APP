package com.example.biblioteca.data

data class Reserva(
    val codigo: String,
    val nombreLibro: String,
    val autor: String,
    val fecha: String,
    val estado: String
)