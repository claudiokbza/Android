package com.example.clase1.screen


import androidx.compose.foundation.Image
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.Button
import androidx.compose.material3.OutlinedTextField
import androidx.compose.material3.Text
import androidx.compose.material3.TextButton
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.navigation.NavController
import com.example.clase1.nav.Route
import com.example.clase1.ui.theme.Clase1Theme
import androidx.compose.ui.res.painterResource
import androidx.compose.foundation.layout.size
import com.example.clase1.R

@Composable
fun LoginContent( user: String, pass: String,
                  onUserChange: (String) -> Unit, onPassChange: (String) -> Unit, onLoginClick: () -> Unit, onRegisterClick: () -> Unit
) {
    Column(
        modifier = Modifier
            .fillMaxSize()
            .padding(20.dp),
        verticalArrangement = Arrangement.Center,
        // Agregamos esto para que todo se centre horizontalmente por defecto
        horizontalAlignment = Alignment.CenterHorizontally
    ) {

        // --- 1. AQUÍ AGREGAMOS LA IMAGEN ---
        Image(
            // Reemplaza 'R.drawable.tu_logo' por el nombre real de tu archivo (ej. R.drawable.tulio_trivino)
            // Si no tienes imagen aún, prueba con: R.mipmap.ic_launcher
            painter = painterResource(id = R.drawable.bodoque),
            contentDescription = "Logo de la aplicación",
            modifier = Modifier
                .size(100.dp) // Tamaño de la imagen (ajusta según necesites)
                .padding(bottom = 16.dp) // Espacio debajo de la imagen
        )
        // ----------------------------------

        Text("Bienvenido", fontSize = 23.sp) // Quitamos el modifier.align porque ya lo pusimos en la Columna

        Spacer(Modifier.height(12.dp))

        OutlinedTextField(user, onUserChange, label = { Text("Usuario") }, modifier = Modifier.fillMaxWidth())

        Spacer(Modifier.height(8.dp))

        // Tip: Agregué fillMaxWidth aquí también para que se vea igual al de arriba
        OutlinedTextField(pass, onPassChange, label = { Text("Contraseña") }, modifier = Modifier.fillMaxWidth())

        Spacer(Modifier.height(16.dp))

        Button(onClick = onLoginClick, modifier = Modifier.fillMaxWidth()) {
            Text("Ingresar")
        }

        TextButton(onClick = onRegisterClick, modifier = Modifier.align(Alignment.End)) {
            Text("¿No tienes cuenta? Regístrate")
        }
    }
}

@Composable
fun LoginScreen(nav: NavController) {
    var user by remember { mutableStateOf("") }
    var pass by remember { mutableStateOf("") }

    LoginContent(
        user, pass,
        onUserChange = { user = it }, onPassChange = { pass = it },
        onLoginClick = { nav.navigate(Route.Home.path) }, onRegisterClick = { nav.navigate(Route.Register.path) }
    )
}

@Preview(showBackground = true)
@Composable
fun LoginContentPreview() {
        Clase1Theme {
            LoginContent(
                user = "javier@demo.cl", pass = "123456",
                onUserChange = {}, onPassChange = {}, onLoginClick = {}, onRegisterClick = {}
            )
    }
}

