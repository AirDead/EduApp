package dev.airdead.eduapp.ui.screens

import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import dev.airdead.eduapp.ext.appTheme
import dev.airdead.eduapp.ui.elements.ActionButton
import dev.airdead.eduapp.ui.elements.AppIcon

@Composable
fun ClassSelector() {
    Column(
        horizontalAlignment = Alignment.CenterHorizontally,
        modifier = Modifier.fillMaxSize()
    ) {
        Spacer(modifier = Modifier.weight(1.7f))

        AppIcon()

        Spacer(modifier = Modifier.weight(0.8f))

        Box(
            modifier = Modifier
                .clip(RoundedCornerShape(topStart = 24.dp, topEnd = 24.dp))
                .background(appTheme.secondary)
                .fillMaxWidth()
                .height(420.dp)
        ) {
            Column(
                horizontalAlignment = Alignment.CenterHorizontally,
                modifier = Modifier
                    .padding(top = 40.dp)
                    .fillMaxSize()
            ) {

                Text(
                    text = "Choose your class",
                    color = appTheme.onPrimary,
                    fontSize = 20.sp,
                    fontWeight = FontWeight.Bold,
                    modifier = Modifier.padding(top = 56.dp)
                )

                ActionButton(
                    text = "Continue",
                    backgroundColor = appTheme.onSecondary,
                    textColor = Color.White,
                    height = 50,
                    onClick = {
                    }
                )
            }

        }
    }
}