package com.example.sooktoring.DTO

import com.google.gson.annotations.SerializedName

data class UserDTO(
    @SerializedName("createdDate") var createdDate : String? = null,
    @SerializedName("lastModifiedDate") var lastModifiedDate : Boolean?,
    @SerializedName("id") var id : String? = null,
    @SerializedName("email") var email : String? = null,
    @SerializedName("name") var name : String? = null,
    @SerializedName("imageUrl") var imageUrl : String? = null,
    @SerializedName("role") var role : String? = null,
    @SerializedName("provider") var provider : String? = null,
    @SerializedName("providerId") var providerId : String? = null,
)
