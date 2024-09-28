package dev.airdead.eduapp.app.ext

import androidx.compose.material3.OutlinedTextFieldDefaults
import androidx.compose.runtime.Composable
import androidx.compose.ui.graphics.Color


val OutlineColors
    @Composable
    get() = OutlinedTextFieldDefaults.colors(
    focusedTextColor = appTheme.onPrimary,
    unfocusedTextColor = appTheme.onPrimary,
    disabledTextColor = Color.Gray,
    errorTextColor = Color.Red,
    focusedContainerColor = Color.Transparent,
    unfocusedContainerColor = Color.Transparent,
    disabledContainerColor = Color.Transparent,
    errorContainerColor = Color.Transparent,
    cursorColor = Color.White,
    focusedBorderColor = Color.Transparent,
    unfocusedBorderColor = Color.Transparent,
    errorBorderColor = Color.Red
)