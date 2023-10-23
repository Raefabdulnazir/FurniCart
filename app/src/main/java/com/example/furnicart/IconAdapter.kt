package com.example.furnicart

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageView
import androidx.recyclerview.widget.RecyclerView


class IconAdapter (private val iconList: List<Int>):RecyclerView.Adapter<IconAdapter.IconViewHolder>(){
    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): IconViewHolder {
        val view = LayoutInflater.from(parent.context).inflate(R.layout.item_icon,parent,false)
        return IconViewHolder(view)
    }

    override fun onBindViewHolder(holder:IconViewHolder, position: Int) {
        val iconRes = iconList[position]
        holder.bindIcon(iconRes)
    }

    override fun getItemCount(): Int {//to get the total number of items in the list
        return iconList.size
    }

    class IconViewHolder(itemView: View) : RecyclerView.ViewHolder(itemView){//it represents individual view for each item in the recycler view
        private val iconImageView: ImageView = itemView.findViewById(R.id.iconImageView)

        fun bindIcon(iconRes: Int){
            iconImageView.setImageResource(iconRes)
        }
    }
}