package com.masacre.flickr.networking

import com.masacre.flickr.model.PhotoResponse
import retrofit2.Call
import retrofit2.http.GET
import retrofit2.http.Query


interface FlickerApi {
    @GET("?method=flickr.photos.search&extras=url_s")
    fun searchPhotos(
        @Query("text") text : String) : Call<PhotoResponse>

}