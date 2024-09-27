package dev.airdead.eduapp

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.activity.enableEdgeToEdge
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import androidx.navigation.compose.rememberNavController
import dev.airdead.eduapp.ext.Theme
import dev.airdead.eduapp.navigator.NavService
import dev.airdead.eduapp.ui.screens.ClassSelector
import dev.airdead.eduapp.ui.screens.LoadingScreen
import dev.airdead.eduapp.ui.screens.LoginScreen
import dev.airdead.eduapp.ui.screens.MainScreen
import dev.airdead.eduapp.ui.screens.RegisterScreen
import org.koin.android.ext.android.inject

class MainActivity : ComponentActivity() {

    val navService by inject<NavService>()

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()

        setContent {
            Theme {
                val navController = rememberNavController()

                navService.changeNavigator(navController)

                NavHost(
                    navController = navController,
                    startDestination = "main"
                ) {
                    composable("loading") { LoadingScreen() }
                    composable("main") { MainScreen() }
                    composable("login") { LoginScreen() }
                    composable("register") { RegisterScreen() }
                    composable("classSelector") {  ClassSelector() }
                }
            }
        }
    }
}
