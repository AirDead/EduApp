package dev.airdead.eduapp.ui.theme

import androidx.compose.ui.graphics.Color

val DarkBlue = Color(25, 25, 47)
val NightBlue = Color(70, 72, 239)

val LightBlue = Color(62, 64, 232)


sealed class ThemeColors(
    val background: Color,
    val surface: Color,
    val primary: Color,
    val text: Color
)  {
    object Night: ThemeColors(
        background = DarkBlue,
        primary = NightBlue,
        surface = Color.White,
        text = Color.White
    )
    object Day: ThemeColors(
        background = LightBlue,
        primary = Color.White,
        surface = Color.Black,
        text = Color.Black
    )
}