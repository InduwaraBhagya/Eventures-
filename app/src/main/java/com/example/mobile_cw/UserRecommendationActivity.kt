package com.example.mobile_cw

import android.os.Bundle
import android.widget.Button
import android.widget.Toast
import androidx.appcompat.app.AppCompatActivity

class UserRecommendationActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_user_recommendation)

        // 🔹 Find the button by ID and set click action
        val btnExploreMore = findViewById<Button>(R.id.btnExploreMore)
        btnExploreMore.setOnClickListener {
            // You can replace this with any action
            Toast.makeText(this, "Explore More Clicked!", Toast.LENGTH_SHORT).show()
        }
    }
}
