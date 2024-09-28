package dev.airdead.eduapp.modules.navigator

import androidx.navigation.NavController
import kotlinx.coroutines.CoroutineScope
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.delay
import kotlinx.coroutines.launch

class NavigationService : NavService {
    override var controller: NavController? = null

    override var currentDestination = controller?.currentDestination
    override var lastDestination =  controller?.previousBackStackEntry?.destination

    override fun navigate(destination: String) {
        lastDestination = currentDestination
        controller?.navigate(destination)
        currentDestination = controller?.currentDestination
    }

    override fun animateNavigate(destination: String, duration: Int) {
        controller?.let { navController ->
            navController.navigate("loading")
            CoroutineScope(Dispatchers.Main).launch {
                delay(duration * 1000L)
                navController.navigate(destination)
            }
        }
    }

    override fun animateNavigate(destination: String, popUpTo: String, duration: Int) {
        controller?.let { navController ->
            navController.navigate("loading")
            CoroutineScope(Dispatchers.Main).launch {
                delay(duration * 1000L)
                navController.navigate(destination) {
                    popUpTo(popUpTo) { inclusive = true }
                }
            }
        }
    }

}