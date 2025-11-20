package com.example.clase1.nav

import androidx.compose.runtime.Composable
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import androidx.navigation.compose.rememberNavController
import com.example.clase1.screen.HomeScreen
import com.example.clase1.screen.LoginScreen
import com.example.clase1.screen.RegisterScreen

@Composable
fun AppNavGraph() {
    // 1. Aquí creamos el controlador de navegación
    val navController = rememberNavController()

    NavHost(navController = navController, startDestination = Route.Login.path) {

        // Ruta Login
        composable(Route.Login.path) {
            LoginScreen(nav = navController)
        }

        // Ruta Home (AQUÍ ESTABA EL ERROR)
        composable(Route.Home.path) {
            // Antes tenías HomeScreen(), ahora debes pasarle el nav
            HomeScreen(nav = navController)
        }

        // Ruta Registro
        composable(Route.Register.path) {
            // RegisterScreen también necesita el nav
            RegisterScreen(nav = navController)
        }
    }
}