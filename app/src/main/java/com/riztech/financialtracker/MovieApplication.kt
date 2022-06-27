package com.riztech.financialtracker

import android.app.Application
import com.airbnb.mvrx.mocking.MockableMavericks
import com.riztech.financialtracker.di.dispatcherModule
import com.riztech.financialtracker.di.interactorModule
import com.riztech.financialtracker.di.repositoryModule
import com.riztech.financialtracker.di.retrofitModule
import org.koin.android.ext.koin.androidContext
import org.koin.core.context.startKoin

//import dagger.hilt.android.HiltAndroidApp

//@HiltAndroidApp
class MovieApplication: Application() {
    override fun onCreate() {
        super.onCreate()
        MockableMavericks.initialize(this)
        startKoin {
            androidContext(this@MovieApplication)
            modules(
                listOf(
                   dispatcherModule,
                   interactorModule,
                   repositoryModule,
                   retrofitModule
                )
            )
        }
    }
}