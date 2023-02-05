package ru.alexandrbirichevskiy.mykinopoiskfintech.presentation

import androidx.compose.foundation.border
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.material.ButtonDefaults
import androidx.compose.material.Text
import androidx.compose.material3.Button
import androidx.compose.material3.Icon
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.res.colorResource
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import ru.alexandrbirichevskiy.mykinopoiskfintech.R

@Composable
fun NetworkError(onButtonClick: () -> Unit, code: Int?) {
    Box(modifier = Modifier.fillMaxSize(), contentAlignment = Alignment.Center) {
        Column(
            horizontalAlignment = Alignment.CenterHorizontally,
            modifier = Modifier
                .fillMaxWidth()
                .padding(horizontal = 40.dp)
        ) {
            Icon(
                painter = painterResource(id = R.drawable.not_connected_error),
                contentDescription = null,
                tint = colorResource(id = R.color.blue)
            )
            Spacer(modifier = Modifier.height(13.dp))
            Text(
                text = when (code) {
                    null -> "Произошла ошибка при загрузке данных, проверьте подключение к сети"
                    200 -> "Сервер прилал пустое значение"
                    in 400..500 -> "Ошибка сервера"
                    else -> "Что-то пошло не так"
                },
                color = colorResource(id = R.color.blue),
                fontSize = 14.sp,
                fontWeight = FontWeight(400),
                maxLines = 2
            )
            Spacer(modifier = Modifier.height(36.dp))
            Button(
                onClick = { onButtonClick },
                colors = androidx.compose.material3.ButtonDefaults.buttonColors(
                    containerColor = colorResource(
                        id = R.color.blue
                    )
                ),
                modifier = Modifier
                    .fillMaxWidth(0.5f)
                    .height(45.dp)
            ) {
                Text(
                    text = "Повторить",
                    color = Color.White,
                    fontSize = 14.sp,
                    fontWeight = FontWeight(400)
                )
            }
        }
    }
}