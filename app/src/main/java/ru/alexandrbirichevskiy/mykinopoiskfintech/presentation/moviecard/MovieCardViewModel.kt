package ru.alexandrbirichevskiy.mykinopoiskfintech.presentation.moviecard

import androidx.compose.runtime.mutableStateOf
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.launch
import ru.alexandrbirichevskiy.mykinopoiskfintech.data.models.MovieCardModel
import ru.alexandrbirichevskiy.mykinopoiskfintech.domain.usecases.MovieCardUseCase
import ru.alexandrbirichevskiy.mykinopoiskfintech.extensions.asState
import javax.inject.Inject

@HiltViewModel
class MovieCardViewModel @Inject constructor(
    private val movieCardUseCase: MovieCardUseCase
) : ViewModel() {


    private val _movie = mutableStateOf<MovieCardModel?>(null)
    val movie = _movie.asState()

    fun getMovie(moveId: Long) {
        viewModelScope.launch {
            val result = movieCardUseCase.getMovieCard(moveId)
            _movie.value = result
        }
    }
}
