package dev.airdead.eduapp.ui.elements

import androidx.compose.foundation.background
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.shape.RoundedCornerShape
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
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.style.TextDecoration
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import dev.airdead.eduapp.ext.appTheme
import dev.airdead.eduapp.ui.theme.NunitoFontFamily

@Composable
fun AuthBox(
    title: String,
    showNicknameField: Boolean = false,
    onContinueClick: (String, String, String?) -> Unit,
    bottomText: String,
    bottomActionText: String,
    onBottomActionClick: () -> Unit
) {
    var nickname by remember { mutableStateOf("") }
    var email by remember { mutableStateOf("") }
    var password by remember { mutableStateOf("") }

    Box(
        modifier = Modifier
            .clip(RoundedCornerShape(topStart = 24.dp, topEnd = 24.dp))
            .background(appTheme.secondary)
            .fillMaxWidth()
            .height(470.dp)
    ) {
        Column(
            horizontalAlignment = Alignment.CenterHorizontally,
            modifier = Modifier
                .padding(top = 60.dp)
                .fillMaxSize()
        ) {
            Text(
                text = title,
                color = appTheme.onPrimary,
                fontWeight = FontWeight.Bold,
                fontSize = 18.sp,
                fontFamily = NunitoFontFamily
            )

            if (showNicknameField) {
                InputField(
                    value = nickname,
                    placeholder = "Nickname",
                    onValueChange = { nickname = it }
                )
            }

            InputField(
                value = email,
                placeholder = "Email",
                onValueChange = { email = it }
            )

            InputField(
                value = password,
                placeholder = "Password",
                onValueChange = { password = it },
                isPassword = true
            )

            Spacer(modifier = Modifier.weight(0.1f))

            ActionButton(
                text = "Continue",
                backgroundColor = appTheme.onSecondary,
                textColor = Color.White,
                height = 50,
                onClick = {
                    onContinueClick(email, password, if (showNicknameField) nickname else null)
                }
            )

            Spacer(modifier = Modifier.weight(0.1f))

            Row {
                Text(
                    text = bottomText,
                    color = appTheme.onPrimary,
                    fontWeight = FontWeight.Bold,
                    fontSize = 12.sp,
                    fontFamily = NunitoFontFamily
                )
                Text(
                    text = bottomActionText,
                    color = appTheme.onSecondary,
                    fontWeight = FontWeight.Bold,
                    fontSize = 12.sp,
                    fontFamily = NunitoFontFamily,
                    textDecoration = TextDecoration.Underline,
                    modifier = Modifier.clickable { onBottomActionClick() }
                )
            }

            Spacer(modifier = Modifier.weight(1.0f))
        }
    }
}
