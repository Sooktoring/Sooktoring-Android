package com.example.sooktoring.retrofit

import com.example.sooktoring.DTO.LoginDTO
import com.example.sooktoring.utils.API.POST_GOOGLE_LOGIN
import com.example.sooktoring.utils.API.TEST
import com.example.sooktoring.utils.API.USER_CERTIFICATION
import com.google.android.gms.auth.api.credentials.IdToken
import com.google.gson.JsonElement
import retrofit2.Call
import retrofit2.http.Body
import retrofit2.http.POST

interface RetrofitInterface {

    @POST(POST_GOOGLE_LOGIN)
    fun googleLogin()

    @POST(TEST)
    fun serverTest(@Body accessToken: String) : Call<JsonElement>

    @POST(USER_CERTIFICATION)
    fun userCertificate(@Body idToken: String) : Call<LoginDTO>

}