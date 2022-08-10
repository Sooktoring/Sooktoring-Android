package com.example.sooktoring.home

import android.content.Context
import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.example.sooktoring.R
import com.example.sooktoring.databinding.FragmentMentoringBinding
import com.example.sooktoring.recyclerview.mentor.MentorData
import com.example.sooktoring.recyclerview.mentor.MentorRecyclerViewAdapter

class FragmentMentoring : Fragment() {
    companion object {
        fun newInstance() : FragmentMentoring = FragmentMentoring()
    }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
    }

    override fun onAttach(context: Context) {
        super.onAttach(context)
    }

    //뷰 바인딩 사용
    private var mBinding: FragmentMentoringBinding? = null
    private val binding get() = mBinding!!

    //Recyclerview 사용
    private lateinit var adapter: MentorRecyclerViewAdapter //adapter 객체 선언
    private var linearLayoutManager: RecyclerView.LayoutManager? = null
    val mDatas=mutableListOf<MentorData>()

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        mBinding = FragmentMentoringBinding.inflate(inflater, container, false)

        //Recyclerview Adapter 연동
        initializelist()
        initMentorRecyclerView()

        return binding.root
    }

    private fun initMentorRecyclerView() {
        val adapter= MentorRecyclerViewAdapter() //어댑터 객체 만듦
        adapter.mentordatalist = mDatas //데이터 넣어줌
        binding.rvMentorList.adapter=adapter //리사이클러뷰에 어댑터 연결
        binding.rvMentorList.layoutManager = LinearLayoutManager(activity, RecyclerView.HORIZONTAL, false)
    }

    private fun initializelist() {
        with(mDatas) {
            add(MentorData(mentorImg = "", mentorName = "조유림", mentorJob = "UX디자이너", mentorYear = 3, mentorUniv = "공과대학", mentorMajor = "소프트웨어학부"))
            add(MentorData(mentorImg = "", mentorName = "조유림", mentorJob = "UX디자이너", mentorYear = 3, mentorUniv = "공과대학", mentorMajor = "소프트웨어학부"))
            add(MentorData(mentorImg = "", mentorName = "조유림", mentorJob = "UX디자이너", mentorYear = 3, mentorUniv = "공과대학", mentorMajor = "소프트웨어학부"))
            add(MentorData(mentorImg = "", mentorName = "조유림", mentorJob = "UX디자이너", mentorYear = 3, mentorUniv = "공과대학", mentorMajor = "소프트웨어학부"))
            add(MentorData(mentorImg = "", mentorName = "조유림", mentorJob = "UX디자이너", mentorYear = 3, mentorUniv = "공과대학", mentorMajor = "소프트웨어학부"))
        }
    }

}