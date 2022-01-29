package com.example.fruithub

import android.app.PendingIntent
import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.LinearLayout
import androidx.databinding.DataBindingUtil
import androidx.fragment.app.DialogFragment
import com.example.fruithub.databinding.FragmentDeliveryDetailsDialogBinding

class DeliveryDetailsDialog : DialogFragment() {

    private lateinit var binding: FragmentDeliveryDetailsDialogBinding

    // Callback Component
    private var callback: DialogListener ?= null

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        // data binding
        binding = DataBindingUtil.inflate(
            inflater,
            R.layout.fragment_delivery_details_dialog,
            container,
            false
        )
        return binding.root

    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        // opening AddCardDetails dialog Box
        binding.payWithCardButton.setOnClickListener {
            callback?.onDialogViewClick(it)
        }

        // opening orderComplete fragment
        binding.payOnDeliveryButton.setOnClickListener {
            callback?.onDialogViewClick(it)
        }
    }

    override fun onStart() {
        super.onStart()
        dialog?.window?.setLayout(
            LinearLayout.LayoutParams.MATCH_PARENT,
            LinearLayout.LayoutParams.WRAP_CONTENT
        )
    }

    override fun onDestroy() {
        super.onDestroy()

        callback?.onDialogDismiss()
    }

    fun setCallbackListener(listener: DialogListener){
        this.callback = listener
    }

    interface DialogListener {
        fun onDialogViewClick(view: View?)
        fun onDialogDismiss()
    }

//    interface DeliveryDialogListener : DialogListener {
//
//        fun onDialogViewClick(view: View?)
//
//
//    }


//    interface AddCardDialogListener :DialogListener {
//
//        fun onDialogViewClick(view: View?)
//        fun onDialogDismiss()
//
//    }

}