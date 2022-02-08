package com.example.toyprj.Adapter

import androidx.fragment.app.Fragment
import androidx.fragment.app.FragmentManager
import androidx.fragment.app.FragmentStatePagerAdapter
import com.example.toyprj.Fragment.AccountFrag
import com.example.toyprj.Fragment.GameFrag
import com.example.toyprj.Fragment.HomeFrag
import com.example.toyprj.Fragment.TestFrag

class MainFragmentStatePagerAdapter(fm : FragmentManager, private val fragmentCount : Int) : FragmentStatePagerAdapter(fm, BEHAVIOR_RESUME_ONLY_CURRENT_FRAGMENT) {
    override fun getItem(position: Int): Fragment {
        return when(position){
            0 -> HomeFrag()
            1 -> GameFrag()
            2 -> TestFrag()
            3 -> AccountFrag()
            else -> HomeFrag()
        }
    }

    override fun getCount(): Int = fragmentCount // 자바에서는 { return fragmentCount }

}