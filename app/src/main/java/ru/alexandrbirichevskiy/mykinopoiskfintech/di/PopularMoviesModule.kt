package ru.alexandrbirichevskiy.mykinopoiskfintech.di

import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.components.SingletonComponent
import retrofit2.Retrofit
import ru.alexandrbirichevskiy.mykinopoiskfintech.data.repository.PopularMoviesRepository
import ru.alexandrbirichevskiy.mykinopoiskfintech.data.repository.PopularMoviesRepositoryImpl
import ru.alexandrbirichevskiy.mykinopoiskfintech.domain.network.PopularMoviesApi
import ru.alexandrbirichevskiy.mykinopoiskfintech.domain.usecases.PopularMoviesUseCase
import ru.alexandrbirichevskiy.mykinopoiskfintech.domain.usecases.PopularMoviesUseCaseImpl
import javax.inject.Singleton

@Module
@InstallIn(SingletonComponent::class)
class PopularMoviesModule {

    @Provides
    @Singleton
    fun providePopularMoviesApi(
        retrofit: Retrofit
    ): PopularMoviesApi = retrofit.create(PopularMoviesApi::class.java)

    @Provides
    @Singleton
    fun providePopularMoviesRepository(
        popularMoviesApi: PopularMoviesApi
    ): PopularMoviesRepository = PopularMoviesRepositoryImpl(popularMoviesApi)

    @Provides
    @Singleton
    fun providePopularMoviesUseCase(
        popularMoviesRepository: PopularMoviesRepository
    ): PopularMoviesUseCase = PopularMoviesUseCaseImpl(popularMoviesRepository)
}