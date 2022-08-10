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


class MainActivity : AppCompatActivity(), BottomNavigationView.OnNavigationItemSelectedListener {

    //멤버변수
    private lateinit var homeFragment: FragmentHome
    private lateinit var chatFragment: FragmentChat
    private lateinit var myFragment: FragmentMy


    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        bottom_navigation.setOnNavigationItemSelectedListener(this)

        bottom_navigation.selectedItemId = R.id.menu_home
        homeFragment = FragmentHome.newInstance()
        supportFragmentManager.beginTransaction().add(R.id.frame_fragments, homeFragment).commit()
    }

    override fun onNavigationItemSelected(item: MenuItem): Boolean {
        when(item.itemId){
            R.id.menu_home ->{
                homeFragment = FragmentHome.newInstance()
                supportFragmentManager.beginTransaction().replace(R.id.frame_fragments, homeFragment).commit()
            }
            R.id.menu_chat -> {
                chatFragment = FragmentChat.newInstance()
                supportFragmentManager.beginTransaction().replace(R.id.frame_fragments, chatFragment).commit()
            }
            R.id.menu_my -> {
                myFragment = FragmentMy.newInstance()
                supportFragmentManager.beginTransaction().replace(R.id.frame_fragments, myFragment).commit()
            }
        }
        return true
    }


}