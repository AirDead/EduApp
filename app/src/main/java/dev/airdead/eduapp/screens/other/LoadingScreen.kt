package dev.airdead.eduapp.screens.other

import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.material3.CircularProgressIndicator
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.unit.dp
import dev.airdead.eduapp.app.elements.AppIcon

@Composable
fun LoadingScreen() {
    Column(
        horizontalAlignment = Alignment.CenterHorizontally,
        verticalArrangement = Arrangement.Top,
        modifier = Modifier.fillMaxSize()
    ) {
        Spacer(modifier = Modifier.weight(1.3f))

        AppIcon()

        Spacer(modifier = Modifier.weight(0.1f))

        CircularProgressIndicator(
            color = Color(250, 250, 250),
            strokeWidth = 4.dp
        )

        Spacer(modifier = Modifier.weight(1.6f))
    }
}