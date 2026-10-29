package com.example.biblioteca.navegation

import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.navigation.NavType
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import androidx.navigation.compose.rememberNavController
import androidx.navigation.navArgument
import com.example.biblioteca.ui.screen.ConfirmacionReservaScreen
import com.example.biblioteca.ui.screen.DetalleLibroScreen
import com.example.biblioteca.ui.screen.HomeScreen
import com.example.biblioteca.ui.screen.ListaLibrosScreen

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
                }
            )
        }

        composable(Routes.MIS_RESERVAS) {
            Text("Pantalla: Mis reservas")
        }

        composable(Routes.DETALLE_RESERVA) { backStackEntry ->
            val codigo = backStackEntry.arguments?.getString("codigoReserva")
            Text("Pantalla: Detalle de reserva $codigo")
        }

        composable(Routes.RENOVAR_RESERVA) { backStackEntry ->
            val codigo = backStackEntry.arguments?.getString("codigoReserva")
            Text("Pantalla: Renovar reserva $codigo")
        }

        composable(Routes.RENOVACION_EXITOSA) { backStackEntry ->
            val fechaNueva = backStackEntry.arguments?.getString("fechaNueva")
            Text("Pantalla: Renovación exitosa, nueva fecha $fechaNueva")
        }

        composable(Routes.RESERVA_CANCELADA) {
            Text("Pantalla: Reserva cancelada")
        }
    }
}