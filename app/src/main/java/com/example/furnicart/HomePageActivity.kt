package com.example.furnicart

import android.media.Image
import android.os.Bundle
import android.view.View
import android.widget.ImageView
import androidx.appcompat.app.AppCompatActivity
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.example.furnicart.R


class HomePageActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_home_page)

     /*   val iconList = listOf(
            R.drawable.icon_popular,
            R.drawable.icon_chairs,
            R.drawable.icon_tables,
            R.drawable.icon_sofas,
            R.drawable.icon_beds
        )*/
        /*val recyclerView = findViewById<RecyclerView>(R.id.recyclerView)
        recyclerView.layoutManager = LinearLayoutManager(this,LinearLayoutManager.HORIZONTAL,false)
        recyclerView.adapter = IconAdapter(iconList)*/
        val popularIcon = findViewById<ImageView>(R.id.popular_icon)
        val chairIcon = findViewById<ImageView>(R.id.chair_icon)
        val tableIcon = findViewById<ImageView>(R.id.table_icon)
        val sofaIcon = findViewById<ImageView>(R.id.sofas_icon)
        val bedIcon = findViewById<ImageView>(R.id.bed_icon)

        popularIcon.setOnClickListener {
            animateView(popularIcon)
        }
        chairIcon.setOnClickListener {
            animateView(chairIcon)
        }
        tableIcon.setOnClickListener {
            animateView(tableIcon)
        }
        sofaIcon.setOnClickListener {
            animateView(sofaIcon)
        }
        bedIcon.setOnClickListener {
            animateView(bedIcon)
        }

    }

    fun animateView(view:View) {
        view.animate()
            .scaleX(1.2f)
            .scaleY(1.2f)
            .setDuration(300)
            .withEndAction {
                view.animate()
                    .scaleX(1f)
                    .scaleY(1f)
                    .setDuration(300)
                    .start()
            }
    }
}