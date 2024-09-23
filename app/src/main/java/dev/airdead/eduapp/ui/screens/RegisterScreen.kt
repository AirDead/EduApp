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
fun RegisterScreen(navController: NavController, authViewModel: AuthViewModel = viewModel()) {
    var nickname by remember { mutableStateOf("") }
    var email by remember { mutableStateOf("") }
    var password by remember { mutableStateOf("") }
    var registerError by remember { mutableStateOf(false) }

    Column(
        horizontalAlignment = Alignment.CenterHorizontally,
        modifier = Modifier.fillMaxSize()
    ) {
        Spacer(modifier = Modifier.weight(0.6f))

        AppIcon()

        Spacer(modifier = Modifier.weight(0.6f))

        AuthBox(
            title = "Register a new account",
            showNicknameField = true,
            onContinueClick = { nicknameInput, emailInput, passwordInput ->
                if (passwordInput != null) {
                    authViewModel.registerUser(nicknameInput, emailInput, passwordInput) { isSuccess ->
                        if (isSuccess) {
                            navController.navigateWithLoading("login", 1)
                        } else {
                            registerError = true
                        }
                    }
                }
            },
            bottomText = "Already have an account? ",
            bottomActionText = "Login",
            onBottomActionClick = {
                navController.navigateWithLoading("login", 1)
            }
        )

        if (registerError) {
            Text("Registration failed. Please try again.", color = Color.Red)
        }
    }
}