package dev.airdead.eduapp.app.ext

import androidx.compose.foundation.layout.PaddingValues
import androidx.compose.material3.ColorScheme
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Scaffold
import androidx.compose.runtime.Composable
import dev.airdead.eduapp.app.theme.AppTheme

@Composable
inline fun Theme(crossinline content: @Composable (PaddingValues) -> Unit) {
    AppTheme {
        Scaffold { padding ->
            content(padding)
        }
    }
}

val appTheme: ColorScheme
    @Composable
    get() = MaterialTheme.colorScheme