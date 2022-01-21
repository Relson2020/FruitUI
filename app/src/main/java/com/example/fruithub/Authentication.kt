package com.example.fruithub

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.databinding.DataBindingUtil
import androidx.navigation.Navigation
import com.example.fruithub.databinding.FragmentAuthenticationBinding

class Authentication : Fragment() {

    private lateinit var binding : FragmentAuthenticationBinding
    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        // Inflate the layout for this fragment
        binding = DataBindingUtil.inflate(inflater,R.layout.fragment_authentication, container, false)

        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        binding.startOrdering.setOnClickListener {
            Navigation.findNavController(it).navigate(R.id.action_authentication_to_homeScreenOne)
        }
    }
}