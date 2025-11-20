package com.example.clase1.screen

import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.material3.Button
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.sp
import androidx.navigation.NavController
import androidx.navigation.compose.rememberNavController
import com.example.clase1.ui.theme.Clase1Theme

@Composable
fun HomeScreen(nav: NavController) {
    Column(
        modifier = Modifier.fillMaxSize(),
        verticalArrangement = Arrangement.Center,
        horizontalAlignment = Alignment.CenterHorizontally
    ) {
        // Aquí está el texto que pediste
        Text(text = "¡Hola, usuario!", fontSize = 30.sp)

        // (Opcional) Un botón para cerrar sesión o volver, si quisieras agregarlo
        // Button(onClick = { nav.popBackStack() }) {
        //     Text("Cerrar Sesión")
        // }
    }
}

// --- VISTA PREVIA (PREVIEW) ---
@Preview(showBackground = true)
@Composable
fun HomeScreenPreview() {
    Clase1Theme {
        // Usamos rememberNavController() para crear un navegador "vacío"
        // que permite visualizar la pantalla sin ejecutar la app.
        HomeScreen(nav = rememberNavController())
    }
}

