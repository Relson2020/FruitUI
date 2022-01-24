package com.example.fruithub

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.databinding.DataBindingUtil
import com.example.fruithub.databinding.FragmentHomeScreenOneBinding
import com.google.android.material.tabs.TabLayoutMediator

class HomeScreenOne : Fragment() {

    private lateinit var binding: FragmentHomeScreenOneBinding
    private var buttonArray: ArrayList<String> =
        arrayListOf("All", "Salad Combo", "Berry Combo", "Mango Combo")


    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        // Inflate the layout for this fragment
        binding =
            DataBindingUtil.inflate(inflater, R.layout.fragment_home_screen_one, container, false)

        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        binding.buttonRecyclerView.adapter = RecyclerButtonAdapter(buttonArray)

        binding.firstViewpager.adapter = FirstViewPager(parentFragmentManager,lifecycle)

        TabLayoutMediator(binding.firstTabLayout,binding.firstViewpager){ tab ,position ->
            when(position){
                0 -> tab.text = "Recommended Combo"
            }
        }.attach()

        binding.secondViewpager.adapter = SecondViewPager(parentFragmentManager,lifecycle)

        TabLayoutMediator(binding.secondTabLayout,binding.secondViewpager){tab,position ->
            when(position){
                0 -> tab.text = "Hottest"
                1 -> tab.text = "Popular"
                2 -> tab.text = "New Combo"
                else -> {}
            }
        }.attach()
    }
}