package com.riztech.financialtracker.presentation.detail.mock

import com.airbnb.mvrx.Success
import com.riztech.financialtracker.domain.model.MovieDetail
import com.riztech.financialtracker.presentation.detail.DetailState
import com.riztech.financialtracker.presentation.home.mock.basePoster

val mockDetailState = DetailState(
    Success(
        MovieDetail(
            id = 453395,
            title = "Doctor Strange in the Multiverse of Madness",
            overview = "Doctor Strange, with the help of mystical allies both old and new, traverses the mind-bending and dangerous alternate realities of the Multiverse to confront a mysterious new adversary.",
            poster = basePoster + "/9Gtg2DzBhmYamXBS1hKAhiwbBKS.jpg",
            ranking = (7.546 - 5).toInt()
        )
    )
)