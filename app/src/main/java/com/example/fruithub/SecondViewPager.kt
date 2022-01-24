package com.example.fruithub

import androidx.fragment.app.Fragment
import androidx.fragment.app.FragmentManager
import androidx.lifecycle.Lifecycle
import androidx.viewpager2.adapter.FragmentStateAdapter

class SecondViewPager(supportFragmentManager: FragmentManager, lifecycle: Lifecycle) :
    FragmentStateAdapter(supportFragmentManager, lifecycle) {
    override fun getItemCount(): Int {
       return 3
    }

    override fun createFragment(position: Int): Fragment {
       return  when(position){
            0 -> SecondRecyclerViewCardImage()
            1 -> SecondRecyclerViewCardImage()
            2 -> SecondRecyclerViewCardImage()
           else -> {
               SecondRecyclerViewCardImage()
           }
       }
    }
}