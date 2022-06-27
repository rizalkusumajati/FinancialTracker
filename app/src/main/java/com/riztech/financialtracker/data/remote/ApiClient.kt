package com.riztech.financialtracker.data.remote

import com.riztech.financialtracker.data.remote.response.GenreResponse
import com.riztech.financialtracker.data.remote.response.MovieDetailResponse
import com.riztech.financialtracker.data.remote.response.MovieResponse
import retrofit2.Response
import retrofit2.http.GET
import retrofit2.http.Path
import retrofit2.http.Query

interface ApiClient {
    @GET("genre/movie/list")
    suspend fun getGenre(
        @Query("api_key") apiKey: String = "1557853c72890ec559e5ce537b9adb24",
        @Query("language") lang: String = "en-US"
    ): GenreResponse

    @GET("discover/movie")
    suspend fun getMovies(
        @Query("api_key") apiKey: String = "1557853c72890ec559e5ce537b9adb24",
        @Query("language") lang: String = "en-US",
        @Query("sort_by") sort: String = "popularity.desc",
        @Query("include_adult") adult: Boolean = false,
        @Query("include_video") video: Boolean = false,
        @Query("page") page: Int = 1
    ): MovieResponse

    @GET("movie/{movie_id}")
    suspend fun getMovieDetail(
        @Path("movie_id") movieId: Int,
        @Query("api_key") apiKey: String = "1557853c72890ec559e5ce537b9adb24",
        @Query("language") lang: String = "en-US",
    ): MovieDetailResponse
}