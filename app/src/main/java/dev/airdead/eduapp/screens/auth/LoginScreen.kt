package dev.airdead.eduapp.screens.auth

import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import dev.airdead.eduapp.app.elements.AppIcon
import dev.airdead.eduapp.app.elements.AuthBox
import dev.airdead.eduapp.modules.navigator.NavService
import dev.airdead.eduapp.modules.userstorage.UserData
import dev.airdead.eduapp.modules.userstorage.models.User
import org.koin.compose.koinInject

@Composable
fun LoginScreen() {
    val navigator = koinInject<NavService>()
    val appUser = koinInject<UserData>()

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

                appUser.login(User("null", emailInput))

                navigator.animateNavigate("classSelector", "login", 1)
            },
            bottomText = "Don't have an account? ",
            bottomActionText = "Register",
            onBottomActionClick = {
                navigator.animateNavigate("register", 1)
            }
        )
    }
}