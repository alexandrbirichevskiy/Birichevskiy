package ru.alexandrbirichevskiy.mykinopoiskfintech.domain.usecases

import androidx.paging.PagingData
import kotlinx.coroutines.flow.Flow
import ru.alexandrbirichevskiy.mykinopoiskfintech.data.models.MovieModel
import ru.alexandrbirichevskiy.mykinopoiskfintech.data.repository.PopularMoviesRepository

interface MoviesUseCase {
    fun getPopularMovies(): Flow<PagingData<MovieModel>>
}

class MoviesUseCaseImpl(
    private val popularMoviesRepository: PopularMoviesRepository
) : MoviesUseCase {
    override fun getPopularMovies(): Flow<PagingData<MovieModel>> {
        return popularMoviesRepository.getPopularMovies()
    }
}