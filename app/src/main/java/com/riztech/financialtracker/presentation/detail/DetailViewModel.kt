package com.riztech.financialtracker.presentation.detail

import com.airbnb.mvrx.MavericksViewModel
import com.airbnb.mvrx.MavericksViewModelFactory
import com.airbnb.mvrx.ViewModelContext
import com.riztech.financialtracker.domain.interactor.DetailInteractor
import com.riztech.financialtracker.domain.model.Movie
import kotlinx.coroutines.CoroutineDispatcher
import org.koin.android.ext.android.inject

class DetailViewModel(
    val initialState: DetailState,
    val detailInteractor: DetailInteractor,
    val dispatcher: CoroutineDispatcher
): MavericksViewModel<DetailState>(initialState)  {

    companion object: MavericksViewModelFactory<DetailViewModel, DetailState>{
        override fun create(
            viewModelContext: ViewModelContext,
            state: DetailState
        ): DetailViewModel? {
            val interactor: DetailInteractor by viewModelContext.activity.inject()
            val dispatcher: CoroutineDispatcher by viewModelContext.activity.inject()
            return DetailViewModel(state, interactor, dispatcher)
        }
    }

    fun getDetail(movieDetail: Movie){
        suspend {
            detailInteractor.getMovieDetail(movieDetail.id)
        }.execute(dispatcher) {
            copy(movie = it)
        }
    }
}