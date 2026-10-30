package com.example.biblioteca.navegation

import androidx.compose.runtime.Composable
import androidx.navigation.NavType
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import androidx.navigation.compose.rememberNavController
import androidx.navigation.navArgument
import com.example.biblioteca.ui.screen.ConfirmacionReservaScreen
import com.example.biblioteca.ui.screen.DetalleLibroScreen
import com.example.biblioteca.ui.screen.DetalleReservaScreen
import com.example.biblioteca.ui.screen.HomeScreen
import com.example.biblioteca.ui.screen.ListaLibrosScreen
import com.example.biblioteca.ui.screen.MisReservasScreen
import com.example.biblioteca.ui.screen.RenovacionExitosaScreen
import com.example.biblioteca.ui.screen.RenovarReservaScreen
import com.example.biblioteca.ui.screen.ReservaCanceladaScreen

@Composable
fun AppNavegation() {
    val navController = rememberNavController()

    NavHost(
        navController = navController,
        startDestination = Routes.INICIO
    ) {
        composable(Routes.INICIO) {
            HomeScreen(
                onVerLibros = { navController.navigate(Routes.LISTA_LIBROS) }
            )
        }

        composable(Routes.LISTA_LIBROS) {
            ListaLibrosScreen(
                onVerDetalle = { libroId ->
                    navController.navigate(Routes.detalleLibro(libroId))
                }
            )
        }

        composable(
            route = Routes.DETALLE_LIBRO,
            arguments = listOf(navArgument("libroId") { type = NavType.IntType })
        ) { backStackEntry ->
            val libroId = backStackEntry.arguments?.getInt("libroId") ?: 0
            DetalleLibroScreen(
                libroId = libroId,
                onReservar = { navController.navigate(Routes.confirmacion(libroId)) }
            )
        }

        composable(
            route = Routes.CONFIRMACION,
            arguments = listOf(navArgument("libroId") { type = NavType.IntType })
        ) { backStackEntry ->
            val libroId = backStackEntry.arguments?.getInt("libroId") ?: 0
            ConfirmacionReservaScreen(
                libroId = libroId,
                onVolverInicio = {
                    navController.navigate(Routes.INICIO) {
                        popUpTo(Routes.INICIO) { inclusive = true }
                    }
                },
                onVerMisReservas = {
                    navController.navigate(Routes.MIS_RESERVAS) {
                        popUpTo(Routes.INICIO)
                    }
                }
            )
        }

        composable(Routes.MIS_RESERVAS) {
            MisReservasScreen(
                onVerReserva = { reserva ->
                    navController.navigate(
                        Routes.detalleReserva(
                            nombreLibro = reserva.nombreLibro,
                            fechaReserva = reserva.fecha,
                            codigoReserva = reserva.codigo
                        )
                    )
                }
            )
        }

        composable(Routes.DETALLE_RESERVA) { backStackEntry ->
            val nombreLibro = backStackEntry.arguments?.getString("nombreLibro") ?: ""
            val fechaReserva = backStackEntry.arguments?.getString("fechaReserva") ?: ""
            val codigoReserva = backStackEntry.arguments?.getString("codigoReserva") ?: ""
            DetalleReservaScreen(
                nombreLibro = nombreLibro,
                fechaReserva = fechaReserva,
                codigoReserva = codigoReserva,
                onRenovar = {
                    navController.navigate(
                        Routes.renovarReserva(nombreLibro, fechaReserva, codigoReserva)
                    )
                },
                onCancelar = {
                    navController.navigate(Routes.RESERVA_CANCELADA) {
                        popUpTo(Routes.MIS_RESERVAS)
                    }
                },
                onVolver = { navController.popBackStack() }
            )
        }

        composable(Routes.RENOVAR_RESERVA) { backStackEntry ->
            val nombreLibro = backStackEntry.arguments?.getString("nombreLibro") ?: ""
            val fechaReserva = backStackEntry.arguments?.getString("fechaReserva") ?: ""
            RenovarReservaScreen(
                nombreLibro = nombreLibro,
                fechaReserva = fechaReserva,
                onConfirmar = { fechaNueva ->
                    navController.navigate(
                        Routes.renovacionExitosa(nombreLibro, fechaNueva)
                    ) {
                        popUpTo(Routes.MIS_RESERVAS)
                    }
                },
                onVolver = { navController.popBackStack() }
            )
        }

        composable(Routes.RENOVACION_EXITOSA) { backStackEntry ->
            val nombreLibro = backStackEntry.arguments?.getString("nombreLibro") ?: ""
            val fechaNueva = backStackEntry.arguments?.getString("fechaNueva") ?: ""
            RenovacionExitosaScreen(
                nombreLibro = nombreLibro,
                fechaNueva = fechaNueva,
                onVolverMisReservas = {
                    navController.popBackStack(Routes.MIS_RESERVAS, inclusive = false)
                }
            )
        }

        composable(Routes.RESERVA_CANCELADA) {
            ReservaCanceladaScreen(
                onVolverMisReservas = { navController.popBackStack() }
            )
        }
    }
}