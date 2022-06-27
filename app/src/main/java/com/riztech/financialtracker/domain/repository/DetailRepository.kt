package com.riztech.financialtracker.domain.repository

import com.riztech.financialtracker.data.remote.response.MovieDetailResponse

interface DetailRepository {
    suspend fun getMovieDetail(movieId: Int): MovieDetailResponse
}