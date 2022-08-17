package com.example.sooktoring.retrofit

import android.util.Log
import com.example.sooktoring.DTO.TokenDTO
import com.example.sooktoring.DTO.UserDTO
import com.example.sooktoring.JWT.App
import com.example.sooktoring.utils.API
import com.example.sooktoring.utils.Constants.TAG
import com.google.gson.JsonElement
import retrofit2.Call
import retrofit2.Response

class RetrofitManager {

    companion object {
        val instance = RetrofitManager()
    }

    // retrofit interface 가져오기
    private val iRetrofit : RetrofitInterface? = RetrofitClient.getClient(API.BASE_URL)?.create(RetrofitInterface::class.java)
    private val iRetrofit_user : RetrofitInterface? = RetrofitClient.getUserClient(API.BASE_URL)?.create(RetrofitInterface::class.java)

    // http call 만들기
    private val httpCall : RetrofitInterface? = RetrofitClient.getClient(API.BASE_URL)?.create(RetrofitInterface::class.java)

    fun servertest(accessToken: String?) {
        val token = accessToken ?: ""
        val call = iRetrofit?.serverTest(accessToken = token).let {
            it
        }?: return

        call.enqueue(object : retrofit2.Callback<JsonElement>{
            override fun onResponse(call: Call<JsonElement>, response: Response<JsonElement>) {
                Log.d(TAG, "성공했다는 뜻 RetrofitManager - onResponse() called / response : $response ")
            }

            override fun onFailure(call: Call<JsonElement>, t: Throwable) {
                Log.d(TAG, "RetrofitManager - onFailure() called / t: $t")
            }

        })
    }

    fun getUserInfo(idToken: String?) {
        val token = idToken ?: ""
        val call = iRetrofit_user?.getUserInfo(Authorization = token).let {
            it
        }?: return

        call.enqueue(object : retrofit2.Callback<UserDTO>{
            override fun onResponse(call: Call<UserDTO>, response: Response<UserDTO>) {
                var result: UserDTO? = response.body()
                Log.d(TAG, "getUser 성공 - onResponse() called / response : $response ")
                Log.d(TAG, "getUser 성공 - onResponse() called / response : $result ")
                App.prefs.createdDate = result?.createdDate
                App.prefs.lastModifiedDate = result?.lastModifiedDate
                App.prefs.id = result?.id
                App.prefs.email = result?.email
                App.prefs.userName = result?.name
                App.prefs.imageUrl = result?.imageUrl
                App.prefs.role = result?.role
            }

            override fun onFailure(call: Call<UserDTO>, t: Throwable) {
                Log.d(TAG, "RetrofitManager - onFailure() called / t: $t")
            }

        })
    }

    fun  getRefreshToken(existToken: TokenDTO) {
        val call = iRetrofit?.getRefreshToken(existToken).let {
            it
        }?: return

        call.enqueue(object : retrofit2.Callback<TokenDTO>{
            override fun onResponse(call: Call<TokenDTO>, response: Response<TokenDTO>) {
                var result: TokenDTO? = response.body()
                App.prefs.token = result?.accessToken.toString()
                App.prefs.refreshtoken = result?.refreshToken.toString()
                Log.d(TAG, "getRefresh 성공 : $response ")
            }

            override fun onFailure(call: Call<TokenDTO>, t: Throwable) {
                Log.d(TAG, "RetrofitManager - onFailure() called / t: $t")
            }

        })
    }
}