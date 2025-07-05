package com.example.mobile_cw

import android.content.Intent
import android.os.Bundle
import android.widget.Button
import android.widget.ImageView
import android.widget.TextView
import androidx.appcompat.app.AppCompatActivity

class ReviewConfirmationActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.review_confirmation_activity)

        // Retrieve intent extras
        val eventName = intent.getStringExtra("eventName") ?: "Unknown Event"
        val rating = intent.getFloatExtra("ratingValue", 0f)
        val imageResId = intent.getIntExtra("eventImage", R.drawable.carnival)

        // Find views
        val eventNameText = findViewById<TextView>(R.id.confirmedEventName)
        val ratingText = findViewById<TextView>(R.id.confirmedRating)
        val imageView = findViewById<ImageView>(R.id.confirmedEventImage)
        val reviewAnotherBtn = findViewById<Button>(R.id.reviewAnotherBtn)
        reviewAnotherBtn.setOnClickListener {
            val intent = Intent(this, RateReviewActivity::class.java)
            startActivity(intent)
            finish() // Optional: closes confirmation page only
        }


        // Set data to views
        eventNameText.text = eventName
        ratingText.text = "Your Rating: $rating ★"
        imageView.setImageResource(imageResId)

        // Button click: back to RateReviewActivity
        reviewAnotherBtn.setOnClickListener {
            val intent = Intent(this, RateReviewActivity::class.java)
            startActivity(intent)
            finish() // Optional: close this screen
        }
    }
}
