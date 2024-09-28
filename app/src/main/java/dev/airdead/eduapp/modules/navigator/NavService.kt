@file:Suppress("NOTHING_TO_INLINE")

package dev.airdead.eduapp.modules.navigator

import androidx.navigation.NavController
import androidx.navigation.NavDestination

interface NavService {
    var controller: NavController?
    var currentDestination: NavDestination?
    var lastDestination: NavDestination?

    fun setNavigator(navController: NavController) {
        controller = navController
    }

    fun navigate(destination: String)

    fun animateNavigate(destination: String, duration: Int)
    fun animateNavigate(destination: String, popUpTo: String, duration: Int)
}

