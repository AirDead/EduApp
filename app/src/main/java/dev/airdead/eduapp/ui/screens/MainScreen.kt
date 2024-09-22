package dev.airdead.eduapp.ui.screens

import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.size
import androidx.compose.material3.Icon
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.dp
import dev.airdead.eduapp.R
import dev.airdead.eduapp.ext.appTheme
import dev.airdead.eduapp.ui.elements.ActionButton
import dev.airdead.eduapp.ui.theme.NunitoFontFamily

@Composable
fun MainScreen() {
    Column(
        horizontalAlignment = Alignment.CenterHorizontally,
        verticalArrangement = Arrangement.SpaceBetween,
        modifier = Modifier.fillMaxSize()
    ) {
        Spacer(modifier = Modifier.weight(0.7f))

        Icon(
            painter = painterResource(R.drawable.icon),
            contentDescription = "App Icon",
            tint = Color.White,
            modifier = Modifier.size(110.dp)
        )

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
            textColor = Color.White
        ) {
            // TODO: Swap to login screen
        }

        Spacer(modifier = Modifier.weight(0.1f))

        ActionButton(
            text = "Register",
            backgroundColor = appTheme.primary,
            textColor = appTheme.onPrimary
        ) {
            // TODO: Swap to register screen
        }

        Spacer(modifier = Modifier.weight(0.6f))
    }
}


