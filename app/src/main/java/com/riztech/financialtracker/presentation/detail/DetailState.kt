package com.riztech.financialtracker.presentation.detail

import com.airbnb.mvrx.Async
import com.airbnb.mvrx.MavericksState
import com.airbnb.mvrx.Uninitialized
import com.riztech.financialtracker.domain.model.MovieDetail

data class DetailState(
    val movie: Async<MovieDetail> = Uninitialized,
): MavericksState
