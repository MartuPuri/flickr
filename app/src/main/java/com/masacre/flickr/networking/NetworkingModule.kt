package com.masacre.flickr.networking

import android.content.Context
import dagger.Module
import dagger.Provides
import javax.inject.Singleton

@Module
class NetworkingModule {
    @Provides
    @Singleton
    fun reftrofitService(context: Context) = RetrofitService(context)

    @Provides
    @Singleton
    fun photoRepository(retrofitService: RetrofitService) = PhotoRepository(retrofitService.createService(FlickerApi::class.java))
}