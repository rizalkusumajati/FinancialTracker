package com.riztech.financialtracker.presentation.home

import com.airbnb.mvrx.MavericksViewModel
import com.airbnb.mvrx.MavericksViewModelFactory
import com.airbnb.mvrx.ViewModelContext
import com.riztech.financialtracker.domain.interactor.HomeInteractor
import kotlinx.coroutines.CoroutineDispatcher
import org.koin.android.ext.android.inject

class HomeViewModel(
    val initialState: HomeState,
    val homeInteractor: HomeInteractor,
    val dispatcher: CoroutineDispatcher
): MavericksViewModel<HomeState>(initialState) {

    companion object: MavericksViewModelFactory<HomeViewModel, HomeState> {
        override fun create(viewModelContext: ViewModelContext, state: HomeState): HomeViewModel? {
            val interactor: HomeInteractor by viewModelContext.activity.inject()
            val dispatcher: CoroutineDispatcher by viewModelContext.activity.inject()
            return HomeViewModel(state, interactor, dispatcher)
        }
    }

    init {
        getGenre()
        getMovies()
    }

    fun getGenre() {
        suspend {
            homeInteractor.getGenre()
        }.execute(dispatcher) {
            copy(categories = it)
        }
    }

    fun getMovies() {
        suspend {
            homeInteractor.getMovies()
        }.execute(dispatcher) {
            copy(movies = it)
        }
    }

}