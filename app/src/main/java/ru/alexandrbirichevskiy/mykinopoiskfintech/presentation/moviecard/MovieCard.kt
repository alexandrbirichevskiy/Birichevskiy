package ru.alexandrbirichevskiy.mykinopoiskfintech.presentation.moviecard

import androidx.activity.compose.BackHandler
import androidx.compose.animation.VectorConverter
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.rememberScrollState
import androidx.compose.foundation.verticalScroll
import androidx.compose.material3.Icon
import androidx.compose.material3.IconButton
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.LaunchedEffect
import androidx.compose.ui.Alignment
import androidx.compose.ui.ExperimentalComposeUiApi
import androidx.compose.ui.Modifier
import androidx.compose.ui.focus.FocusRequester.Companion.createRefs
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.res.colorResource
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.constraintlayout.compose.ConstraintLayout
import androidx.hilt.navigation.compose.hiltViewModel
import androidx.navigation.NavHostController
import coil.compose.AsyncImage
import com.google.accompanist.systemuicontroller.rememberSystemUiController
import ru.alexandrbirichevskiy.mykinopoiskfintech.R
import ru.alexandrbirichevskiy.mykinopoiskfintech.presentation.NetworkError
import ru.alexandrbirichevskiy.mykinopoiskfintech.presentation.navigation.Screens

@Composable
fun MovieCard(
    moveId: Long,
    viewModel: MovieCardViewModel = hiltViewModel(),
    controller: NavHostController
) {
    viewModel.getMovie(moveId)
    val movie = viewModel.movie.value
    val code = viewModel.code.value
    val scrollState = rememberScrollState()

    val systemUiController = rememberSystemUiController()
    LaunchedEffect(key1 = viewModel.movie.value) {
        systemUiController.setSystemBarsColor(
            color = Color.Transparent
        )
    }

    BackHandler {
        controller.navigate(Screens.PopularMovies.route)
    }

    if (movie == null) {
        NetworkError(onButtonClick = { viewModel.getMovie(moveId) }, code = code)
    } else {
        Column(
            modifier = Modifier
                .fillMaxSize()
                .verticalScroll(scrollState)
        ) {
            AsyncImage(
                model = movie?.url,
                contentDescription = null,
                contentScale = ContentScale.FillWidth,
                modifier = Modifier.fillMaxWidth()
            )
            Spacer(modifier = Modifier.height(20.dp))
            Column(
                modifier = Modifier
                    .fillMaxSize()
                    .padding(horizontal = 30.dp),
                verticalArrangement = Arrangement.Center
            ) {
                Box(contentAlignment = Alignment.Center, modifier = Modifier.fillMaxWidth()) {
                    Text(
                        text = movie?.name.orEmpty(),
                        color = Color.Black,
                        fontSize = 20.sp,
                        fontWeight = FontWeight(600)
                    )
                }
                Spacer(modifier = Modifier.height(16.dp))
                Text(
                    text = movie?.description.orEmpty(),
                    color = Color.Black.copy(alpha = 0.6f),
                    fontSize = 14.sp,
                    fontWeight = FontWeight(400)
                )
                Spacer(modifier = Modifier.height(15.dp))
                Row {
                    Text(
                        text = "Жанры: ",
                        color = Color.Black.copy(alpha = 0.6f),
                        fontSize = 14.sp,
                        fontWeight = FontWeight(500)
                    )
                    Text(
                        text = movie?.genres?.joinToString(", ").orEmpty(),
                        color = Color.Black.copy(alpha = 0.6f),
                        fontSize = 14.sp,
                        fontWeight = FontWeight(400)
                    )
                }
                Spacer(modifier = Modifier.height(8.dp))
                Row {
                    Text(
                        text = "Страны: ",
                        color = Color.Black.copy(alpha = 0.6f),
                        fontSize = 14.sp,
                        fontWeight = FontWeight(500)
                    )

                    Text(
                        text = movie?.countries?.joinToString(", ").orEmpty(),
                        color = Color.Black.copy(alpha = 0.6f),
                        fontSize = 14.sp,
                        fontWeight = FontWeight(400)
                    )
                }
                Spacer(modifier = Modifier.height(8.dp))
            }
        }

        ConstraintLayout {
            IconButton(
                onClick = { controller.navigate(Screens.PopularMovies.route) },
                modifier = Modifier
                    .size(24.dp)
                    .constrainAs(createRef()) {
                        top.linkTo(parent.top, margin = 30.dp)
                        start.linkTo(parent.start, margin = 22.dp)
                    }
            ) {
                Icon(
                    painter = painterResource(id = R.drawable.arrow_back),
                    modifier = Modifier.fillMaxSize(),
                    contentDescription = null,
                    tint = colorResource(id = R.color.blue)
                )
            }
        }
    }
}