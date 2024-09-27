package dev.airdead.eduapp.ui.screens

import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.text.font.FontWeight
import dev.airdead.eduapp.ext.appTheme
import dev.airdead.eduapp.navigator.NavService
import dev.airdead.eduapp.ui.elements.ActionButton
import dev.airdead.eduapp.ui.elements.AppIcon
import dev.airdead.eduapp.ui.theme.NunitoFontFamily
import org.koin.compose.koinInject

@Composable
fun MainScreen() {

    val navigator = koinInject<NavService>()

    Column(
        horizontalAlignment = Alignment.CenterHorizontally,
        verticalArrangement = Arrangement.SpaceBetween,
        modifier = Modifier.fillMaxSize()
    ) {
        Spacer(modifier = Modifier.weight(0.7f))

        AppIcon()

        Text(
            text = "Learn, Solve, Repeat",
            color = Color.White,
            fontWeight = FontWeight.Bold,
            fontFamily = NunitoFontFamily
        )

        Spacer(modifier = Modifier.weight(1.2f))

        ActionButton(
            text = "Login",
            backgroundColor = Color.Transparent,
            borderColor = Color.White,
            textColor = Color.White,
            onClick = {
                navigator.navigateTo("login")
            }
        )

        Spacer(modifier = Modifier.weight(0.1f))

        ActionButton(
            text = "Register",
            backgroundColor = appTheme.primary,
            textColor = appTheme.onPrimary,
            onClick = {
                navigator.navigateTo("register")
            }
        )

        Spacer(modifier = Modifier.weight(0.6f))
    }
}
