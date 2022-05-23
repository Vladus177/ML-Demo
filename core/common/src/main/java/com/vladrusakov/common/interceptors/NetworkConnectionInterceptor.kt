package com.vladrusakov.common.interceptors

import android.content.Context
import okhttp3.Interceptor

import android.net.ConnectivityManager
import com.vladrusakov.common.exceptions.NoConnectionException
import okhttp3.Request
import okhttp3.Response


class NetworkConnectionInterceptor constructor(private val context: Context) : Interceptor {

    @Throws(Exception::class)
    override fun intercept(chain: Interceptor.Chain): Response {
        if (!isConnected()) {
            throw NoConnectionException()
        }
        val builder: Request.Builder = chain.request().newBuilder()
        return chain.proceed(builder.build())
    }

    fun isConnected(): Boolean {
        val connectivityManager =
            context.getSystemService(Context.CONNECTIVITY_SERVICE) as ConnectivityManager
        val netInfo = connectivityManager.activeNetworkInfo
        return netInfo != null && netInfo.isConnected
    }
}