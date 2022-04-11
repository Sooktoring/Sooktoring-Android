package com.example.sooktoring.signup

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import com.example.sooktoring.R
import com.example.sooktoring.databinding.ActivitySignUpDoneBinding
import com.example.sooktoring.databinding.ActivitySignUpVerifyEmailBinding

class SignUpVerifyEmailActivity : AppCompatActivity() {
    private var mBinding: ActivitySignUpVerifyEmailBinding? = null
    private val binding get() = mBinding!!

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        mBinding = ActivitySignUpVerifyEmailBinding.inflate(layoutInflater)
        setContentView(binding.root)

        binding.btnJoin.setOnClickListener {
            startActivity(Intent(this, SignUpDoneActivity::class.java))
        }

    }
}