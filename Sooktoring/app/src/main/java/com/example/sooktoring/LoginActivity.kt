package com.example.sooktoring

import android.R.attr.data
import android.content.Intent
import android.os.Bundle
import android.util.Log
import android.widget.Toast
import androidx.activity.result.ActivityResultLauncher
import androidx.activity.result.contract.ActivityResultContracts
import androidx.appcompat.app.AppCompatActivity
import com.example.sooktoring.DTO.LoginDTO
import com.example.sooktoring.JWT.App
import com.example.sooktoring.databinding.ActivityLoginBinding
import com.example.sooktoring.retrofit.RetrofitClient
import com.example.sooktoring.retrofit.RetrofitInterface
import com.example.sooktoring.retrofit.RetrofitManager
import com.example.sooktoring.signup.SignUpActivity
import com.example.sooktoring.utils.API
import com.example.sooktoring.utils.Constants.TAG
import com.google.android.gms.auth.api.signin.GoogleSignIn
import com.google.android.gms.auth.api.signin.GoogleSignInAccount
import com.google.android.gms.auth.api.signin.GoogleSignInClient
import com.google.android.gms.auth.api.signin.GoogleSignInOptions
import com.google.android.gms.common.api.ApiException
import com.google.android.gms.tasks.Task
import retrofit2.Call
import retrofit2.Response


class LoginActivity : AppCompatActivity() {

    private var mBinding: ActivityLoginBinding? = null
    private val binding get() = mBinding!!

    private lateinit var GoogleSignResultLauncher: ActivityResultLauncher<Intent>

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        mBinding = ActivityLoginBinding.inflate(layoutInflater)
        setContentView(binding.root)

        val gso = GoogleSignInOptions.Builder(GoogleSignInOptions.DEFAULT_SIGN_IN)
            .requestIdToken("1086906219784-oter9rrh7k6bhffeihdpk6l1id1u26c8.apps.googleusercontent.com")
            .requestEmail()
            .build()

        val mGoogleSignInClient = GoogleSignIn.getClient(this, gso)

        GoogleSignResultLauncher = registerForActivityResult(
            ActivityResultContracts.StartActivityForResult()){ result ->
            val task: Task<GoogleSignInAccount> = GoogleSignIn.getSignedInAccountFromIntent(result.data)
            handleSignInResult(task)
        }

        binding.btnLogin.setOnClickListener {
            var signIntent: Intent = mGoogleSignInClient.getSignInIntent()
            GoogleSignResultLauncher.launch(signIntent)
        }

    }


    private fun handleSignInResult(completedTask: Task<GoogleSignInAccount>) {
        try {
            val account : GoogleSignInAccount = completedTask.getResult(ApiException::class.java)

            if (account != null) {
                try {
//                    val email = account?.email.toString()
                    val googletoken = account?.idToken.toString()

                    postJWTtoken(googletoken)
                    val authCode = account.serverAuthCode.toString()


                    // 로그인 성공시 메인으으로 이동
                    if(googletoken != null) {
                        startActivity(Intent(this, MainActivity::class.java))
                    }

//                    Log.e("Google account 성공", email)
                    Log.e("Google account 성공", googletoken)

                } catch (e: ApiException) {
                    Log.w(TAG, "Google login: Sign-in failed", e)

                    if(e.statusCode == 12500) {
                        Toast.makeText(this, "숙명 계정으로 로그인 해 주세요", Toast.LENGTH_SHORT).show()
                    }
                }
            }
        } catch (e: ApiException) {

            if(e.statusCode == 12500) {
                Toast.makeText(this, "숙명 계정으로 로그인 해 주세요", Toast.LENGTH_SHORT).show()
            }

            Log.w("Google login: failed", "signInResult:failed code=" + e.statusCode)
        }
    }

    private val iRetrofit : RetrofitInterface? = RetrofitClient.getClient(API.BASE_URL)?.create(RetrofitInterface::class.java)

    fun postJWTtoken(Authorization: String?) {
        val token = Authorization ?: ""
        val call = iRetrofit?.postJWTtoken(idToken = token)

        call?.enqueue(object : retrofit2.Callback<LoginDTO>{
            override fun onResponse(call: Call<LoginDTO>, response: Response<LoginDTO>) {
                var result: LoginDTO? = response.body()
                App.prefs.token = result?.accessToken
                App.prefs.refreshtoken = result?.refreshToken
                Log.d(TAG, "JST token 발급 성공 : ${result.toString()} ")
                Log.d(TAG, "최초 access 성공 : ${App.prefs.token.toString()} ")
                Log.d(TAG, "최초 refresh 성공 : ${App.prefs.refreshtoken.toString()} ")
            }

            override fun onFailure(call: Call<LoginDTO>, t: Throwable) {
                TODO("Not yet implemented")
            }
        })
    }
}