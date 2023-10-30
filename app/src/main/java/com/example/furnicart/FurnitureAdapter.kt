package com.example.furnicart

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageView
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView

class FurnitureAdapter(private val furnitureItems: List<Furnitureitem>) :
    RecyclerView.Adapter<FurnitureAdapter.FurnitureViewHolder>() {

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): FurnitureViewHolder {
        val view: View = LayoutInflater.from(parent.context).inflate(R.layout.item_furniture, parent, false)
        return FurnitureViewHolder(view)
    }

    override fun onBindViewHolder(holder: FurnitureViewHolder, position: Int) {
        val currentItem: Furnitureitem = furnitureItems[position]
        // Bind your data to the views here
        holder.furnitureImageView.setImageResource(currentItem.imageResid)
        holder.furnitureNameTextView.text = currentItem.name
        holder.furniturePriceTextView.text = currentItem.price.toString()
    }

    override fun getItemCount(): Int {
        return furnitureItems.size
    }

    class FurnitureViewHolder(itemView: View) : RecyclerView.ViewHolder(itemView) {
        val furnitureImageView: ImageView = itemView.findViewById(R.id.furnitureImageView)
        val furnitureNameTextView: TextView = itemView.findViewById(R.id.furnitureNameTextView)
        val furniturePriceTextView: TextView = itemView.findViewById(R.id.furniturePriceTextView)
    }
}
