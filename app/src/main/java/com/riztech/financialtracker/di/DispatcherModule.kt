package com.riztech.financialtracker.di

import kotlinx.coroutines.CoroutineDispatcher
import kotlinx.coroutines.Dispatchers
import org.koin.dsl.module

val dispatcherModule = module {
    single { provideDispatchers() }
}

    fun provideDispatchers(): CoroutineDispatcher = Dispatchers.IO
