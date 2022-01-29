package com.example.fruithub

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.databinding.DataBindingUtil
import androidx.fragment.app.Fragment
import androidx.navigation.findNavController
import com.example.fruithub.databinding.FragmentOrderCompleteBinding

class OrderComplete : Fragment() {

    private lateinit var binding: FragmentOrderCompleteBinding
    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        // data binding
        binding =
            DataBindingUtil.inflate(inflater, R.layout.fragment_order_complete, container, false)
        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        // navigating to order list fragment
        binding.trackOrderButton.setOnClickListener {
            it.findNavController().navigate(R.id.action_orderComplete_to_orderList)
        }

        // navigating to continue shopping
        binding.continueShoppingButton.setOnClickListener {
            it.findNavController().navigate(R.id.action_orderComplete_to_homeScreenOne)
        }
    }
}