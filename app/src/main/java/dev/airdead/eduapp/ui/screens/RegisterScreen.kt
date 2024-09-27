package dev.airdead.eduapp.ui.screens

import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import dev.airdead.eduapp.navigator.NavService
import dev.airdead.eduapp.ui.elements.AppIcon
import dev.airdead.eduapp.ui.elements.AuthBox
import org.koin.compose.koinInject

@Composable
fun RegisterScreen() {

    val navigator = koinInject<NavService>()

    Column(
        horizontalAlignment = Alignment.CenterHorizontally,
        modifier = Modifier.fillMaxSize()
    ) {
        Spacer(modifier = Modifier.weight(0.6f))

        AppIcon()

        Spacer(modifier = Modifier.weight(0.6f))

        AuthBox(
            title = "Register a new account",
            height = 450,
            showNicknameField = true,
            onContinueClick = { nicknameInput, emailInput, passwordInput ->
                if (passwordInput != null) {
                    // TODO: Implement login logic
                    navigator.navigateWithAnimation("classSelector", 1)
                }
            },
            bottomText = "Already have an account? ",
            bottomActionText = "Login",
            onBottomActionClick = {
                navigator.navigateWithAnimation("login", 1)
            }
        )
    }
}