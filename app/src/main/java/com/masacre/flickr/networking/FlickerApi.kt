package com.masacre.flickr.networking

import com.masacre.flickr.model.PhotoResponse
import retrofit2.Call
import retrofit2.http.GET
import retrofit2.http.Query


interface FlickerApi {
    @GET
    fun searchPhotos(
        @Query("method") method : String,
        @Query("text") text : String,
        @Query("extras") extras : String) : Call<PhotoResponse>

}