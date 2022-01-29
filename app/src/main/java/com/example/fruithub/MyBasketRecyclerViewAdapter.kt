package com.example.fruithub

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageView
import android.widget.TextView
import androidx.cardview.widget.CardView
import androidx.core.content.ContextCompat
import androidx.recyclerview.widget.RecyclerView

class MyBasketRecyclerViewAdapter(
    private val saladName: ArrayList<Int>,
    private val saladImage: ArrayList<Int>,
    private val cardColor: ArrayList<Int>
) :
    RecyclerView.Adapter<MyBasketRecyclerViewAdapter.ViewHolder>() {

    class ViewHolder(itemView: View) : RecyclerView.ViewHolder(itemView) {
        val saladName: TextView = itemView.findViewById(R.id.saladNameTextView)
        val cardViewImage: ImageView = itemView.findViewById(R.id.myBasketSaladImage)
        val cardView : CardView = itemView.findViewById(R.id.saladImageCardView)
    }

    override fun onCreateViewHolder(
        parent: ViewGroup,
        viewType: Int
    ): ViewHolder {
        val view = LayoutInflater.from(parent.context)
            .inflate(R.layout.fragment_my_basket_card_view_template, parent, false)
        return ViewHolder(view)
    }

    override fun onBindViewHolder(holder: ViewHolder, position: Int) {
        holder.saladName.setText(saladName[position])
        holder.cardViewImage.setImageResource(saladImage[position])
        holder.cardView.setCardBackgroundColor(ContextCompat.getColor(holder.cardView.context,cardColor[position]))
    }

    override fun getItemCount(): Int {
        return saladName.size
    }
}