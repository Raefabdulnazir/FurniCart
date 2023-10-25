/*
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
        holder.bindIcon(iconRes,position)
    }

    override fun getItemCount(): Int {//to get the total number of items in the list
        return iconList.size
    }

    class IconViewHolder(itemView: View) : RecyclerView.ViewHolder(itemView){//it represents individual view for each item in the recycler view
        private val popular_icon: ImageView = itemView.findViewById(R.id.popular_icon)
        private val chair_icon: ImageView = itemView.findViewById(R.id.chair_icon)
        private val table_icon: ImageView = itemView.findViewById(R.id.table_icon)
        private val sofa_icon: ImageView = itemView.findViewById(R.id.sofa_icon)
        private val bed_icon: ImageView = itemView.findViewById(R.id.bed_icon)

        fun bindIcon(iconRes: Int,position: Int){
            when(position){
            0->popular_icon.setImageResource(iconRes)
            1->chair_icon.setImageResource(iconRes)
            2->table_icon.setImageResource(iconRes)
            3->sofa_icon.setImageResource(iconRes)
            4-> bed_icon.setImageResource(iconRes)
            }
        }
    }
}*/
