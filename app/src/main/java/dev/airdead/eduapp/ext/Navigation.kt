package dev.airdead.eduapp.ext

import androidx.navigation.NavController
import kotlinx.coroutines.CoroutineScope
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.delay
import kotlinx.coroutines.launch

fun NavController.navigateWithLoading(
    destination: String,
    delaySeconds: Int = 3
) {
    navigate("loading")

    CoroutineScope(Dispatchers.Main).launch {
        delay(delaySeconds * 1000L)
        navigate(destination) {
            popUpTo("main") { inclusive = true }
        }
    }
}