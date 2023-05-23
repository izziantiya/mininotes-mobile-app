package com.izziantiya.mininotes

import android.app.Application
import com.izziantiya.mininotes.di.databaseModule
import com.izziantiya.mininotes.di.domainModule
import com.izziantiya.mininotes.di.uiModule
import com.izziantiya.mininotes.helpers.LineLoggingTree
import org.koin.android.ext.koin.androidContext
import org.koin.core.context.startKoin
import timber.log.Timber

class App : Application() {
    override fun onCreate() {
        super.onCreate()
        startKoin {
            androidContext(this@App)
            modules(databaseModule, domainModule, uiModule)
        }

        Timber.plant(LineLoggingTree())
        Timber.tag("Mininotes").i("App started")
    }
}