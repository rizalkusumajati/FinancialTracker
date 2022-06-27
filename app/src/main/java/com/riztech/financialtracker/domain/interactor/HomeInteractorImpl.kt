package com.riztech.financialtracker.domain.interactor

import com.riztech.financialtracker.data.remote.response.toDomain
import com.riztech.financialtracker.domain.model.Genre
import com.riztech.financialtracker.domain.model.Movie
import com.riztech.financialtracker.domain.model.MovieDetail
import com.riztech.financialtracker.domain.repository.HomeRepository

class HomeInteractorImpl constructor(
    val homeRepository: HomeRepository
): HomeInteractor {
    override suspend fun getGenre(): List<Genre> {
        return homeRepository.getGenre().toDomain()
    }

    override suspend fun getMovies(): List<Movie> {
        return homeRepository.getMovies().toDomain()
    }


}