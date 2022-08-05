package com.example.sooktoring

import android.R.attr.data
import android.content.Intent
import android.os.Bundle
import android.util.Log
import androidx.appcompat.app.AppCompatActivity
import com.example.sooktoring.databinding.ActivityLoginBinding
import com.example.sooktoring.retrofit.RetrofitManager
import com.example.sooktoring.signup.SignUpActivity
import com.example.sooktoring.utils.Constants.TAG
import com.google.android.gms.auth.api.signin.GoogleSignIn
import com.google.android.gms.auth.api.signin.GoogleSignInAccount
import com.google.android.gms.auth.api.signin.GoogleSignInClient
import com.google.android.gms.auth.api.signin.GoogleSignInOptions
import com.google.android.gms.common.api.ApiException
import com.google.android.gms.tasks.Task


class LoginActivity : AppCompatActivity() {

    final val RC_SIGN_IN = 1

    private var mBinding: ActivityLoginBinding? = null
    private val binding get() = mBinding!!

    lateinit var googleSignInClient : GoogleSignInClient
    val signInIntent = googleSignInClient!!.signInIntent

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        mBinding = ActivityLoginBinding.inflate(layoutInflater)
        setContentView(binding.root)

        binding.btnLogin.setOnClickListener {
            startActivity(Intent(this, MainActivity::class.java))
        }

        val gso = GoogleSignInOptions.Builder(GoogleSignInOptions.DEFAULT_SIGN_IN)

        val mGoogleSignInClient = GoogleSignIn.getClient(this,gso)

    }
    private fun googleLogin() {
//        startActivityForResult(signInIntent, RC_SIGN_IN)
    }

    override fun onActivityResult(requestCode: Int, resultCode: Int, data: Intent?) {
        super.onActivityResult(requestCode, resultCode, data)

        if (requestCode == RC_SIGN_IN) {
            val task =
                GoogleSignIn.getSignedInAccountFromIntent(data)
            handleSignInResult(task)
        }
    }

    private fun handleSignInResult(completedTask: Task<GoogleSignInAccount>) {
        try {
            val account : GoogleSignInAccount = completedTask.getResult(ApiException::class.java)
}