package ru.alexandrbirichevskiy.mykinopoiskfintech.domain.network

import retrofit2.Response
import retrofit2.http.GET
import retrofit2.http.Headers
import ru.alexandrbirichevskiy.mykinopoiskfintech.domain.responses.PopularMoviesResponse

interface PopularMoviesApi {

    @GET("/api/v2.2/films/top?type=TOP_100_POPULAR_FILMS&page=1")
    suspend fun getPopularMovies(): Response<PopularMoviesResponse>
}