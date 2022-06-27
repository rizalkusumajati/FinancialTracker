package com.riztech.financialtracker.domain.interactor

import com.riztech.financialtracker.data.remote.response.toDomain
import com.riztech.financialtracker.domain.model.MovieDetail
import com.riztech.financialtracker.domain.repository.DetailRepository

class DetailInteractorImpl(
    val detailRepository: DetailRepository
): DetailInteractor {
    override suspend fun getMovieDetail(movieId: Int): MovieDetail {
        return detailRepository.getMovieDetail(movieId).toDomain()
    }
}