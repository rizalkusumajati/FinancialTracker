package com.riztech.financialtracker.data.remote.response

data class Genre(
    val id: Int,
    val name: String
)

fun Genre.toDomain() = com.riztech.financialtracker.domain.model.Genre(
    id = id,
    name = name
)