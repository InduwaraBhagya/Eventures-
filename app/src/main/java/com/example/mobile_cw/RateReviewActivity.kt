package com.example.mobile_cw

import android.content.Intent
import android.os.Bundle
import android.widget.Button
import android.widget.EditText
import android.widget.ImageView
import android.widget.LinearLayout
import android.widget.RatingBar
import android.widget.TextView
import androidx.appcompat.app.AppCompatActivity

class RateReviewActivity : AppCompatActivity() {

    // Event data class
    data class Event(val title: String, val imageResId: Int)

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.rate_review_activity)

        // Parent layout where we'll dynamically add event cards
        val reviewListLayout = findViewById<LinearLayout>(R.id.reviewList)

        // Sample attended events
        val attendedEvents = listOf(
            Event("Music Fest 2025", R.drawable.music_fest),
            Event("Food Carnival", R.drawable.food_carnival),
            Event("Tech Expo", R.drawable.tech_expo)
        )

        // Dynamically add review items
        for (event in attendedEvents) {
            // Inflate event_review_item.xml layout for each event
            val eventView = layoutInflater.inflate(R.layout.event_review_item, null)

            // Get views from inflated layout
            val eventTitle = eventView.findViewById<TextView>(R.id.eventTitle)
            val eventImage = eventView.findViewById<ImageView>(R.id.eventImage)
            val ratingBar = eventView.findViewById<RatingBar>(R.id.ratingBar)
            val reviewInput = eventView.findViewById<EditText>(R.id.reviewInput)
            val submitButton = eventView.findViewById<Button>(R.id.submitReviewBtn)

            // Set event data
            eventTitle.text = event.title
            eventImage.setImageResource(event.imageResId)

            // Handle submit
            submitButton.setOnClickListener {
                val intent = Intent(this, ReviewConfirmationActivity::class.java)
                intent.putExtra("eventName", event.title)
                intent.putExtra("ratingValue", ratingBar.rating)
                intent.putExtra("eventImage", event.imageResId)
                startActivity(intent)
            }

            // Add to the review list
            reviewListLayout.addView(eventView)
        }
    }
}
