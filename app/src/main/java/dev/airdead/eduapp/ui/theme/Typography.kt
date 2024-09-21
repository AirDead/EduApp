package dev.airdead.eduapp.ui.theme

import androidx.compose.ui.text.font.FontFamily
import androidx.compose.ui.text.googlefonts.Font
import androidx.compose.ui.text.googlefonts.GoogleFont
import dev.airdead.eduapp.R

val provider = GoogleFont.Provider(
    providerAuthority = "com.google.android.gms.fonts",
    providerPackage = "com.google.android.gms",
    certificates = R.array.com_google_android_gms_fonts_certs
)

val NunitoFont = GoogleFont(name = "Nunito")

val NunitoFontFamily = FontFamily(
    Font(googleFont = NunitoFont, fontProvider = provider),

)
