package com.masacre.flickr.viewmodel

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import com.masacre.flickr.model.Photo
import com.masacre.flickr.networking.PhotoRepository


open class PhotoListViewModel(private val photoRepository: PhotoRepository) : ViewModel() {
    private var mutableLiveData: MutableLiveData<List<Photo>>? = null

    fun init() {
        if (mutableLiveData != null) {
            return
        }
        //TODO: retrieve mutable live data
    }

    fun getPhotoListLiveData(): LiveData<List<Photo>>? {
        return mutableLiveData
    }
}