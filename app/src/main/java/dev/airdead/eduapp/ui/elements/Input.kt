package dev.airdead.eduapp.ui.elements

import androidx.compose.foundation.border
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.OutlinedTextField
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.dp
import dev.airdead.eduapp.ext.OutlineColors
import dev.airdead.eduapp.ext.appTheme


@Composable
fun InputField(value: String, placeholder: String, onValueChange: (String) -> Unit) {
    Box(
        modifier = Modifier
            .fillMaxWidth(0.9f)
            .padding(vertical = 8.dp)
            .clip(RoundedCornerShape(16.dp))
            .border(2.dp, appTheme.onPrimary, shape = RoundedCornerShape(16.dp))
            .height(60.dp)
    ) {
        OutlinedTextField(
            value = value,
            onValueChange = onValueChange,
            placeholder = {
                Text(
                    text = placeholder,
                    color = appTheme.onPrimary,
                    fontWeight = FontWeight.ExtraBold
                )
            },
            modifier = Modifier
                .fillMaxSize(),
            shape = RoundedCornerShape(12.dp),
            singleLine = true,
            colors = OutlineColors
        )
    }
}