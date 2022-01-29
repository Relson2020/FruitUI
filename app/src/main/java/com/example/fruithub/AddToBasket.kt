package com.example.fruithub

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.databinding.DataBindingUtil
import androidx.fragment.app.Fragment
import androidx.navigation.findNavController
import com.example.fruithub.databinding.FragmentAddToBasketBinding
import com.google.android.flexbox.FlexDirection
import com.google.android.flexbox.FlexboxLayoutManager

class AddToBasket : Fragment() {

    private lateinit var binding: FragmentAddToBasketBinding

    // buttons name array
    private val buttons = arrayListOf(
        "Red Quinoa",
        "Lime",
        "Honey",
        "Blueberries",
        "Mango",
        "Strawberries",
        "Fresh Mint"
    )

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        // data binding
        binding =
            DataBindingUtil.inflate(inflater, R.layout.fragment_add_to_basket, container, false)
        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        // flexbox with recyclerView
        val layoutManager = FlexboxLayoutManager(context)
        layoutManager.flexDirection = FlexDirection.ROW
        binding.addToBasketButtonRecyclerView.layoutManager = layoutManager
        binding.addToBasketButtonRecyclerView.adapter = AddToBasketRecyclerButtonAdapter(buttons)

        // goBack

        binding.addToBasketGoBack.setOnClickListener {
            it.findNavController().navigate(R.id.action_addToBasket_to_homeScreenOne)
        }
    }
}