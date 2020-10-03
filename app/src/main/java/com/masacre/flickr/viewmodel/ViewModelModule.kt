package com.masacre.flickr.viewmodel

import com.masacre.flickr.networking.PhotoRepository
import dagger.Module
import dagger.Provides

@Module
class ViewModelModule {
    @Provides
    fun photoListViewModel(photoRepository: PhotoRepository)
            = PhotoListViewModel(photoRepository)
}