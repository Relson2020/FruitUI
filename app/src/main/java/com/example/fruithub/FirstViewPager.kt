package com.example.fruithub

import androidx.fragment.app.Fragment
import androidx.fragment.app.FragmentManager
import androidx.lifecycle.Lifecycle
import androidx.viewpager2.adapter.FragmentStateAdapter

class FirstViewPager(supportFragmentManager: FragmentManager, lifecycle: Lifecycle) :
    FragmentStateAdapter(supportFragmentManager, lifecycle) {
    override fun getItemCount(): Int {
      return 1
    }

    override fun createFragment(position: Int): Fragment {
       return when(position){
           0 -> RecyclerViewCardImage()
           else -> {
               RecyclerViewCardImage()
           }
       }
    }
}