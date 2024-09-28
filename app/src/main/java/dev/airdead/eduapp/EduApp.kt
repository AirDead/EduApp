package dev.airdead.eduapp

import android.app.Application
import dev.airdead.eduapp.modules.navigator.NavService
import dev.airdead.eduapp.modules.navigator.NavigationService
import dev.airdead.eduapp.modules.userstorage.UserData
import dev.airdead.eduapp.modules.userstorage.UserDataService
import org.koin.android.ext.koin.androidContext
import org.koin.core.context.startKoin
import org.koin.core.module.dsl.singleOf
import org.koin.dsl.bind
import org.koin.dsl.module

class EduApp : Application() {
    override fun onCreate() {
        super.onCreate()

        startKoin {
            androidContext(this@EduApp)
            modules(module {
                singleOf(::NavigationService).bind<NavService>()
                singleOf(::UserDataService).bind<UserData>()
            })
        }
    }
}