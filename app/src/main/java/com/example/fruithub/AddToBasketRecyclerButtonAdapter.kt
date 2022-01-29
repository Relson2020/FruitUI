package com.example.fruithub

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Button
import androidx.recyclerview.widget.RecyclerView

class AddToBasketRecyclerButtonAdapter(private val buttonName: ArrayList<String>) :
    RecyclerView.Adapter<AddToBasketRecyclerButtonAdapter.ViewHolder>() {

    class ViewHolder(itemView: View) : RecyclerView.ViewHolder(itemView) {
        val button: Button = itemView.findViewById(R.id.addToBasketRecyclerViewButton)
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ViewHolder {
        val view = LayoutInflater.from(parent.context)
            .inflate(R.layout.add_to_basket_recycler_view, parent, false)
        return ViewHolder(view)
    }

    override fun onBindViewHolder(holder: ViewHolder, position: Int) {
        holder.button.text = buttonName[position]
    }

    override fun getItemCount(): Int {
        return buttonName.size
    }
}