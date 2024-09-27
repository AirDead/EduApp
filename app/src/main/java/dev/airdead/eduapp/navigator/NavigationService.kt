package dev.airdead.eduapp.navigator

import androidx.navigation.NavController
import kotlinx.coroutines.CoroutineScope
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.delay
import kotlinx.coroutines.launch

class NavigationService : NavService {
    override var navigator: NavController? = null

    override var currentDestination = navigator?.currentDestination
    override var lastDestination =  navigator?.previousBackStackEntry?.destination

    override fun navigateTo(destination: String) {
        lastDestination = currentDestination
        navigator?.navigate(destination)
        currentDestination = navigator?.currentDestination
    }

    override fun navigateWithAnimation(destination: String, animation: Int) {
        val navController = navigator ?: return

        navController.navigate("loading")
        CoroutineScope(Dispatchers.Main).launch {
            delay(animation * 1000L)
            navController.navigate(destination) {
                popUpTo("loading") { inclusive = true }
            }
        }
    }
}