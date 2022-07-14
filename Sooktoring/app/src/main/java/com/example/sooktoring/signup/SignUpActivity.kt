package com.example.sooktoring.signup

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import com.example.sooktoring.R
import com.example.sooktoring.databinding.ActivityLoginBinding
import com.example.sooktoring.databinding.ActivitySignUpBinding

class SignUpActivity : AppCompatActivity() {

    private var mBinding: ActivitySignUpBinding? = null
    private val binding get() = mBinding!!

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        mBinding = ActivitySignUpBinding.inflate(layoutInflater)
        setContentView(binding.root)

        binding.btnJoin.setOnClickListener {
            startActivity(Intent(this, SignUpVerifyEmailActivity::class.java))
        }

    }
}