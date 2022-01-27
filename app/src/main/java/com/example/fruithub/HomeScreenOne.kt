package com.example.fruithub

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.databinding.DataBindingUtil
import androidx.navigation.findNavController
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
        // data binding
        binding =
            DataBindingUtil.inflate(inflater, R.layout.fragment_home_screen_one, container, false)

        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        // recycler view for button adapter
        binding.buttonRecyclerView.adapter = RecyclerButtonAdapter(buttonArray)

        // first tabLayout viewPager
        binding.firstViewpager.adapter = FirstViewPager(parentFragmentManager,lifecycle)

        // first tabLayout
        TabLayoutMediator(binding.firstTabLayout,binding.firstViewpager){ tab ,position ->
            when(position){
                0 -> tab.text = "Recommended Combo"
            }
        }.attach()

        // second tabLayout viewpager
        binding.secondViewpager.adapter = SecondViewPager(parentFragmentManager,lifecycle)

        // second tabLayout
        TabLayoutMediator(binding.secondTabLayout,binding.secondViewpager){tab,position ->
            when(position){
                0 -> tab.text = "Hottest"
                1 -> tab.text = "Popular"
                2 -> tab.text = "New Combo"
                else -> {}
            }
        }.attach()

        // navigating to myBasket fragment
        binding.basketCardView.setOnClickListener {
            it.findNavController().navigate(R.id.action_homeScreenOne_to_myBasket)
        }
    }
}