package com.example.sooktoring.login

import retrofit2.Response
import retrofit2.http.Body
import retrofit2.http.POST

interface LoginService {
    @POST("api/oauth/login")
    suspend fun fetchSlothAuthInfo(@Body request: LoginSlothRequest): Response<LoginSlothResponse>?
    /*백엔드 서버로 accessToken을 보냄*/

    @POST("oauth2/v4/token")
    suspend fun fetchGoogleAuthInfo(@Body request: LoginGoogleRequest): Response<LoginGoogleResponse>?
    /*구글 서버에 IdToken을 보냄*/
}