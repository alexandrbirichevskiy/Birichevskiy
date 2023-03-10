package ru.alexandrbirichevskiy.mykinopoiskfintech.domain.network.api

import retrofit2.Response
import retrofit2.http.GET
import retrofit2.http.Query
import ru.alexandrbirichevskiy.mykinopoiskfintech.domain.responses.PopularMoviesResponse

interface MoviesApi {

    @GET("/api/v2.2/films/top")
    suspend fun getPopularMovies(
        @Query("type") type: String = "TOP_100_POPULAR_FILMS",
        @Query("page") page: Int = 1
    ): Response<PopularMoviesResponse>
}