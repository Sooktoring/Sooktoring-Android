package com.example.sooktoring.signup

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import androidx.annotation.MainThread
import com.example.sooktoring.MainActivity
import com.example.sooktoring.databinding.ActivityLoginBinding
import com.example.sooktoring.databinding.ActivitySignUpBinding
import com.example.sooktoring.databinding.ActivitySignUpDoneBinding

class SignUpDoneActivity : AppCompatActivity() {

    private var mBinding: ActivitySignUpDoneBinding? = null
    private val binding get() = mBinding!!

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        mBinding = ActivitySignUpDoneBinding.inflate(layoutInflater)
        setContentView(binding.root)

        binding.btnGotoLogin.setOnClickListener {
            startActivity(Intent(this, MainActivity::class.java))
        }

    }
}