package com.riztech.financialtracker.domain.repository

import com.riztech.financialtracker.data.remote.response.GenreResponse
import com.riztech.financialtracker.data.remote.response.MovieDetailResponse
import com.riztech.financialtracker.data.remote.response.MovieResponse

interface HomeRepository {
    suspend fun getGenre(): GenreResponse
    suspend fun getMovies(): MovieResponse

}