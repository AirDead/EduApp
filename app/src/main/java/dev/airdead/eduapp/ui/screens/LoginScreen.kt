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
fun LoginScreen() {
    val navigator = koinInject<NavService>()

    Column(
        horizontalAlignment = Alignment.CenterHorizontally,
        modifier = Modifier.fillMaxSize()
    ) {
        Spacer(modifier = Modifier.weight(1.7f))

        AppIcon()

        Spacer(modifier = Modifier.weight(1f))

        AuthBox(
            title = "Login to your account",
            height = 370,
            onContinueClick = { emailInput, passwordInput, _ ->
                // TODO: Implement login logic
                navigator.navigateWithAnimation("classSelector", 1)
            },
            bottomText = "Don't have an account? ",
            bottomActionText = "Register",
            onBottomActionClick = {
                navigator.navigateWithAnimation("register", 1)
            }
        )
    }
}