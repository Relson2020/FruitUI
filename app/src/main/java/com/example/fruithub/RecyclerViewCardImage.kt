package com.example.fruithub

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.databinding.DataBindingUtil
import com.example.fruithub.databinding.FragmentRecyclerViewCardImageBinding

class RecyclerViewCardImage : Fragment() {

    private lateinit var binding: FragmentRecyclerViewCardImageBinding

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
            arrayListOf(R.color.white,R.color.white)

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        // data binding
        binding = DataBindingUtil.inflate(
            inflater,
            R.layout.fragment_recycler_view_card_image,
            container,
            false
        )
        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        // recycler view for first tabLayout
        binding.firstTabLayoutRecyclerView.adapter =
            RecyclerCardImageAdapter(
                recyclerView1saladName,
                recyclerView1saladImage,
                recyclerView1priceImage,
                recyclerView1cardColor
            )
    }

}