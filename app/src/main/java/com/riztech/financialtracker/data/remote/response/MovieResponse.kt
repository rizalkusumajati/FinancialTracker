package com.riztech.financialtracker.data.remote.response

data class MovieResponse(
    val page: Int,
    val results: List<Result>,
    val total_pages: Int,
    val total_results: Int
)

fun MovieResponse.toDomain() = results.map { it.toDomain() }