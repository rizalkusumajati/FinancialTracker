package com.riztech.financialtracker.di

import com.riztech.financialtracker.domain.interactor.DetailInteractor
import com.riztech.financialtracker.domain.interactor.DetailInteractorImpl
import com.riztech.financialtracker.domain.interactor.HomeInteractor
import com.riztech.financialtracker.domain.interactor.HomeInteractorImpl
import org.koin.dsl.module

val interactorModule = module {
    single<HomeInteractor> { HomeInteractorImpl(get()) }
    single<DetailInteractor> { DetailInteractorImpl(get()) }
}
