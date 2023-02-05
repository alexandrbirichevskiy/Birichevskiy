package ru.alexandrbirichevskiy.mykinopoiskfintech.presentation.popular

import android.util.Log
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import androidx.paging.PagingData
import androidx.paging.cachedIn
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.flow.Flow
import ru.alexandrbirichevskiy.mykinopoiskfintech.data.models.MovieModel
import ru.alexandrbirichevskiy.mykinopoiskfintech.domain.usecases.PopularMoviesUseCase
import javax.inject.Inject

@HiltViewModel
class PopularMoviesViewModel @Inject constructor(
    private val popularMoviesUseCase: PopularMoviesUseCase
) : ViewModel() {


    fun getPopularMovies(): Flow<PagingData<MovieModel>> {
        val a = popularMoviesUseCase.getPopularMovies().cachedIn(viewModelScope)
        Log.e("OLOLO", a.toString())
        return a
    }
}
