package dev.airdead.eduapp.navigator

import androidx.navigation.NavController
import androidx.navigation.NavDestination

interface NavService {
    var navigator: NavController?
    var currentDestination: NavDestination?
    var lastDestination: NavDestination?

    fun changeNavigator(navController: NavController) {
        navigator = navController
    }
    fun navigateTo(destination: String)
    fun navigateWithAnimation(destination: String, animation: Int)
}
