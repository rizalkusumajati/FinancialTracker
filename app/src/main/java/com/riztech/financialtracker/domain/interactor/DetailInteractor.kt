package com.riztech.financialtracker.domain.interactor

import com.riztech.financialtracker.domain.model.MovieDetail

interface DetailInteractor {
    suspend fun getMovieDetail(movieId: Int): MovieDetail
}