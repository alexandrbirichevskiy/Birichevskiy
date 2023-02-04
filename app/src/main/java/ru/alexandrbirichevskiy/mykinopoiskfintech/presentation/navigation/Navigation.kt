package ru.alexandrbirichevskiy.mykinopoiskfintech.presentation.navigation

import androidx.compose.foundation.background
import androidx.compose.runtime.Composable
import androidx.compose.ui.graphics.Color
import androidx.navigation.NavHostController
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import androidx.navigation.compose.rememberNavController
import androidx.compose.ui.Modifier
import ru.alexandrbirichevskiy.mykinopoiskfintech.presentation.popular.PopularMovies

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
            PopularMovies()
        }
    }
}
