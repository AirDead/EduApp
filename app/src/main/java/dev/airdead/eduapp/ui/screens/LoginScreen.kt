package dev.airdead.eduapp.ui.screens

import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.lifecycle.viewmodel.compose.viewModel
import androidx.navigation.NavController
import dev.airdead.eduapp.AuthViewModel
import dev.airdead.eduapp.ext.navigateWithLoading
import dev.airdead.eduapp.ui.elements.AppIcon
import dev.airdead.eduapp.ui.elements.AuthBox

@Composable
fun LoginScreen(navController: NavController, authViewModel: AuthViewModel = viewModel()) {
    var email by remember { mutableStateOf("") }
    var password by remember { mutableStateOf("") }
    var loginError by remember { mutableStateOf(false) }

    Column(
        horizontalAlignment = Alignment.CenterHorizontally,
        modifier = Modifier.fillMaxSize()
    ) {
        Spacer(modifier = Modifier.weight(1.7f))

        AppIcon()

        Spacer(modifier = Modifier.weight(1f))

        AuthBox(
            title = "Login to your account",
            onContinueClick = { _, emailInput, passwordInput ->
                if (passwordInput != null) {
                    authViewModel.loginUser(emailInput, passwordInput) { isSuccess ->
                        if (isSuccess) {
                            navController.navigateWithLoading("main", 1)
                        } else {
                            loginError = true // Покажем ошибку
                        }
                    }
                }
            },
            bottomText = "Don't have an account? ",
            bottomActionText = "Register",
            onBottomActionClick = {
                navController.navigateWithLoading("register", 1)
            }
        )

        if (loginError) {
            Text("Login failed. Please try again.", color = Color.Red)
        }
    }
}