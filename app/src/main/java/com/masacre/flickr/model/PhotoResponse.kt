package com.masacre.flickr.model

import com.fasterxml.jackson.annotation.JsonIgnoreProperties
import com.fasterxml.jackson.annotation.JsonProperty

@JsonIgnoreProperties(ignoreUnknown = true)
data class PhotoResponse(
    var photos: PhotoResponseBody? = null

)

@JsonIgnoreProperties(ignoreUnknown = true)
data class PhotoResponseBody(
    var page : Int? = null,
    var pages : Int? = null,
    var perpage : Int? = null,
    var total : String? = null,
    var photo : List<Photo>? = null
)