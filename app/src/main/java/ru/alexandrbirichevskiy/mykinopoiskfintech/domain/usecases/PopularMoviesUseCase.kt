package ru.alexandrbirichevskiy.mykinopoiskfintech.domain.usecases

import ru.alexandrbirichevskiy.mykinopoiskfintech.data.models.PopularMoviesModel
import ru.alexandrbirichevskiy.mykinopoiskfintech.data.repository.PopularMoviesRepository

interface PopularMoviesUseCase {
    suspend fun getPopularMovies(): PopularMoviesModel
}

class PopularMoviesUseCaseImpl(
    private val popularMoviesRepository: PopularMoviesRepository
) : PopularMoviesUseCase {
    override suspend fun getPopularMovies(): PopularMoviesModel {
        return popularMoviesRepository.getPopularMovies()
    }
}