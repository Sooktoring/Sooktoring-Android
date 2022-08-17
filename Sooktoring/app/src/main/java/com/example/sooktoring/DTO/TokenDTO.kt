package com.example.sooktoring.DTO

import com.google.gson.annotations.SerializedName

data class TokenDTO(
    @SerializedName("accessToken") var accessToken : String?,
    @SerializedName("refreshToken") var refreshToken : String?,
)
