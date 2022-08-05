package com.example.sooktoring.login

class LoginRepository {
    suspend fun fetchSlothAuthInfo(
        accessToken: String,
        socialType: String
    ): LoginState<LoginSlothResponse> {
        ServiceGenerator.setBuilderOptions(
            targetUrl = BuildConfig.SLOTH_BASE_URL,
            authToken = accessToken
        )
            .create(LoginService::class.java)
            .fetchSlothAuthInfo(
                LoginSlothRequest(
                    socialType = socialType
                )
            )?.run {
                return LoginState.Success(
                    this.body() ?: LoginSlothResponse()
                )

            } ?: return LoginState.Error(Exception("Login Exception"))
    }

    suspend fun fetchGoogleAuthInfo(authCode: String): LoginState<LoginGoogleResponse> {
        ServiceGenerator.setBuilderOptions(
            targetUrl = BuildConfig.GOOGLE_BASE_URL
        )
            .create(LoginService::class.java)
            .fetchGoogleAuthInfo(
                LoginGoogleRequest(
                    grant_type = "authorization_code",
                    client_id = BuildConfig.GOOGLE_CLIENT_ID,
                    client_secret = BuildConfig.GOOGLE_CLIENT_SECRET,
                    redirect_uri = "",
                    code = authCode
                )
            )?.run {
                return LoginState.Success(
                    this.body() ?: LoginGoogleResponse()
                )
            } ?: return LoginState.Error(Exception("Retrofit Exception"))
    }
}