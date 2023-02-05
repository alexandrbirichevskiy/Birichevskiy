package ru.alexandrbirichevskiy.mykinopoiskfintech.presentation.popular

import androidx.compose.runtime.MutableState
import androidx.compose.runtime.mutableStateOf
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.launch
import ru.alexandrbirichevskiy.mykinopoiskfintech.data.models.MovieModel
import ru.alexandrbirichevskiy.mykinopoiskfintech.domain.usecases.PopularMoviesUseCase
import ru.alexandrbirichevskiy.mykinopoiskfintech.extensions.asState
import javax.inject.Inject

@HiltViewModel
class PopularMoviesViewModel @Inject constructor(
    private val popularMoviesUseCase: PopularMoviesUseCase
) : ViewModel() {

    init {
        getPopularMovies()
    }

    private val _moviesList = mutableStateOf<List<MovieModel>?>(null)
    val moviesList = _moviesList.asState()

    fun getPopularMovies() {
        viewModelScope.launch {
            val result = popularMoviesUseCase.getPopularMovies()
            _moviesList.value = result.movies
        }
    }
}
