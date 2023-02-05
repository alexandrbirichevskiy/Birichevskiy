package ru.alexandrbirichevskiy.mykinopoiskfintech.di

import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.components.SingletonComponent
import retrofit2.Retrofit
import ru.alexandrbirichevskiy.mykinopoiskfintech.data.repository.MovieCardRepository
import ru.alexandrbirichevskiy.mykinopoiskfintech.data.repository.MovieCardRepositoryImpl
import ru.alexandrbirichevskiy.mykinopoiskfintech.domain.network.api.MovieCardApi
import ru.alexandrbirichevskiy.mykinopoiskfintech.domain.usecases.MovieCardUseCase
import ru.alexandrbirichevskiy.mykinopoiskfintech.domain.usecases.MovieCardUseCaseImpl
import javax.inject.Singleton

@Module
@InstallIn(SingletonComponent::class)
class MovieCardModule {

    @Provides
    @Singleton
    fun provideMovieCardApi(
        retrofit: Retrofit
    ): MovieCardApi = retrofit.create(MovieCardApi::class.java)

    @Provides
    @Singleton
    fun provideMovieCardRepository(
        movieCardApi: MovieCardApi
    ): MovieCardRepository = MovieCardRepositoryImpl(movieCardApi)

    @Provides
    @Singleton
    fun provideMovieCardUseCase(
        movieCardRepository: MovieCardRepository
    ): MovieCardUseCase = MovieCardUseCaseImpl(movieCardRepository)
}