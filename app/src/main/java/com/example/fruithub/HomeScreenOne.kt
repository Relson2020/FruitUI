package com.example.fruithub

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.databinding.DataBindingUtil
import androidx.fragment.app.Fragment
import androidx.navigation.findNavController
import com.example.fruithub.databinding.FragmentHomeScreenOneBinding
import com.google.android.material.tabs.TabLayoutMediator

class HomeScreenOne : Fragment() {

    private lateinit var binding: FragmentHomeScreenOneBinding

    // button name array
    private var buttonArray: ArrayList<String> =
        arrayListOf("All", "Salad Combo", "Berry Combo", "Mango Combo")

    // salad name array
    private var recyclerView1saladName: ArrayList<String> =
        arrayListOf("Honey lime combo", "Berry mango combo")

    // salad image array
    private var recyclerView1saladImage: ArrayList<Int> =
        arrayListOf(R.drawable.temp, R.drawable.berry_mango)

    // price image array
    private var recyclerView1priceImage: ArrayList<Int> =
        arrayListOf(R.drawable.ic___2000, R.drawable.ic___2000)

    // cardView background color array
    private val recyclerView1cardColor: ArrayList<Int> =
        arrayListOf(R.color.white, R.color.white)

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

        // recommended recycler view
        binding.recommendedRecyclerView.adapter = RecyclerCardImageAdapter(
            recyclerView1saladName,
            recyclerView1saladImage,
            recyclerView1priceImage,
            recyclerView1cardColor
        )


        // second tabLayout viewpager
        binding.secondViewpager.adapter = SecondViewPager(parentFragmentManager, lifecycle)

        // second tabLayout
        TabLayoutMediator(binding.secondTabLayout, binding.secondViewpager) { tab, position ->
            when (position) {
                0 -> tab.text = "Hottest"
                1 -> tab.text = "Popular"
                2 -> tab.text = "New Combo"
                else -> {}
            }
        }.attach()

        // navigating to myBasket fragment
        binding.basketCardView.setOnClickListener {
            it.findNavController().navigate(R.id.action_homeScreenOne_to_addToBasket)
        }
    }
}