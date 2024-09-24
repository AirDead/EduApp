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
fun LoginScreen(navController: NavController) {

    Column(
        horizontalAlignment = Alignment.CenterHorizontally,
        modifier = Modifier.fillMaxSize()
    ) {
        Spacer(modifier = Modifier.weight(1.7f))

        AppIcon()

        Spacer(modifier = Modifier.weight(1f))

        AuthBox(
            title = "Login to your account",
            height = 340,
            onContinueClick = { _, emailInput, passwordInput ->
                if (passwordInput != null) {
                    navController.navigateWithLoading("main", 1)
                }
            },
            bottomText = "Don't have an account? ",
            bottomActionText = "Register",
            onBottomActionClick = {
                navController.navigateWithLoading("register", 1)
            }
        )
    }
}