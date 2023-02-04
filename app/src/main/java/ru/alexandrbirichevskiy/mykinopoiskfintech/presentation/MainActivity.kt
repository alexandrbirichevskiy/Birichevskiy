package ru.alexandrbirichevskiy.mykinopoiskfintech.presentation

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import androidx.activity.compose.setContent
import dagger.hilt.android.AndroidEntryPoint
import ru.alexandrbirichevskiy.mykinopoiskfintech.R
import ru.alexandrbirichevskiy.mykinopoiskfintech.presentation.navigation.Navigation

@AndroidEntryPoint
class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        setContent {
            Navigation()
        }
    }
}