package com.example.fruithub

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.databinding.DataBindingUtil
import androidx.fragment.app.Fragment
import androidx.navigation.findNavController
import com.example.fruithub.databinding.FragmentOrderListBinding

class OrderList : Fragment() {

    private lateinit var binding: FragmentOrderListBinding
    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        // Inflate the layout for this fragment
        binding = DataBindingUtil.inflate(inflater, R.layout.fragment_order_list, container, false)
        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        // navigating to myBasket fragment
        binding.orderListGoBack.setOnClickListener {
            it.findNavController().navigate(R.id.action_orderList_to_myBasket)
        }

    }
}