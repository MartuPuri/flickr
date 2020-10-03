package com.masacre.flickr.model

import com.fasterxml.jackson.annotation.JsonIgnoreProperties
import com.fasterxml.jackson.annotation.JsonProperty

@JsonIgnoreProperties(ignoreUnknown = true)
data class Photo(
    var id : String? = null,
    var farm : Int? = null,
    @JsonProperty("height_s")
    var heightS : String? = null,
    @JsonProperty("isfamily")
    var isFamily : Int? = null,
    @JsonProperty("isfriend")
    var isFriend : Int? = null,
    @JsonProperty("ispublic")
    var isPublic : Int? = null,
    var owner : String? = null,
    var secret : String? = null,
    var server : String? = null,
    var title : String? = null,
    @JsonProperty("url_s")
    var url : String? = null,
    @JsonProperty("width_s")
    var widthS : String? = null
)