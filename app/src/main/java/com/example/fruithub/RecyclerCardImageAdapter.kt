package com.example.fruithub

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageView
import android.widget.TextView
import androidx.cardview.widget.CardView
import androidx.core.content.ContextCompat
import androidx.recyclerview.widget.RecyclerView

class RecyclerCardImageAdapter(
    private val saladName: ArrayList<Int>,
    private val saladImage: ArrayList<Int>,
    private val priceImage: ArrayList<Int>,
    private val cardColor: ArrayList<Int>
) : RecyclerView.Adapter<RecyclerCardImageAdapter.ViewHolder>() {


    class ViewHolder(itemView: View) : RecyclerView.ViewHolder(itemView) {
        val text: TextView = itemView.findViewById(R.id.saladName)
        val saladImage: ImageView = itemView.findViewById(R.id.saladImage)
        val priceImage: ImageView = itemView.findViewById(R.id.saladPriceImage)
        val cardBg: CardView = itemView.findViewById(R.id.cardViewTemplate)

    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ViewHolder {
        val view = LayoutInflater.from(parent.context)
            .inflate(R.layout.fragment_card_view_template, parent, false)
        return ViewHolder(view)
    }

    override fun onBindViewHolder(holder: ViewHolder, position: Int) {
        holder.text.setText(saladName[position])
        holder.saladImage.setImageResource(saladImage[position])
        holder.priceImage.setImageResource(priceImage[position])
        holder.cardBg.setCardBackgroundColor(
            ContextCompat.getColor(
                holder.cardBg.context,
                cardColor[position]
            )
        )
    }

    override fun getItemCount(): Int {
        return saladName.size
    }
}