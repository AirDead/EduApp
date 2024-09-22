package dev.airdead.eduapp.ui.theme

import androidx.compose.ui.graphics.Color

val DarkBlue = Color(25, 25, 47)
val NightBlue = Color(70, 72, 239)
val VeryDarkBlue = Color(19, 19, 36)

val LightBlue = Color(62, 64, 232)


sealed class ThemeColors(
    val background: Color,
    val primary: Color,
    val secondary: Color,
    val button: Color,
    val text: Color
)  {
    data object Night: ThemeColors(
        background = DarkBlue,
        primary = NightBlue,
        secondary = VeryDarkBlue,
        button = NightBlue,
        text = Color.White
    )
    data object Day: ThemeColors(
        background = LightBlue,
        primary = Color.White,
        secondary = Color.White,
        button = NightBlue,
        text = Color.Black
    )
}