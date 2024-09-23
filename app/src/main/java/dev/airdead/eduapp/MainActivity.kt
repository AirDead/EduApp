package dev.airdead.eduapp

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.activity.enableEdgeToEdge
import androidx.compose.animation.core.tween
import androidx.compose.animation.slideInHorizontally
import androidx.compose.animation.slideOutHorizontally
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import androidx.navigation.compose.rememberNavController
import dev.airdead.eduapp.ext.Theme
import dev.airdead.eduapp.ext.navigateWithLoading
import dev.airdead.eduapp.ui.screens.LoadingScreen
import dev.airdead.eduapp.ui.screens.LoginScreen
import dev.airdead.eduapp.ui.screens.MainScreen
import dev.airdead.eduapp.ui.screens.RegisterScreen

class MainActivity : ComponentActivity() {

    companion object {
        private const val ANIMATION_DURATION = 500
    }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()

        setContent {
            val navController = rememberNavController()

            Theme {
                NavHost(
                    navController = navController,
                    startDestination = "start",
                    enterTransition = {
                        slideInHorizontally(
                            initialOffsetX = { fullWidth -> fullWidth },
                            animationSpec = tween(ANIMATION_DURATION)
                        )
                    },
                    exitTransition = {
                        slideOutHorizontally(
                            targetOffsetX = { fullWidth -> -fullWidth },
                            animationSpec = tween(ANIMATION_DURATION)
                        )
                    },
                    popEnterTransition = {
                        slideInHorizontally(
                            initialOffsetX = { fullWidth -> -fullWidth },
                            animationSpec = tween(ANIMATION_DURATION)
                        )
                    },
                    popExitTransition = {
                        slideOutHorizontally(
                            targetOffsetX = { fullWidth -> fullWidth },
                            animationSpec = tween(ANIMATION_DURATION)
                        )
                    }
                ) {
                    composable("start") {
                        navController.navigateWithLoading("main", 1)
                    }
                    composable("loading") {
                        LoadingScreen()
                    }
                    composable("main") {
                        MainScreen(
                            onLogin = {
                                navController.navigateWithLoading("login", 1)
                            },
                            onRegister = {
                                navController.navigateWithLoading("register", 1)
                            }
                        )
                    }
                    composable("login") {
                        LoginScreen(navController)
                    }
                    composable("register") {
                        RegisterScreen(navController)
                    }
                }
            }
        }
    }
}
