package com.example.sooktoring.DTO

import com.google.gson.annotations.SerializedName

data class LoginDTO(
    @SerializedName("accessToken") var appToken : String? = null,
    @SerializedName("isNewUser") var isNewUser : Boolean?,
    @SerializedName("refreshToken") var refreshToken : String? = null,
)
