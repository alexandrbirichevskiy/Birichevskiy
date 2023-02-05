package ru.alexandrbirichevskiy.mykinopoiskfintech.di

import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.components.SingletonComponent
import retrofit2.Retrofit
import ru.alexandrbirichevskiy.mykinopoiskfintech.data.repository.PopularMoviesRepository
import ru.alexandrbirichevskiy.mykinopoiskfintech.data.repository.PopularMoviesRepositoryImpl
import ru.alexandrbirichevskiy.mykinopoiskfintech.domain.network.api.MoviesApi
import ru.alexandrbirichevskiy.mykinopoiskfintech.domain.usecases.MoviesUseCase
import ru.alexandrbirichevskiy.mykinopoiskfintech.domain.usecases.MoviesUseCaseImpl
import javax.inject.Singleton

@Module
@InstallIn(SingletonComponent::class)
class MoviesModule {

    @Provides
    @Singleton
    fun provideMoviesApi(
        retrofit: Retrofit
    ): MoviesApi = retrofit.create(MoviesApi::class.java)

    @Provides
    @Singleton
    fun provideMoviesRepository(
        moviesApi: MoviesApi
    ): PopularMoviesRepository = PopularMoviesRepositoryImpl(moviesApi)

    @Provides
    @Singleton
    fun provideMoviesUseCase(
        popularMoviesRepository: PopularMoviesRepository
    ): MoviesUseCase = MoviesUseCaseImpl(popularMoviesRepository)
}