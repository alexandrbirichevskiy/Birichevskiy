package ru.alexandrbirichevskiy.mykinopoiskfintech.domain.usecases

import ru.alexandrbirichevskiy.mykinopoiskfintech.data.models.MovieCardModel
import ru.alexandrbirichevskiy.mykinopoiskfintech.data.repository.MovieCardRepository

interface MovieCardUseCase {
    suspend fun getMovieCard(movieId: Long): MovieCardModel
}

class MovieCardUseCaseImpl(
    private val movieCardRepository: MovieCardRepository
) : MovieCardUseCase {

    override suspend fun getMovieCard(movieId: Long): MovieCardModel {
        return movieCardRepository.getMovieCard(movieId)
    }
}