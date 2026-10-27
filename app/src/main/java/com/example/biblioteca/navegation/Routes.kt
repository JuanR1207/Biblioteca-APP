package com.example.biblioteca.navegacion

import android.net.Uri

object Routes {
    const val INICIO = "inicio"
    const val LISTA_LIBROS = "lista_libros"
    const val DETALLE_LIBRO = "detalle_libro/{libroId}"
    const val CONFIRMACION = "confirmacion/{libroId}"
    const val MIS_RESERVAS = "mis_reservas"
    const val DETALLE_RESERVA = "detalle_reserva/{nombreLibro}/{fechaReserva}/{codigoReserva}"
    const val RENOVAR_RESERVA = "renovar_reserva/{nombreLibro}/{fechaReserva}/{codigoReserva}"
    const val RENOVACION_EXITOSA = "renovacion_exitosa/{nombreLibro}/{fechaNueva}"
    const val RESERVA_CANCELADA = "reserva_cancelada"

    fun detalleLibro(libroId: Int) = "detalle_libro/$libroId"

    fun confirmacion(libroId: Int) = "confirmacion/$libroId"

    fun detalleReserva(nombreLibro: String, fechaReserva: String, codigoReserva: String) =
        "detalle_reserva/${Uri.encode(nombreLibro)}/${Uri.encode(fechaReserva)}/${Uri.encode(codigoReserva)}"

    fun renovarReserva(nombreLibro: String, fechaReserva: String, codigoReserva: String) =
        "renovar_reserva/${Uri.encode(nombreLibro)}/${Uri.encode(fechaReserva)}/${Uri.encode(codigoReserva)}"

    fun renovacionExitosa(nombreLibro: String, fechaNueva: String) =
        "renovacion_exitosa/${Uri.encode(nombreLibro)}/${Uri.encode(fechaNueva)}"
}