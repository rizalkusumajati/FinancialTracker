package com.riztech.financialtracker.presentation.home.mock

import com.airbnb.mvrx.Success
import com.riztech.financialtracker.domain.model.Genre
import com.riztech.financialtracker.domain.model.Movie
import com.riztech.financialtracker.presentation.home.HomeState

val mockHomeState by lazy {
    HomeState(
        categories = Success(
            listOf(
                Genre(
                    id = 28,
                    name = "Action"
                ),
                Genre(
                    id = 12,
                    name = "Adventure"
                ),
                Genre(
                    id = 16,
                    name = "Animation"
                ),
                Genre(
                    id = 35,
                    name = "Comedy"
                ),
                Genre(
                    id = 80,
                    name = "Crime"
                ),
                Genre(
                    id = 99,
                    name = "Documentary"
                ),
            )
        ),
        movies = Success(
            listOf(
                Movie(
                    id = 338953,
                    title = "Fantastic Beasts: The Secrets of Dumbledore",
                    rating = (6.8 - 5).toInt(),
                    poster = basePoster + "/jrgifaYeUtTnaH7NF5Drkgjg2MB.jpg"
                ),
                Movie(
                    id = 338953,
                    title = "Fantastic Beasts: The Secrets of Dumbledore",
                    rating = (6.8 - 5).toInt(),
                    poster = basePoster + "/jrgifaYeUtTnaH7NF5Drkgjg2MB.jpg"
                ),
                Movie(
                    id = 338953,
                    title = "Fantastic Beasts: The Secrets of Dumbledore",
                    rating = (6.8 - 5).toInt(),
                    poster = basePoster + "/jrgifaYeUtTnaH7NF5Drkgjg2MB.jpg"
                ),
                Movie(
                    id = 338953,
                    title = "Fantastic Beasts: The Secrets of Dumbledore",
                    rating = (6.8 - 5).toInt(),
                    poster = basePoster + "/jrgifaYeUtTnaH7NF5Drkgjg2MB.jpg"
                ),
                Movie(
                    id = 338953,
                    title = "Fantastic Beasts: The Secrets of Dumbledore",
                    rating = (6.8 - 5).toInt(),
                    poster = basePoster + "/jrgifaYeUtTnaH7NF5Drkgjg2MB.jpg"
                ),
                Movie(
                    id = 338953,
                    title = "Fantastic Beasts: The Secrets of Dumbledore",
                    rating = (6.8 - 5).toInt(),
                    poster = basePoster + "/jrgifaYeUtTnaH7NF5Drkgjg2MB.jpg"
                )
            )
        )
    )
}

val basePoster = "https://image.tmdb.org/t/p/w500"