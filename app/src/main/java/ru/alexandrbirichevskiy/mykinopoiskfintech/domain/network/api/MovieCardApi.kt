package ru.alexandrbirichevskiy.mykinopoiskfintech.domain.network.api

import retrofit2.Response
import retrofit2.http.GET
import retrofit2.http.Path
import ru.alexandrbirichevskiy.mykinopoiskfintech.domain.responses.MovieCardResponse

interface MovieCardApi {

    @GET("/api/v2.2/films/{id}")
    suspend fun getMovieCard(
        @Path("id") movieId: Long
    ): Response<MovieCardResponse>
}