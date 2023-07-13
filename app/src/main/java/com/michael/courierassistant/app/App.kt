package com.michael.courierassistant.app

import android.app.Application
import com.michael.courierassistant.data.di.dataModule
import com.michael.courierassistant.domain.di.domainModule
import com.michael.courierassistant.presenter.di.appModule
import org.koin.android.ext.koin.androidContext
import org.koin.android.ext.koin.androidLogger
import org.koin.core.context.startKoin
import org.koin.core.logger.Level

class App : Application() {

    override fun onCreate() {
        super.onCreate()
        startKoin {
            androidLogger(Level.DEBUG)
            androidContext(this@App)
            modules(listOf(appModule, domainModule, dataModule))
        }
    }
}