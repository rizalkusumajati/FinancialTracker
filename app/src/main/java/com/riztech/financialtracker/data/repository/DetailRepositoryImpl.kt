package com.riztech.financialtracker.data.repository

import com.riztech.financialtracker.data.remote.ApiClient
import com.riztech.financialtracker.data.remote.response.MovieDetailResponse
import com.riztech.financialtracker.domain.repository.DetailRepository

class DetailRepositoryImpl(val apiClient: ApiClient) : DetailRepository {

    override suspend fun getMovieDetail(movieId: Int): MovieDetailResponse {
        return apiClient.getMovieDetail(movieId)
    }
}