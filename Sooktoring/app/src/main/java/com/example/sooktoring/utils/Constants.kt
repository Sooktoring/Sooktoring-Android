package com.example.sooktoring.utils

object Constants {
    const val TAG : String = "로그"
}

enum class RESPONSE_STATE {
    OKAY,
    FAILURE
}

object API {
    const val BASE_URL : String = "http://ec2-3-39-103-187.ap-northeast-2.compute.amazonaws.com:8080"

    const val CLIENT_ID : String = "1086906219784-9g370j6mls2pst9ifu07dlk0vrk76cp9.apps.googleusercontent.com"

    const val TEST : String = "/auth/login"
    const val POST_GOOGLE_LOGIN : String = "/auth/google"
    const val GET_JWT_TOKEN : String = "/auth/login"
    const val GET_REFRESH_TOKEN : String = "/auth/refresh"
    const val GET_USERINFO : String = "/user/me"
}