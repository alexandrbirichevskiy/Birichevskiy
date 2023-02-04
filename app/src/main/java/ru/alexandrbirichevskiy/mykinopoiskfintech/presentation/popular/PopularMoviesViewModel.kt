package ru.alexandrbirichevskiy.mykinopoiskfintech.presentation.popular

import androidx.lifecycle.ViewModel
import dagger.hilt.android.lifecycle.HiltViewModel
import ru.alexandrbirichevskiy.mykinopoiskfintech.domain.usecases.PopularMoviesUseCase
import javax.inject.Inject

@HiltViewModel
class PopularMoviesViewModel @Inject constructor(
    private val popularMoviesUseCase: PopularMoviesUseCase
) : ViewModel() {

}
