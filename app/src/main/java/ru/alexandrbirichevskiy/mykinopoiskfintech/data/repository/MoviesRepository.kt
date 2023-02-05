package ru.alexandrbirichevskiy.mykinopoiskfintech.data.repository

import androidx.paging.Pager
import androidx.paging.PagingConfig
import androidx.paging.PagingData
import androidx.paging.map
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.map
import ru.alexandrbirichevskiy.mykinopoiskfintech.data.models.MovieModel
import ru.alexandrbirichevskiy.mykinopoiskfintech.domain.network.ConnectionState
import ru.alexandrbirichevskiy.mykinopoiskfintech.domain.network.api.MoviesApi
import ru.alexandrbirichevskiy.mykinopoiskfintech.domain.network.PopularMoviesPagingSource
import ru.alexandrbirichevskiy.mykinopoiskfintech.extensions.toMovieModel
import java.util.logging.ErrorManager


interface PopularMoviesRepository {
    fun getPopularMovies(): Flow<PagingData<MovieModel>>?
}

class PopularMoviesRepositoryImpl(
    private val api: MoviesApi,
    private val connectionState: ConnectionState
) : PopularMoviesRepository {

    override fun getPopularMovies(): Flow<PagingData<MovieModel>>? {
        if (connectionState.connectionState.value) {
            return Pager(
                config = PagingConfig(
                    pageSize = 20
                ),
                pagingSourceFactory = {
                    PopularMoviesPagingSource(api = api)
                }
            ).flow.map {
                it.map { data ->
                    data.toMovieModel()
                }
            }
        } else {
            return null
        }
    }
}
