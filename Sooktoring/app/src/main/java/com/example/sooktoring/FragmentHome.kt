package com.example.sooktoring

import android.content.Context
import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.viewpager2.widget.ViewPager2
import com.example.sooktoring.home.FragmentHomeAdapter
import com.google.android.material.tabs.TabLayout
import com.google.android.material.tabs.TabLayoutMediator

class FragmentHome : Fragment() {

    private lateinit var tabLayout: TabLayout
    private lateinit var viewPager: ViewPager2

    companion object {
        fun newInstance() : FragmentHome = FragmentHome()
    }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
    }

    override fun onAttach(context: Context) {
        super.onAttach(context)
    }

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        var view: View = inflater.inflate(R.layout.fragment_home, container, false)

        tabLayout = view.findViewById(R.id.layout_tabLayout)
        viewPager = view.findViewById(R.id.layout_viewPager)

        val adapter = FragmentHomeAdapter(this)
        viewPager.adapter = adapter

        val tabName = listOf<String>("멘토링", "동아리", "공모전")

        //슬라이드로 이동했을 때, 탭이 같이 변경되도록
        TabLayoutMediator(tabLayout, viewPager) { tab, position ->
            tab.text = tabName[position].toString()
        }.attach()

        //탭이 선택되었을 때, 뷰페이저가 같이 변경되도록
        tabLayout.addOnTabSelectedListener(object : TabLayout.OnTabSelectedListener {
            override fun onTabSelected(tab: TabLayout.Tab?) {
                viewPager.currentItem = tab!!.position
            }

            override fun onTabUnselected(tab: TabLayout.Tab?) {

            }

            override fun onTabReselected(tab: TabLayout.Tab?) {

            }

        })

        return view
    }
}