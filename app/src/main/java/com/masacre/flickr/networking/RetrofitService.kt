package com.masacre.flickr.networking

import okhttp3.OkHttpClient
import okhttp3.logging.HttpLoggingInterceptor
import retrofit2.Converter
import retrofit2.Retrofit
import retrofit2.converter.jackson.JacksonConverterFactory

class RetrofitService {
    private val retrofit = Retrofit.Builder()
            .baseUrl("https://api.flickr.com/v2/")
            .addConverterFactory(generateJacksonConverterFactory())
        .client(generateOkHttpClient())
            .build()

    fun <S> createService(serviceClass: Class<S>?): S {
        return retrofit.create(serviceClass)
    }

    private fun generateJacksonConverterFactory() : Converter.Factory {
        return JacksonConverterFactory.create()
    }


    private fun generateOkHttpClient() : OkHttpClient {
        val loggingInterceptor = HttpLoggingInterceptor()
        loggingInterceptor.level = HttpLoggingInterceptor.Level.BASIC
        return OkHttpClient.Builder().addInterceptor(loggingInterceptor).build()
    }
}