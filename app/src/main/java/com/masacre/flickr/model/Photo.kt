package com.masacre.flickr.model

import com.fasterxml.jackson.annotation.JsonIgnoreProperties
import com.fasterxml.jackson.annotation.JsonProperty

@JsonIgnoreProperties(ignoreUnknown = true)
data class Photo(
    var id : String? = null,
    var owner : String? = null,
    var secret : String? = null,
    var server : String? = null,
    var farm : Int? = null,
    var title : String? = null,
    @field:JsonProperty("isfamily")
    var isFamily : Int? = null,
    @field:JsonProperty("isfriend")
    var isFriend : Int? = null,
    @field:JsonProperty("ispublic")
    var isPublic : Int? = null,
    @field:JsonProperty("url_s")
    var url : String? = null,
    @field:JsonProperty("height_s")
    var heightS : Int? = null,
    @field:JsonProperty("width_s")
    var widthS : Int? = null
)