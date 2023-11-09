package com.example.furnicart

import android.content.Intent
import android.media.Image
import android.os.Bundle
import android.view.View
import android.widget.ImageView
import androidx.appcompat.app.AppCompatActivity
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.example.furnicart.R
import com.google.android.material.bottomnavigation.BottomNavigationView


class HomePageActivity : AppCompatActivity() {
    private lateinit var furnitureRecyclerView:  RecyclerView
    private lateinit var furnitureAdapter: FurnitureAdapter
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_home_page)

        //find the recyclerView
        furnitureRecyclerView = findViewById(R.id.furnitureRecyclerView)

        // Create dummy data (you should replace this with your actual data)
        val furnitureItems: List<Furnitureitem> = generateDummyData()

        //set up the adapter
        furnitureAdapter = FurnitureAdapter(furnitureItems)
        furnitureRecyclerView.layoutManager = LinearLayoutManager(this)
        furnitureRecyclerView.adapter = furnitureAdapter

        //sample data for recyclerView
        val sampleFurnitureItems: List<Furnitureitem> = listOf(
            Furnitureitem(R.drawable.sample_sofa_img,"Sample item 1" , 100.00)
        )

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

        //bottom navigation bar
        val bottomNavigationView : BottomNavigationView = findViewById(R.id.bottom_navigation)
        bottomNavigationView.setOnNavigationItemSelectedListener { item ->
            when(item.itemId) {
                R.id.navigation_home -> {
                    openHomePage()
                    true
                }
                R.id.navigation_bookmark -> {
                    openBookmarkPage()
                    true
                }
                R.id.navigation_account -> {
                    openAccountPage()
                    true
                }
                else->false
            }
        }

    }
    private fun generateDummyData(): List<Furnitureitem>{
        val furnitureItems: MutableList<Furnitureitem> = ArrayList(0)
        // Add some items to the list
        // Replace this with your actual data population logic
        return furnitureItems
    }

    private fun openHomePage(){
        val intent = Intent(this, HomePageActivity::class.java)
        startActivity(intent)
    }
    private fun openBookmarkPage(){
        val intent = Intent(this,BookmarkPageActivity::class.java)
        startActivity(intent)
    }

    private fun openAccountPage(){
        val intent = Intent(this,MyAccountActivity::class.java)
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