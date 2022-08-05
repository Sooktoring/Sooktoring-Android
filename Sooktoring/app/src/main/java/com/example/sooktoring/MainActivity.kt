package com.example.sooktoring

import android.os.Bundle
import android.view.MenuItem
import androidx.appcompat.app.AppCompatActivity
import androidx.fragment.app.FragmentActivity
import com.google.android.material.tabs.TabLayoutMediator
import androidx.recyclerview.widget.LinearLayoutManager
import com.example.sooktoring.FragmentAdapter
import com.example.sooktoring.FragmentContest
import com.example.sooktoring.FragmentGroup
import com.example.sooktoring.FragmentMentoring
import com.example.sooktoring.databinding.ActivityMainBinding
import com.google.android.material.bottomnavigation.BottomNavigationView
import kotlinx.android.synthetic.main.activity_main.*
import kotlinx.android.synthetic.main.fragment_mentoring.*


class MainActivity : FragmentActivity(), BottomNavigationView.OnNavigationItemSelectedListener {

    val binding by lazy { ActivityMainBinding.inflate(layoutInflater)}
    var bundle = Bundle()

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(binding.root)

        //batoomnavigation bar fragment 이동
        binding.bottomNavigation.setOnNavigationItemSelectedListener(this)
        //set default screen
        binding.bottomNavigation.selectedItemId = R.id.homeFragment

        //tab layout
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

    override fun onNavigationItemSelected(item: MenuItem): Boolean {
        when(item.itemId){
            R.id.homeFragment->{
                var homeViewFragment = FragmentHome()
                homeViewFragment.arguments = bundle
                supportFragmentManager.beginTransaction().replace(R.id.main_container, homeViewFragment).commit()
                return true
            }
            R.id.chatFragment->{
                var chatViewFragment = FragmentChat()
                chatViewFragment.arguments = bundle
                supportFragmentManager.beginTransaction().replace(R.id.main_container, chatViewFragment).commit()
                return true
            }
            R.id.myPageFragment->{
                var mypageViewFragment = FragmentMy()
                mypageViewFragment.arguments = bundle
                supportFragmentManager.beginTransaction().replace(R.id.main_container, mypageViewFragment).commit()
            }
        }
        return false
    }
}
