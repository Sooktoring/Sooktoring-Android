package com.example.sooktoring.initProfile

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import com.example.sooktoring.databinding.ActivityUnivInfoBinding

class UnivInfoActivity : AppCompatActivity() {

    private var mBinding: ActivityUnivInfoBinding? = null
    private val binding get() = mBinding!!

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        mBinding = ActivityUnivInfoBinding.inflate(layoutInflater)
        setContentView(binding.root)

        // 초기 미입력시 보이는 에러 메세지 invisible
        binding.tvErrorName.visibility = View.GONE
        binding.tvErrorUnivStatus.visibility = View.GONE

    }
}