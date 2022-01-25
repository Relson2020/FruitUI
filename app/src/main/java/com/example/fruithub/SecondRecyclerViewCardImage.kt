package com.example.fruithub

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.databinding.DataBindingUtil
import com.example.fruithub.databinding.FragmentSecondRecyclerViewCardImageBinding


class SecondRecyclerViewCardImage : Fragment() {

    private lateinit var binding: FragmentSecondRecyclerViewCardImageBinding

    private var recyclerView2saladName: ArrayList<String> =
        arrayListOf("Quinoa fruit salad", "Tropical fruit salad", "Melon fruit salad")

    private var recyclerView2saladImage = arrayListOf(
        R.drawable.quinoa_fruit_salad,
        R.drawable.tropical_fruit_salad,
        R.drawable.berry_mango
    )

    private var recyclerView2priceImage: ArrayList<Int> =
        arrayListOf(R.drawable.ic__10_000, R.drawable.ic__10_000, R.drawable.ic__10_000)

    private val recyclerView2cardColor: ArrayList<Int> =
        arrayListOf(R.color.cardViewColor1, R.color.cardViewColor2, R.color.cardViewColor3)

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        // Inflate the layout for this fragment
        binding = DataBindingUtil.inflate(
            inflater,
            R.layout.fragment_second_recycler_view_card_image,
            container,
            false
        )
        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        binding.secondTabLayoutRecyclerView.adapter =
            RecyclerCardImageAdapter(
                recyclerView2saladName,
                recyclerView2saladImage,
                recyclerView2priceImage,
                recyclerView2cardColor
            )
    }

}