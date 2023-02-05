package ru.alexandrbirichevskiy.mykinopoiskfintech.domain.network

import okhttp3.Interceptor
import okhttp3.Response

class TokenInterceptor() : Interceptor {
    override fun intercept(chain: Interceptor.Chain): Response {
        var request = chain.request()
        val headers = request.headers.newBuilder()
            .add("X-API-KEY:e30ffed0-76ab-4dd6-b41f-4c9da2b2735b")
            .build()
        request = request.newBuilder().headers(headers).build()
        return chain.proceed(request)
    }
}