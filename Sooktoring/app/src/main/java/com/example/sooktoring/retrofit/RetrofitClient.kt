package com.example.sooktoring.retrofit

import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory

object RetrofitClient {

    // retrofit client 선언
    private var retrofitClient: Retrofit? = null

    // retrofit client 가져오기
    fun getClient(baseUrl: String): Retrofit? {

        // 만약 레트로핏 클라이이언트가 없으면
        if(retrofitClient == null){
            // 인스턴스 생성
            retrofitClient = Retrofit.Builder()
                .baseUrl(baseUrl)
                .addConverterFactory(GsonConverterFactory.create())
                .build()
        }

        return retrofitClient
    }

}