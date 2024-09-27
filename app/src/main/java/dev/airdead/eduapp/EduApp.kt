package dev.airdead.eduapp

import android.app.Application
import dev.airdead.eduapp.di.appModules
import org.koin.android.ext.koin.androidContext
import org.koin.core.context.startKoin

class EduApp : Application() {
    override fun onCreate() {
        super.onCreate()

        startKoin {
            androidContext(this@EduApp)
            modules(appModules)
        }
    }
}