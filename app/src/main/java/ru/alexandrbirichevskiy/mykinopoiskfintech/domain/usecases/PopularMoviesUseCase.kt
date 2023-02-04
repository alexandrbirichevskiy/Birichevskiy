package ru.alexandrbirichevskiy.mykinopoiskfintech.domain.usecases

import ru.alexandrbirichevskiy.mykinopoiskfintech.data.repository.PopularMoviesRepository

interface PopularMoviesUseCase {
}

class PopularMoviesUseCaseImpl(
    private val popularMoviesRepository: PopularMoviesRepository
) : PopularMoviesUseCase {

}