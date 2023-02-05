package ru.alexandrbirichevskiy.mykinopoiskfintech.presentation.moviecard

import android.util.Log
import androidx.compose.runtime.collectAsState
import androidx.compose.runtime.mutableStateOf
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import androidx.lifecycle.viewmodel.compose.viewModel
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.collectLatest
import kotlinx.coroutines.flow.flow
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
