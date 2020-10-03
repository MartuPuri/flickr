package com.masacre.flickr.networking

import okhttp3.*
import okhttp3.logging.HttpLoggingInterceptor
import retrofit2.Converter
import retrofit2.Retrofit
import retrofit2.converter.jackson.JacksonConverterFactory


class RetrofitService {
    private val retrofit = Retrofit.Builder()
            .baseUrl("https://api.flickr.com/services/rest/")
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
        val httpClient = OkHttpClient.Builder()
        httpClient.addInterceptor(object : Interceptor {
            override fun intercept(chain: Interceptor.Chain): Response {
                val original: Request = chain.request()
                val originalHttpUrl: HttpUrl = original.url
                val url = originalHttpUrl.newBuilder()
                    .addQueryParameter("api_key", "675894853ae8ec6c242fa4c077bcf4a0")
                    .addQueryParameter("format", "json")
                    .addQueryParameter("nojsoncallback", "1 ")
                    .build()

                // Request customization: add request headers
                val requestBuilder: Request.Builder = original.newBuilder()
                    .url(url)
                val request: Request = requestBuilder.build()
                return chain.proceed(request)
            }

        })
        return httpClient.addInterceptor(loggingInterceptor).build()
    }
}