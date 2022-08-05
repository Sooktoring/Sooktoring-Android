package com.example.sooktoring.login

class LoginViewModel : BaseViewModel() {
    private val loginRepository = LoginRepository()

    suspend fun fetchSlothAuthInfo(
        accessToken: String,
        socialType: String,
        context: CoroutineContext = Dispatchers.IO,
        start: CoroutineStart = CoroutineStart.DEFAULT,
    ): LoginState<LoginSlothResponse> = viewModelScope.async(
        context = context,
        start = start
    ) {
        loginRepository.fetchSlothAuthInfo(
            accessToken = accessToken,
            socialType = socialType
        )
    }.await()

    suspend fun fetchGoogleAuthInfo(
        authCode: String,
        context: CoroutineContext = Dispatchers.IO,
        start: CoroutineStart = CoroutineStart.DEFAULT,
    ): LoginState<LoginGoogleResponse> = viewModelScope.async(
        context = context,
        start = start
    ) {
        loginRepository.fetchGoogleAuthInfo(
            authCode = authCode
        )
    }.await()

    suspend fun saveAuthToken(pm: PreferenceManager, accessToken: String, refreshToken: String) =
        viewModelScope.launch {
            withContext(Dispatchers.IO) {
                pm.putAuthToken(accessToken, refreshToken)
            }
        }
}