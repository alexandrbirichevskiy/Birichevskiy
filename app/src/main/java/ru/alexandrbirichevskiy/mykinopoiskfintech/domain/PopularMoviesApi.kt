package ru.alexandrbirichevskiy.mykinopoiskfintech.domain

import retrofit2.Response
import retrofit2.http.GET
import retrofit2.http.Headers
import ru.alexandrbirichevskiy.mykinopoiskfintech.domain.responses.PopularMoviesResponse

interface PopularMoviesApi {

    @Headers("X-API-KEY:e30ffed0-76ab-4dd6-b41f-4c9da2b2735b")
    @GET("/api/v2.2/films/top?type=TOP_100_POPULAR_FILMS&page=1")
    suspend fun getPopularMovies(): Response<PopularMoviesResponse>
}