package com.example.prj

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import androidx.fragment.app.Fragment
import androidx.navigation.NavController
import androidx.navigation.fragment.findNavController
import com.example.prj.fragment.AccountFrag
import com.example.prj.fragment.GameFrag
import com.example.prj.fragment.HomeFrag
import com.example.prj.fragment.TestFrag
import com.google.android.material.bottomnavigation.BottomNavigationView
import kotlinx.android.synthetic.main.activity_main.*

class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        val bnv_main = findViewById<BottomNavigationView>(R.id.bottom_navi)
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
        // 시작화면을 game_navi로해놓음 -> 나중에 수정 필요
        bnv_main.selectedItemId = R.id.home_navi

    }

    private fun changeFragment(fragment: Fragment) {
        supportFragmentManager
            .beginTransaction()
            .replace(R.id.main_frame, fragment)
            .commit()
    }
}