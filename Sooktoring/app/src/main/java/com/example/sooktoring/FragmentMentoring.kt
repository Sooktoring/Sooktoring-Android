package com.example.sooktoring

import android.content.Intent
import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.recyclerview.widget.LinearLayoutManager
import com.example.sooktoring.databinding.FragmentMentoringBinding
import kotlinx.android.synthetic.main.fragment_mentoring.*

class FragmentMentoring : Fragment() {
    //뷰 바인딩 사용
    private var mBinding: FragmentMentoringBinding? = null
    private val binding get() = mBinding!!

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        mBinding = FragmentMentoringBinding.inflate(inflater, container, false)

        binding.buttonMentorSearch.setOnClickListener {
            val intent = Intent(activity, SearchActivity::class.java)
            startActivity(intent)
        }

        return binding.root
    }

}