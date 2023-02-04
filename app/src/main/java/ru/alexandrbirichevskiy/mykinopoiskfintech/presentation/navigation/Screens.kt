package ru.alexandrbirichevskiy.mykinopoiskfintech.presentation.navigation

sealed class Screens(val route: String) {
    object PopularMovies : Screens("popular")
}
