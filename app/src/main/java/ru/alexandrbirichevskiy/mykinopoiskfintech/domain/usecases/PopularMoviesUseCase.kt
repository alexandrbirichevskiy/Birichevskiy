package ru.alexandrbirichevskiy.mykinopoiskfintech.domain.usecases

import androidx.paging.PagingData
import kotlinx.coroutines.flow.Flow
import ru.alexandrbirichevskiy.mykinopoiskfintech.data.models.MovieModel
import ru.alexandrbirichevskiy.mykinopoiskfintech.data.models.PopularMoviesModel
import ru.alexandrbirichevskiy.mykinopoiskfintech.data.repository.PopularMoviesRepository

interface PopularMoviesUseCase {
    fun getPopularMovies(): Flow<PagingData<MovieModel>>
}

class PopularMoviesUseCaseImpl(
    private val popularMoviesRepository: PopularMoviesRepository
) : PopularMoviesUseCase {
    override fun getPopularMovies(): Flow<PagingData<MovieModel>> {
        return popularMoviesRepository.getPopularMovies()
    }
}