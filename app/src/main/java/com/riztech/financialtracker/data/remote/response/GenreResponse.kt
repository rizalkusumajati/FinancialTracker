package com.riztech.financialtracker.data.remote.response

data class GenreResponse(
    val genres: List<Genre>
)

fun GenreResponse.toDomain() = genres.map { it.toDomain() }