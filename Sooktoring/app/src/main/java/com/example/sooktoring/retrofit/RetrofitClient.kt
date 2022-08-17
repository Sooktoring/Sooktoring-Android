package com.example.sooktoring.retrofit

import com.example.sooktoring.JWT.App
import com.example.sooktoring.JWT.AuthInterceptor
import okhttp3.Interceptor
import okhttp3.OkHttpClient
import okhttp3.Response
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory
import java.io.IOException

object RetrofitClient {

    // retrofit client 선언
    private var retrofitClient: Retrofit? = null
    private var retrofitUserClient: Retrofit? = null
    val okHttpClient = OkHttpClient.Builder().addInterceptor(AuthInterceptor()).build()


    // retrofit client 가져오기
    fun getClient(baseUrl: String): Retrofit? {

        // 만약 레트로핏 클라이이언트가 없으면
        if(retrofitClient == null){
            // 인스턴스 생성
            retrofitClient = Retrofit.Builder()
                .client(okHttpClient)
                .baseUrl(baseUrl)
                .addConverterFactory(GsonConverterFactory.create())
                .build()
        }

        return retrofitClient
    }

    fun getUserClient(baseUrl: String): Retrofit? {

        // 만약 레트로핏 클라이이언트가 없으면
        if(retrofitUserClient == null){
            // 인스턴스 생성
            retrofitUserClient = Retrofit.Builder()
                .client(provideOkHttpClient(AppInterceptor()))
                .baseUrl(baseUrl)
                .addConverterFactory(GsonConverterFactory.create())
                .build()
        }

        return retrofitUserClient
    }

    private fun provideOkHttpClient(interceptor: AppInterceptor): OkHttpClient
            = OkHttpClient.Builder().run {
        addInterceptor(interceptor)
        build()
    }

    class AppInterceptor : Interceptor {
        @Throws(IOException::class)
        override fun intercept(chain: Interceptor.Chain) : Response = with(chain) {
            val newRequest = request().newBuilder()
                .addHeader("Authorization", "")
                .build()
            proceed(newRequest)
        }
    }

}