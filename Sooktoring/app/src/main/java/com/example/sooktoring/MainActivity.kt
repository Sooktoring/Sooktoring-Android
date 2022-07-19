package com.example.sooktoring

import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import androidx.fragment.app.FragmentActivity
import com.google.android.material.tabs.TabLayoutMediator
import androidx.recyclerview.widget.LinearLayoutManager
import com.example.sooktoring.FragmentAdapter
import com.example.sooktoring.FragmentContest
import com.example.sooktoring.FragmentGroup
import com.example.sooktoring.FragmentMentoring
import com.example.sooktoring.databinding.ActivityMainBinding
import kotlinx.android.synthetic.main.activity_main.*
import kotlinx.android.synthetic.main.fragment_mentoring.*


class MainActivity : FragmentActivity() {

    val binding by lazy { ActivityMainBinding.inflate(layoutInflater)}

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(binding.root)

        val strings = listOf("멘토링","동아리","공모전")

        val fragmentList = listOf(FragmentMentoring(), FragmentGroup(), FragmentContest())
        var adapter = FragmentAdapter(this)
        adapter.fragmentList = fragmentList
        binding.viewPager.adapter = adapter

        val tabTitles = listOf<String>("멘토링", "동아리", "공모전")

        TabLayoutMediator(binding.tabLayout, binding.viewPager) { tab, position ->
            tab.text = tabTitles[position]
        }.attach()

    }
}
