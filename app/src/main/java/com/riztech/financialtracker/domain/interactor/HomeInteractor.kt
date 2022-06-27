package com.riztech.financialtracker.domain.interactor

import com.riztech.financialtracker.domain.model.Genre
import com.riztech.financialtracker.domain.model.Movie
import com.riztech.financialtracker.domain.model.MovieDetail

interface HomeInteractor {
    suspend fun getGenre(): List<Genre>
    suspend fun getMovies(): List<Movie>

}