package com.example.sooktoring.DTO

import com.google.gson.annotations.SerializedName

data class LoginDTO(
    @SerializedName("accessToken") var accessToken : String?,
    @SerializedName("isNewUser") var isNewUser : Boolean?,
    @SerializedName("refreshToken") var refreshToken : String?,
)
