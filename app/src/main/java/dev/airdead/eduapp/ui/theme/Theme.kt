package dev.airdead.eduapp.ui.theme

import androidx.compose.foundation.isSystemInDarkTheme
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.darkColorScheme
import androidx.compose.material3.lightColorScheme
import androidx.compose.runtime.Composable

val DarkColorScheme = darkColorScheme(
    primary = ThemeColors.Night.primary,
    secondary = ThemeColors.Night.secondary,
    onPrimary = ThemeColors.Night.text,
    onSecondary = ThemeColors.Night.button,
    background = ThemeColors.Night.background
)

val LightColorScheme = lightColorScheme(
    primary = ThemeColors.Day.primary,
    secondary = ThemeColors.Day.secondary,
    onPrimary = ThemeColors.Day.text,
    onSecondary = ThemeColors.Day.button,
    background = ThemeColors.Day.background
)

@Composable
fun AppTheme(darkTheme: Boolean = isSystemInDarkTheme(), content: @Composable () -> Unit) {
    val colors = if (darkTheme) {
        DarkColorScheme
    } else {
        LightColorScheme
    }

    MaterialTheme(
        colorScheme = colors,
        content = content
    )
}