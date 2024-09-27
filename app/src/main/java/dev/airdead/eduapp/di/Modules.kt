package dev.airdead.eduapp.di

import dev.airdead.eduapp.navigator.NavService
import dev.airdead.eduapp.navigator.NavigationService
import org.koin.core.module.dsl.singleOf
import org.koin.dsl.bind
import org.koin.dsl.module

val appModules = module {
    singleOf(::NavigationService).bind<NavService>()

}