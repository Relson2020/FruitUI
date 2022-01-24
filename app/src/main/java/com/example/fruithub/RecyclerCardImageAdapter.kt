package com.example.fruithub

import android.graphics.drawable.Drawable
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageView
import android.widget.TextView
import androidx.cardview.widget.CardView
import androidx.recyclerview.widget.RecyclerView

class RecyclerCardImageAdapter(
    private val saladName: ArrayList<String>,
    private val saladImage: ArrayList<Int>
) : RecyclerView.Adapter<RecyclerCardImageAdapter.ViewHolder>() {
    class ViewHolder(itemView: View) : RecyclerView.ViewHolder(itemView) {
        val text: TextView = itemView.findViewById(R.id.saladName)
        val image: ImageView = itemView.findViewById(R.id.saladImage)
        val cardView : CardView = itemView.findViewById(R.id.cardViewTemplate)
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ViewHolder {
        val view = LayoutInflater.from(parent.context)
            .inflate(R.layout.fragment_card_view_template, parent, false)
        return ViewHolder(view)
    }

    override fun onBindViewHolder(holder: ViewHolder, position: Int) {
        holder.text.text = saladName[position]
        holder.image.setImageResource(saladImage[position])
    }

    override fun getItemCount(): Int {
        return saladName.size
    }
}