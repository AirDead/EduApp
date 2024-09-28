package dev.airdead.eduapp

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.activity.enableEdgeToEdge
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import androidx.navigation.compose.rememberNavController
import dev.airdead.eduapp.app.ext.Theme
import dev.airdead.eduapp.modules.navigator.NavService
import dev.airdead.eduapp.modules.userstorage.UserData
import dev.airdead.eduapp.screens.auth.LoginScreen
import dev.airdead.eduapp.screens.auth.RegisterScreen
import dev.airdead.eduapp.screens.other.LoadingScreen
import dev.airdead.eduapp.screens.other.MainScreen
import dev.airdead.eduapp.screens.profile.ClassSelector
import dev.airdead.eduapp.screens.profile.ProfileScreen
import org.koin.android.ext.android.inject

class MainActivity : ComponentActivity() {

    val navService by inject<NavService>()
    val userData by inject<UserData>()

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()

        setContent {
            Theme {
                val navController = rememberNavController()
                navService.setNavigator(navController)

                val startDestination = when {
                    userData.isLogged() -> "classSelector"
                    userData.isClassSelected() -> "profile"
                    else -> "main"
                }

                NavHost(navController, startDestination) {
                    composable("loading") { LoadingScreen() }
                    composable("main") { MainScreen() }
                    composable("register") { RegisterScreen() }
                    composable("login") { LoginScreen() }
                    composable("classSelector") { ClassSelector() }
                    composable("profile") { ProfileScreen() }
                }
            }
        }
    }
}