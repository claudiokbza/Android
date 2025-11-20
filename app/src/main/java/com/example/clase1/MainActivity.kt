package com.example.clase1

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.tooling.preview.Preview
import androidx.core.splashscreen.SplashScreen.Companion.installSplashScreen
import androidx.lifecycle.lifecycleScope
import com.example.clase1.nav.AppNavGraph
import com.example.clase1.ui.theme.Clase1Theme

class MainActivity : ComponentActivity() {
    private var keepSplash = true
    override fun onCreate(savedInstanceState: Bundle?) {
        val splash = installSplashScreen()
        splash.setKeepOnScreenCondition { keepSplash }
        super.onCreate(savedInstanceState)

        lifecycleScope.launchWhenCreated {
            kotlinx.coroutines.delay(1200L)
            keepSplash = false
        }

        setContent {

            Clase1Theme { AppNavGraph() }
        }
    }
}


@Composable
fun Greeting(name: String, modifier: Modifier = Modifier) {
    Text(
        text = "Hola,  $name!",
        modifier = modifier
    )
}

@Preview(showBackground = true)
@Composable
fun GreetingPreview() {
    Clase1Theme {
        Greeting("Usuario")
    }
}
