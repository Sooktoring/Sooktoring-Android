package com.example.sooktoring.retrofit

import android.util.Log
import com.example.sooktoring.DTO.LoginDTO
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

}