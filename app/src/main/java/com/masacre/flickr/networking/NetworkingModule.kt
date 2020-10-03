package com.masacre.flickr.networking

import dagger.Module
import dagger.Provides
import javax.inject.Singleton

@Module
class NetworkingModule {
    @Provides
    @Singleton
    fun reftrofitService() = RetrofitService()

    @Provides
    @Singleton
    fun photoRepository(retrofitService: RetrofitService) = PhotoRepository(retrofitService.createService(FlickerApi::class.java))
}