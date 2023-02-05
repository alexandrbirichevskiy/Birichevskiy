package ru.alexandrbirichevskiy.mykinopoiskfintech.presentation.movieslist

import androidx.compose.foundation.background
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.Card
import androidx.compose.material3.CardDefaults
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.DisposableEffect
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.style.TextOverflow
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.hilt.navigation.compose.hiltViewModel
import androidx.navigation.NavHostController
import androidx.paging.compose.LazyPagingItems
import androidx.paging.compose.collectAsLazyPagingItems
import androidx.paging.compose.items
import coil.compose.AsyncImage
import com.google.accompanist.systemuicontroller.rememberSystemUiController
import ru.alexandrbirichevskiy.mykinopoiskfintech.data.models.MovieModel
import ru.alexandrbirichevskiy.mykinopoiskfintech.presentation.navigation.Screens

@Composable
fun Movies(
    viewModel: MoviesViewModel = hiltViewModel(),
    controller: NavHostController
) {
    val systemUiController = rememberSystemUiController()
    DisposableEffect(systemUiController) {
        systemUiController.setSystemBarsColor(
            color = Color.Transparent
        )
        onDispose { }
    }

    val movies = viewModel.getMovies().collectAsLazyPagingItems()

    Box(
        modifier = Modifier
            .fillMaxSize()
            .background(Color.White)
            .padding(horizontal = 16.dp)
    ) {
        MoviesList(movies = movies, controller = controller)
    }
}

@Composable
fun MoviesList(
    movies: LazyPagingItems<MovieModel>,
    controller: NavHostController
) {
    LazyColumn(
        modifier = Modifier
            .fillMaxSize()
    ) {
        items(
            items = movies,
            key = { it.movieId }
        ) { data ->
            if (data != null) {
                MoviesListItem(data, controller)
            }
            Spacer(modifier = Modifier.height(12.dp))

        }
    }
}

@Composable
fun MoviesListItem(movie: MovieModel, controller: NavHostController) {
    Card(
        modifier = Modifier
            .fillMaxWidth()
            .height(100.dp)
            .clickable {
                controller.navigate(Screens.MovieCard.withArgs(movie.movieId.toString()))
            },
        shape = RoundedCornerShape(15.dp),
        colors = CardDefaults.cardColors(containerColor = Color.White),
        elevation = CardDefaults.cardElevation(defaultElevation = 20.dp)
    ) {
        Row(
            modifier = Modifier
                .fillMaxWidth()
                .padding(all = 15.dp)
        ) {
            AsyncImage(
                model = movie.url,
                contentDescription = null
            )
            Spacer(modifier = Modifier.width(15.dp))
            Column(
                modifier = Modifier.fillMaxSize(),
                verticalArrangement = Arrangement.Center
            ) {
                Text(
                    text = movie.name,
                    color = Color.Black,
                    fontSize = 16.sp,
                    fontWeight = FontWeight(500),
                    overflow = TextOverflow.Ellipsis,
                    maxLines = 1
                )
                Spacer(modifier = Modifier.height(5.dp))
                Row {
                    Text(
                        text = movie.genre,
                        color = Color.Black.copy(alpha = 0.6f),
                        fontSize = 14.sp,
                        fontWeight = FontWeight(500),
                        maxLines = 1
                    )
                    Text(
                        text = " (${movie.year})",
                        color = Color.Black.copy(alpha = 0.6f),
                        fontSize = 14.sp,
                        fontWeight = FontWeight(500),
                        maxLines = 1
                    )
                }
            }
        }
    }
}