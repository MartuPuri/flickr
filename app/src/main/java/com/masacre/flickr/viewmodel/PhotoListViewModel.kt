package com.masacre.flickr.viewmodel

import android.util.Log
import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.Transformations
import androidx.lifecycle.ViewModel
import com.masacre.flickr.model.Photo
import com.masacre.flickr.networking.PhotoRepository


open class PhotoListViewModel(private val photoRepository: PhotoRepository) : ViewModel() {
    private var photosLiveData: LiveData<List<Photo>>? = null
    private var filterTextQuery = MutableLiveData<String>()

    fun init() {
        if (photosLiveData != null) {
            return
        }
        photosLiveData = Transformations.switchMap(filterTextQuery) { input: String ->
            photoRepository.searchPhotos(input)
        }
    }

    fun getPhotoListLiveData(): LiveData<List<Photo>>? {
        return photosLiveData
    }

    fun search(text: String?) {
        Log.d("mpurita", "search new text $text")
        filterTextQuery.value = text
    }
}