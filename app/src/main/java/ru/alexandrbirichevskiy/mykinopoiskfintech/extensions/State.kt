package ru.alexandrbirichevskiy.mykinopoiskfintech.extensions

import androidx.compose.runtime.MutableState
import androidx.compose.runtime.State
import androidx.compose.runtime.derivedStateOf
import androidx.compose.runtime.snapshots.SnapshotStateList

fun <T> MutableState<T>.asState(): State<T> {
    return this
}

fun <T> SnapshotStateList<T>.asState(): State<List<T>> {
    return derivedStateOf { this.map { it } }
}