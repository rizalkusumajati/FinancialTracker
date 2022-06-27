package com.riztech.financialtracker.domain.model

import android.os.Parcelable
import kotlinx.parcelize.Parcelize

@Parcelize
data class Movie(
    val id: Int,
    val title: String,
    val rating: Int,
    val poster: String
): Parcelable
