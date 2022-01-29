package com.example.fruithub

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.databinding.DataBindingUtil
import androidx.fragment.app.Fragment
import androidx.navigation.findNavController
import androidx.navigation.fragment.NavHostFragment
import com.example.fruithub.databinding.FragmentMyBasketBinding

class MyBasket : Fragment(), DeliveryDetailsDialog.DialogListener {

    private lateinit var binding: FragmentMyBasketBinding

    // salad names array
    private val saladName =
        arrayListOf(R.string.quinoa_frui, R.string.melon_fruit, R.string.tropical_fr)

    // salad image array
    private val saladImage = arrayListOf(
        R.drawable.breakfast_quinoa_and_red_fruit_salad,
        R.drawable.berryworld_kiwiberry_fruit_salad,
        R.drawable.best_ever_tropical_fruit_salad
    )

    // card backGround color
    private val cardColor = arrayListOf(
        R.color.cardViewColor1,
        R.color.cardViewColor2,
        R.color.cardViewColor3
    )

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        // DataBinding
        binding = DataBindingUtil.inflate(inflater, R.layout.fragment_my_basket, container, false)
        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        // go back button
        binding.goBack.setOnClickListener {
            it.findNavController().navigate(R.id.action_myBasket_to_homeScreenOne)
        }

        // checkOut button opening AddressDetail dialogBox
        binding.checkOutButton.setOnClickListener {
            val deliveryDialog = DeliveryDetailsDialog()
            deliveryDialog.setCallbackListener(this)
            deliveryDialog.show(childFragmentManager, "delivery dialog box")
        }

        // myBasket recycler view
        binding.myBasketRecyclerView.adapter =
            MyBasketRecyclerViewAdapter(saladName, saladImage, cardColor)

        // navigating to orderComplete
        binding.totalTextView.setOnClickListener {
            it.findNavController().navigate(R.id.action_myBasket_to_orderComplete)
        }
    }

    override fun onDialogViewClick(view: View?) {
        when (view?.id) {

            R.id.payWithCardButton -> {
                val addCardDialogBox = AddCardDialogBox()
                addCardDialogBox.setCallbackListener(object : AddCardDialogBox.DialogListener {
                    override fun onDialogViewClick2(view: View?) {
                        when (view?.id) {
                            R.id.completeOrderButton -> {
//                                Navigation.findNavController(view)
//                                    .navigate(R.id.action_myBasket_to_orderComplete)
                                val navHostFragment =
                                    parentFragmentManager.findFragmentById(R.id.fragmentContainerView) as NavHostFragment
                                val navController = navHostFragment.navController
                                navController.navigate(R.id.action_myBasket_to_orderComplete)
                            }
                        }

                    }

                    override fun onDialogDismiss2() {
                    }
                })
                addCardDialogBox.show(childFragmentManager, "add card details")
            }
            R.id.payOnDeliveryButton -> {

            }
        }
    }

    override fun onDialogDismiss() {
    }
}