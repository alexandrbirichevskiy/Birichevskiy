package ru.alexandrbirichevskiy.mykinopoiskfintech.presentation.navigation

import androidx.compose.foundation.background
import androidx.compose.runtime.Composable
import androidx.compose.ui.graphics.Color
import androidx.navigation.NavHostController
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import androidx.navigation.compose.rememberNavController
import androidx.compose.ui.Modifier
import androidx.navigation.NavType
import androidx.navigation.navArgument
import ru.alexandrbirichevskiy.mykinopoiskfintech.presentation.moviecard.MovieCard
import ru.alexandrbirichevskiy.mykinopoiskfintech.presentation.movieslist.Movies

@Composable
fun Navigation(
    navController: NavHostController = rememberNavController()
) {
    NavHost(
        navController = navController,
        startDestination = Screens.PopularMovies.route,
        modifier = Modifier.background(Color.White)
    ) {
        composable(route = Screens.PopularMovies.route) {
            Movies(controller = navController)
        }
        composable(
            route = Screens.MovieCard.route + "/{movieId}",
            arguments = listOf(
                navArgument(name = "movieId") {
                    type = NavType.LongType
                }
            )
        ) {
            MovieCard(moveId = it.arguments!!.getLong("movieId"), controller = navController)
        }
    }
}
