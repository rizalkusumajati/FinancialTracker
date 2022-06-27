package com.riztech.financialtracker.di

import com.riztech.financialtracker.data.remote.ApiClient
import com.riztech.financialtracker.data.repository.DetailRepositoryImpl
import com.riztech.financialtracker.data.repository.HomeRepositoryImpl
import com.riztech.financialtracker.domain.repository.DetailRepository
import com.riztech.financialtracker.domain.repository.HomeRepository
import org.koin.dsl.module


val repositoryModule = module {
    single<HomeRepository> { HomeRepositoryImpl(get()) }
    single<DetailRepository> { DetailRepositoryImpl(get()) }
}