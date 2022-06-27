package com.riztech.financialtracker.presentation.home

import com.airbnb.mvrx.Async
import com.airbnb.mvrx.MavericksState
import com.airbnb.mvrx.Uninitialized
import com.riztech.financialtracker.domain.model.Genre
import com.riztech.financialtracker.domain.model.Movie

data class HomeState(
    val categories: Async<List<Genre>> = Uninitialized,
    val movies: Async<List<Movie>> = Uninitialized
): MavericksState
