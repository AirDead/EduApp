package dev.airdead.eduapp

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.activity.enableEdgeToEdge
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import androidx.navigation.compose.rememberNavController
import dev.airdead.eduapp.ext.Theme
import dev.airdead.eduapp.ext.navigateWithLoading
import dev.airdead.eduapp.ui.screens.LoadingScreen
import dev.airdead.eduapp.ui.screens.LoginScreen
import dev.airdead.eduapp.ui.screens.MainScreen

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContent {
            val navController = rememberNavController()
            NavHost(navController, startDestination = "start") {
                composable("start") {
                    navController.navigateWithLoading("main", 3)
                }
                composable("loading") {
                    Theme {
                        LoadingScreen()
                    }
                }
                composable("main") {
                    Theme {
                        MainScreen(
                            onLogin = {
                                navController.navigateWithLoading("login", 1)
                            },
                            onRegister = {
                                navController.navigateWithLoading("register", 1)
                            }
                        )
                    }
                }
                composable("login") {
                    Theme {
                        LoginScreen(navController)
                    }
                }
            }
        }
    }
}

