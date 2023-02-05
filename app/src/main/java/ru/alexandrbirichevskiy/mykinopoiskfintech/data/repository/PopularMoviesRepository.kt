package ru.alexandrbirichevskiy.mykinopoiskfintech.data.repository

import androidx.paging.Pager
import androidx.paging.PagingConfig
import androidx.paging.PagingData
import androidx.paging.map
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.map
import ru.alexandrbirichevskiy.mykinopoiskfintech.data.models.MovieModel
import ru.alexandrbirichevskiy.mykinopoiskfintech.data.models.PopularMoviesModel
import ru.alexandrbirichevskiy.mykinopoiskfintech.domain.network.PopularMoviesApi
import ru.alexandrbirichevskiy.mykinopoiskfintech.domain.network.PopularMoviesPagingSource
import ru.alexandrbirichevskiy.mykinopoiskfintech.domain.responses.FilmResponse
import ru.alexandrbirichevskiy.mykinopoiskfintech.extensions.toModelMapper


interface PopularMoviesRepository {
    fun getPopularMovies(): Flow<PagingData<MovieModel>>
}

class PopularMoviesRepositoryImpl(
    private val api: PopularMoviesApi
) : PopularMoviesRepository {

    override fun getPopularMovies(): Flow<PagingData<MovieModel>> {
        return Pager(
            config = PagingConfig(
                pageSize = 20
            ),
            pagingSourceFactory = {
                PopularMoviesPagingSource(api = api)
            }
        ).flow.map {
            it.map { data ->
                data.toModelMapper()
            }
        }
    }
}
