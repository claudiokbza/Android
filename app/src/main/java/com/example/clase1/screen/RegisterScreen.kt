package com.example.clase1.screen

import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.text.KeyboardOptions
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
import androidx.compose.ui.text.input.KeyboardType
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.navigation.NavController
import androidx.navigation.compose.rememberNavController
import com.example.clase1.ui.theme.Clase1Theme

@Composable
fun RegisterContent(
    nombre: String, onNombreChange: (String) -> Unit,
    apellido: String, onApellidoChange: (String) -> Unit, // 1. Campo Nuevo
    telefono: String, onTelefonoChange: (String) -> Unit, // 1. Campo Nuevo
    email: String, onEmailChange: (String) -> Unit,
    pass: String, onPassChange: (String) -> Unit,
    onRegisterClick: () -> Unit,
    onBackClick: () -> Unit
) {
    Column(
        modifier = Modifier
            .fillMaxSize()
            .padding(20.dp),
        verticalArrangement = Arrangement.Center,
        horizontalAlignment = Alignment.CenterHorizontally
    ) {
        Text("Crear Cuenta", fontSize = 23.sp)

        Spacer(Modifier.height(12.dp))

        // Campo Nombre
        OutlinedTextField(
            value = nombre,
            onValueChange = onNombreChange,
            label = { Text("Nombre") },
            modifier = Modifier.fillMaxWidth()
        )

        Spacer(Modifier.height(8.dp))

        // 2. Campo Apellido (Nuevo)
        OutlinedTextField(
            value = apellido,
            onValueChange = onApellidoChange,
            label = { Text("Apellido") },
            modifier = Modifier.fillMaxWidth()
        )

        Spacer(Modifier.height(8.dp))

        // 2. Campo Teléfono (Nuevo)
        OutlinedTextField(
            value = telefono,
            onValueChange = onTelefonoChange,
            label = { Text("Teléfono") },
            // Configuración extra: Teclado numérico para el teléfono
            keyboardOptions = KeyboardOptions(keyboardType = KeyboardType.Phone),
            modifier = Modifier.fillMaxWidth()
        )

        Spacer(Modifier.height(8.dp))

        // Campo Email
        OutlinedTextField(
            value = email,
            onValueChange = onEmailChange,
            label = { Text("Email") },
            keyboardOptions = KeyboardOptions(keyboardType = KeyboardType.Email),
            modifier = Modifier.fillMaxWidth()
        )

        Spacer(Modifier.height(8.dp))

        // Campo Contraseña
        OutlinedTextField(
            value = pass,
            onValueChange = onPassChange,
            label = { Text("Contraseña") },
            modifier = Modifier.fillMaxWidth()
        )

        Spacer(Modifier.height(16.dp))

        Button(onClick = onRegisterClick, modifier = Modifier.fillMaxWidth()) {
            Text("Registrarse")
        }

        TextButton(onClick = onBackClick) {
            Text("¿Ya tienes cuenta? Volver")
        }
    }
}

@Composable
fun RegisterScreen(nav: NavController) {
    // Estados para guardar lo que escribe el usuario
    var nombre by remember { mutableStateOf("") }
    var apellido by remember { mutableStateOf("") } // Estado nuevo
    var telefono by remember { mutableStateOf("") } // Estado nuevo
    var email by remember { mutableStateOf("") }
    var pass by remember { mutableStateOf("") }

    RegisterContent(
        nombre = nombre, onNombreChange = { nombre = it },
        apellido = apellido, onApellidoChange = { apellido = it },
        telefono = telefono, onTelefonoChange = { telefono = it },
        email = email, onEmailChange = { email = it },
        pass = pass, onPassChange = { pass = it },
        onRegisterClick = {
            // Aquí iría la lógica de registro
            nav.popBackStack() // Vuelve atrás por ahora
        },
        onBackClick = { nav.popBackStack() }
    )
}

// 3. Anotación de Vista Previa (Preview)
@Preview(showBackground = true)
@Composable
fun RegisterScreenPreview() {
    Clase1Theme {
        // Pasamos un NavController falso para la preview
        RegisterScreen(nav = rememberNavController())
    }
}
