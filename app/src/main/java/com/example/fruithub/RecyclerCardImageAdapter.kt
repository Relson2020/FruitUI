package com.example.fruithub

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageView
import android.widget.TextView
import androidx.cardview.widget.CardView
import androidx.recyclerview.widget.RecyclerView

class RecyclerCardImageAdapter(
    private val saladName: ArrayList<String>,
    private val saladImage: ArrayList<Int>,
    private val priceImage: ArrayList<Int>,
    private val cardColor : ArrayList<Int>
) : RecyclerView.Adapter<RecyclerCardImageAdapter.ViewHolder>() {

    private val context = ApplicationClass()

    class ViewHolder(itemView: View) : RecyclerView.ViewHolder(itemView) {
        val text: TextView = itemView.findViewById(R.id.saladName)
        val saladImage: ImageView = itemView.findViewById(R.id.saladImage)
        val priceImage : ImageView = itemView.findViewById(R.id.saladPriceImage)
        val cardBg : CardView = itemView.findViewById(R.id.cardViewTemplate)

    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ViewHolder {
        val view = LayoutInflater.from(parent.context)
            .inflate(R.layout.fragment_card_view_template, parent, false)
        return ViewHolder(view)
    }

    override fun onBindViewHolder(holder: ViewHolder, position: Int) {
        holder.text.text = saladName[position]
        holder.saladImage.setImageResource(saladImage[position])
        holder.priceImage.setImageResource(priceImage[position])
        holder.cardBg.setBackgroundResource(cardColor[position])
    }

    override fun getItemCount(): Int {
        return saladName.size
    }
}