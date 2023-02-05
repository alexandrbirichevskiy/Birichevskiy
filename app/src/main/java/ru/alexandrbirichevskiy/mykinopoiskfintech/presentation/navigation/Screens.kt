package ru.alexandrbirichevskiy.mykinopoiskfintech.presentation.navigation

sealed class Screens(val route: String) {
    object PopularMovies : Screens("popular")
    object MovieCard : Screens("movie_card")

    fun withArgs(vararg args: String): String {
        return buildString {
            append(route)
            args.forEach {
                append("/$it")
            }
        }
    }
}
