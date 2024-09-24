package dev.airdead.eduapp.ui.screens

import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.navigation.NavController
import dev.airdead.eduapp.ext.navigateWithLoading
import dev.airdead.eduapp.ui.elements.AppIcon
import dev.airdead.eduapp.ui.elements.AuthBox

@Composable
fun RegisterScreen(navController: NavController) {

    Column(
        horizontalAlignment = Alignment.CenterHorizontally,
        modifier = Modifier.fillMaxSize()
    ) {
        Spacer(modifier = Modifier.weight(0.6f))

        AppIcon()

        Spacer(modifier = Modifier.weight(0.6f))

        AuthBox(
            title = "Register a new account",
            height = 420,
            showNicknameField = true,
            onContinueClick = { nicknameInput, emailInput, passwordInput ->
                if (passwordInput != null) {
                    navController.navigateWithLoading("login", 1)
                }
            },
            bottomText = "Already have an account? ",
            bottomActionText = "Login",
            onBottomActionClick = {
                navController.navigateWithLoading("login", 1)
            }
        )
    }
}