package com.example.fruithub

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.LinearLayout
import androidx.databinding.DataBindingUtil
import androidx.fragment.app.DialogFragment
import androidx.navigation.Navigation
import androidx.navigation.findNavController
import androidx.navigation.fragment.NavHostFragment
import androidx.navigation.fragment.findNavController
import com.example.fruithub.databinding.FragmentAddCardDialogBoxBinding

class AddCardDialogBox : DialogFragment() {

    private lateinit var binding: FragmentAddCardDialogBoxBinding

    private var callback : DialogListener? = null
    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        // Inflate the layout for this fragment
        binding = DataBindingUtil.inflate(
            inflater,
            R.layout.fragment_add_card_dialog_box,
            container,
            false
        )
        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        // navigating to order complete fragment
        binding.completeOrderButton.setOnClickListener {
            callback?.onDialogViewClick2(it)
        }
    }

    override fun onStart() {
        super.onStart()
        dialog?.window?.setLayout(
            LinearLayout.LayoutParams.MATCH_PARENT,
            LinearLayout.LayoutParams.WRAP_CONTENT
        )
    }
    fun setCallbackListener(listener : DialogListener){
        this.callback= listener
    }

    interface DialogListener{
        fun onDialogViewClick2(view : View?)
        fun onDialogDismiss2()
    }
}