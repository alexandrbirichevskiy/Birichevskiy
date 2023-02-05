package ru.alexandrbirichevskiy.mykinopoiskfintech.extensions

fun String?.orDefault(default: String = "Неизвестно"): String {
    return if (!this.isNullOrEmpty()) {
        this
    } else {
        default
    }
}