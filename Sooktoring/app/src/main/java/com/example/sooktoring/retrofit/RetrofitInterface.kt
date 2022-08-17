package com.example.sooktoring.retrofit

import com.example.sooktoring.DTO.LoginDTO
import com.example.sooktoring.DTO.TokenDTO
import com.example.sooktoring.DTO.UserDTO
import com.example.sooktoring.utils.API.GET_JWT_TOKEN
import com.example.sooktoring.utils.API.GET_REFRESH_TOKEN
import com.example.sooktoring.utils.API.GET_USERINFO
import com.example.sooktoring.utils.API.POST_GOOGLE_LOGIN
import com.example.sooktoring.utils.API.TEST
import com.google.android.gms.auth.api.credentials.IdToken
import com.google.gson.JsonElement
import retrofit2.Call
import retrofit2.http.*

interface RetrofitInterface {

    @POST(POST_GOOGLE_LOGIN)
    fun googleLogin()

    @POST(TEST)
    fun serverTest(@Body accessToken: String) : Call<JsonElement>

    @POST(GET_JWT_TOKEN)
    fun postJWTtoken(@Body idToken: String) : Call<LoginDTO>

    @POST(GET_REFRESH_TOKEN)
    fun getRefreshToken(@Body existToken: TokenDTO) : Call<TokenDTO>

    @GET(GET_USERINFO)
    fun getUserInfo(@Header("Authorization") Authorization: String) : Call<UserDTO>

}