package com.riztech.financialtracker.data.repository

import com.riztech.financialtracker.data.remote.ApiClient
import com.riztech.financialtracker.data.remote.response.GenreResponse
import com.riztech.financialtracker.data.remote.response.MovieDetailResponse
import com.riztech.financialtracker.data.remote.response.MovieResponse
import com.riztech.financialtracker.domain.repository.HomeRepository

class HomeRepositoryImpl(
    val apiClient: ApiClient
): HomeRepository {
    override suspend fun getGenre(): GenreResponse {
        return apiClient.getGenre()
    }

    override suspend fun getMovies(): MovieResponse {
        return apiClient.getMovies()
    }

}