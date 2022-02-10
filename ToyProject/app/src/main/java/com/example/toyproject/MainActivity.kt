package com.example.toyproject

import MyAdapter
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.FrameLayout
import androidx.fragment.app.Fragment
import androidx.recyclerview.widget.LinearLayoutManager
import com.example.toyproject.fragment.AccountFrag
import com.example.toyproject.fragment.GameFrag
import com.example.toyproject.fragment.HomeFrag
import com.example.toyproject.fragment.TestFrag
import com.google.android.material.bottomnavigation.BottomNavigationView
import kotlinx.android.synthetic.main.activity_main.*

class MainActivity : AppCompatActivity() {
    private val fl: FrameLayout by lazy {
        findViewById(R.id.main_frame)
    }
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        val bnv_main = findViewById<BottomNavigationView>(R.id.bottom_navi)
        var recyclerView = recyclerview_main

        var layoutManager = LinearLayoutManager(this)
        recyclerView.layoutManager = layoutManager
        var adapter = MyAdapter()
        recyclerView.adapter = adapter


        bnv_main.setOnItemSelectedListener { item ->
            changeFragment(
                when (item.itemId) {
                    R.id.home_navi -> {
//                        bnv_main.itemIconTintList = ContextCompat.getColorStateList(this, R.color.gray)
//                        bnv_main.itemTextColor = ContextCompat.getColorStateList(this, R.color.gray)
                        HomeFrag()
                        // Respond to navigation item 1 click
                    }
                    R.id.game_navi -> {
//                        bnv_main.itemIconTintList = ContextCompat.getColorStateList(this, R.color.gray)
//                        bnv_main.itemTextColor = ContextCompat.getColorStateList(this, R.color.gray)
                        GameFrag()
                        // Respond to navigation item 2 click
                    }
                    R.id.test_navi -> {
//                        bnv_main.itemIconTintList = ContextCompat.getColorStateList(this, R.color.gray)
//                        bnv_main.itemTextColor = ContextCompat.getColorStateList(this, R.color.gray)
                        TestFrag()
                        // Respond to navigation item 3 click
                    }
                    else -> {
//                        bnv_main.itemIconTintList = ContextCompat.getColorStateList(this, R.color.gray)
//                        bnv_main.itemTextColor = ContextCompat.getColorStateList(this, R.color.gray)
                        AccountFrag()
                    }
                }
            )
            true
        }
        bnv_main.selectedItemId = R.id.home_navi
    }

    private fun changeFragment(fragment: Fragment) {
        supportFragmentManager
            .beginTransaction()
            .replace(R.id.main_frame, fragment)
            .commit()
    }
}