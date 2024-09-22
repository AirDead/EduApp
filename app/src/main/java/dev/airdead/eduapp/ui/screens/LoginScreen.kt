package dev.airdead.eduapp.ui.screens

import androidx.compose.foundation.background
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.Icon
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.style.TextDecoration
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.navigation.NavController
import dev.airdead.eduapp.R
import dev.airdead.eduapp.ext.appTheme
import dev.airdead.eduapp.ext.navigateWithLoading
import dev.airdead.eduapp.ui.elements.ActionButton
import dev.airdead.eduapp.ui.elements.InputField
import dev.airdead.eduapp.ui.theme.NunitoFontFamily

@Composable
fun LoginScreen(navController: NavController) {
    Column(
        horizontalAlignment = Alignment.CenterHorizontally,
        verticalArrangement = Arrangement.SpaceBetween,
        modifier = Modifier.fillMaxSize()
    ) {
        Spacer(modifier = Modifier.weight(1.7f))

        AppIcon()

        Spacer(modifier = Modifier.weight(1f))

        LoginBox(navController)
    }
}

@Composable
fun AppIcon() {
    Icon(
        painter = painterResource(R.drawable.icon),
        contentDescription = "App Icon",
        tint = Color.White,
        modifier = Modifier.size(130.dp)
    )
}

@Composable
fun LoginBox(navController: NavController) {
    Box(
        modifier = Modifier
            .clip(shape = RoundedCornerShape(24.dp, 24.dp, 0.dp, 0.dp))
            .background(appTheme.secondary)
            .fillMaxWidth()
            .height(400.dp)
    ) {
        Column(
            horizontalAlignment = Alignment.CenterHorizontally,
            verticalArrangement = Arrangement.Top,
            modifier = Modifier
                .padding(top = 60.dp)
                .fillMaxSize()
        ) {
            LoginHeader()

            var email by remember { mutableStateOf("") }
            var password by remember { mutableStateOf("") }

            InputField(
                value = email,
                placeholder = "Email",
                onValueChange = { email = it }
            )

            InputField(
                value = password,
                placeholder = "Password",
                onValueChange = { password = it }
            )

            Spacer(modifier = Modifier.weight(0.1f))

            ActionButton(
                text = "Continue",
                backgroundColor = appTheme.onSecondary,
                textColor = Color.White,
                height = 50,
                onClick = {
                    // Handle continue button click
                }
            )

            Spacer(modifier = Modifier.weight(0.1f))

            RegisterText(navController)

            Spacer(modifier = Modifier.weight(1.0f))
        }
    }
}

@Composable
fun LoginHeader() {
    Text(
        text = "Login to your account",
        color = appTheme.onPrimary,
        fontWeight = FontWeight.Bold,
        fontSize = 18.sp,
        fontFamily = NunitoFontFamily
    )
}

@Composable
fun RegisterText(navController: NavController) {
    Row {
        Text(
            text = "Don't have an account? ",
            color = appTheme.onPrimary,
            fontWeight = FontWeight.Bold,
            fontSize = 12.sp,
            fontFamily = NunitoFontFamily
        )
        Text(
            text = "Register",
            color = appTheme.onSecondary,
            fontWeight = FontWeight.Bold,
            fontSize = 12.sp,
            fontFamily = NunitoFontFamily,
            textDecoration = TextDecoration.Underline,
            modifier = Modifier.clickable {
                navController.navigateWithLoading("main", 3)
            }
        )
    }
}