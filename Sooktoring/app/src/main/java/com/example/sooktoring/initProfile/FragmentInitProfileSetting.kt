package com.example.sooktoring.initProfile

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import com.example.sooktoring.FragmentHome
import com.example.sooktoring.R
import com.example.sooktoring.databinding.FragmentInitProfileSettingBinding

class FragmentInitProfileSetting : Fragment() {

    //뷰 바인딩 사용
    private var mBinding: FragmentInitProfileSettingBinding? = null
    private val binding get() = mBinding!!

    companion object {
        fun newInstance() : FragmentInitProfileSetting = FragmentInitProfileSetting()
    }

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        mBinding = FragmentInitProfileSettingBinding.inflate(inflater, container, false)

        return binding.root
    }
}