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
fun RegisterScreen() {

    val navigator = koinInject<NavService>()
    val appUser = koinInject<UserData>()

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

                    appUser.login(User(nicknameInput, nicknameInput))

                    navigator.animateNavigate("classSelector", "login", 1)
                }
            },
            bottomText = "Already have an account? ",
            bottomActionText = "Login",
            onBottomActionClick = {
                navigator.animateNavigate("login", 1)
            }
        )
    }
}