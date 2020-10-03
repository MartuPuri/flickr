package com.masacre.flickr.networking

import android.util.Log
import androidx.lifecycle.MutableLiveData
import com.masacre.flickr.model.Photo
import com.masacre.flickr.model.PhotoResponse
import retrofit2.Call
import retrofit2.Callback
import retrofit2.Response

open class PhotoRepository(private val flickerApi : FlickerApi) {

    fun searchPhotos(text: String) : MutableLiveData<List<Photo>> {
        val photosData = MutableLiveData<List<Photo>>()
        flickerApi.searchPhotos(text).enqueue(object: Callback<PhotoResponse> {
            override fun onFailure(call: Call<PhotoResponse>, t: Throwable) {
                Log.d("mpurita", "failure: $t")
                photosData.value = null
            }

            override fun onResponse(
                call: Call<PhotoResponse>,
                response: Response<PhotoResponse>
            ) {
                if (response.isSuccessful) {
                    Log.d("mpurita", "body: ${response.body()}")
                    val photosResponse = response.body() as PhotoResponse
                    photosData.value = photosResponse.photos?.photo
                }
            }

        })
        return photosData
    }
}