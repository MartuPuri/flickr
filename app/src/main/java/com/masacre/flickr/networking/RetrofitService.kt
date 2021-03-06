package com.masacre.flickr.networking

import android.content.Context
import android.net.ConnectivityManager
import okhttp3.*
import okhttp3.CacheControl
import okhttp3.logging.HttpLoggingInterceptor
import retrofit2.Converter
import retrofit2.Retrofit
import retrofit2.converter.jackson.JacksonConverterFactory
import java.io.File


class RetrofitService(private val context: Context) {

    private val retrofit = Retrofit.Builder()
            .baseUrl(BASE_URL)
            .addConverterFactory(generateJacksonConverterFactory())
        .client(generateOkHttpClient())
            .build()

    fun <S> createService(serviceClass: Class<S>?): S {
        return retrofit.create(serviceClass)
    }

    private fun generateJacksonConverterFactory() : Converter.Factory {
        return JacksonConverterFactory.create()
    }

    private fun provideCache(): Cache? {
        var cache: Cache? = null
        try {
            cache = Cache(
                File(context.cacheDir, "http-cache"),
                10 * 1024 * 1024
            ) // 10 MB
        } catch (e: Exception) {
        }
        return cache
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
        httpClient.cache(provideCache())
        httpClient.addInterceptor(provideOfflineCacheInterceptor())
        return httpClient.addInterceptor(loggingInterceptor).build()
    }

    private fun provideOfflineCacheInterceptor(): Interceptor {
        return object : Interceptor {
            override fun intercept(chain: Interceptor.Chain): Response {
                var request = chain.request()
                if (!isConnected()) {
                    val cacheControl = CacheControl.Builder()
                        .maxStale(7, java.util.concurrent.TimeUnit.DAYS)
                        .build()
                    request = request.newBuilder()
                        .removeHeader(HEADER_PRAGMA)
                        .removeHeader(HEADER_CACHE_CONTROL)
                        .cacheControl(cacheControl)
                        .build()
                }
                return chain.proceed(request)
            }
        }
    }

    private fun isConnected(): Boolean {
        try {
            val e = context.getSystemService(
                Context.CONNECTIVITY_SERVICE
            ) as ConnectivityManager
            val activeNetwork = e.activeNetworkInfo

            return activeNetwork != null && activeNetwork.isConnectedOrConnecting
        } catch (e: java.lang.Exception) {
        }
        return false
    }

    companion object {
        private const val HEADER_CACHE_CONTROL = "Cache-Control"
        private const val HEADER_PRAGMA = "Pragma"
        private const val BASE_URL = "https://api.flickr.com/services/rest/"

    }
}