package dev.airdead.eduapp.ext

import androidx.compose.animation.AnimatedContent
import androidx.compose.animation.fadeIn
import androidx.compose.animation.fadeOut
import androidx.compose.animation.slideInVertically
import androidx.compose.animation.slideOutVertically
import androidx.compose.animation.togetherWith
import androidx.compose.runtime.Composable
import androidx.compose.runtime.LaunchedEffect
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import dev.airdead.eduapp.ui.screens.LoadingScreen
import kotlinx.coroutines.delay

@Composable
fun loadingTo(seconds: Int, content: @Composable () -> Unit) {
    var showLoading by remember { mutableStateOf(true) }

    LaunchedEffect(Unit) {
        delay(seconds * 1000L)
        showLoading = false
    }

    AnimatedContent(
        targetState = showLoading,
        transitionSpec = {
            if (targetState) {
                slideInVertically { it } + fadeIn() togetherWith
                        slideOutVertically { -it } + fadeOut()
            } else {
                slideInVertically { -it } + fadeIn() togetherWith
                        slideOutVertically { it } + fadeOut()
            }
        },
        label = "ScreenTransition"
    ) { isLoading ->
        if (isLoading) {
            LoadingScreen()
        } else {
            content()
        }
    }
}