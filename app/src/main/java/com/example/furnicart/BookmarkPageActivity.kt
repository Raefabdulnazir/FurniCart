package com.example.furnicart

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import com.google.android.material.bottomnavigation.BottomNavigationView

class BookmarkPageActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_bookmark_page)

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
        startActivity(intent)
    }

}