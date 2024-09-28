package dev.airdead.eduapp.app.elements

import androidx.compose.foundation.layout.size
import androidx.compose.material3.Icon
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.unit.dp
import dev.airdead.eduapp.R

@Composable
fun AppIcon() {
    Icon(
        painter = painterResource(R.drawable.icon),
        contentDescription = "App Icon",
        tint = Color.White,
        modifier = Modifier.size(130.dp)
    )
}
