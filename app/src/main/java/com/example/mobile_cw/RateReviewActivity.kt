package com.example.mobile_cw

import android.content.res.ColorStateList
import android.graphics.Color
import android.os.Bundle
import android.view.LayoutInflater
import android.widget.*
import androidx.appcompat.app.AppCompatActivity

class RateReviewActivity : AppCompatActivity() {

    data class AttendedEvent(
        val title: String,
        val imageResId: Int // Drawable resource ID
    )

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.rate_review_activity)

        val eventReviewList = findViewById<LinearLayout>(R.id.eventReviewList)

        // Example list of attended events with sample images
        val attendedEvents = listOf(
            AttendedEvent("Music Fest 2025", R.drawable.music_fest),
            AttendedEvent("Food Carnival", R.drawable.food_carnival),
            AttendedEvent("Tech Expo", R.drawable.tech_expo)
        )

        for (event in attendedEvents) {
            val eventView = LayoutInflater.from(this).inflate(R.layout.event_review_item, null)

            val titleText = eventView.findViewById<TextView>(R.id.eventTitle)
            val imageView = eventView.findViewById<ImageView>(R.id.eventImage)
            val ratingBar = eventView.findViewById<RatingBar>(R.id.ratingBar)
            // Set yellow color for selected stars (progress)
            val yellow = Color.parseColor("#FFD700")
            ratingBar.progressTintList = ColorStateList.valueOf(yellow)
            ratingBar.secondaryProgressTintList = ColorStateList.valueOf(yellow)
            ratingBar.thumbTintList = ColorStateList.valueOf(yellow)
            val reviewInput = eventView.findViewById<EditText>(R.id.reviewInput)
            val submitButton = eventView.findViewById<Button>(R.id.submitReviewBtn)

            titleText.text = event.title
            imageView.setImageResource(event.imageResId)

            submitButton.setOnClickListener {
                val rating = ratingBar.rating
                val review = reviewInput.text.toString()

                Toast.makeText(
                    this,
                    "Thanks for rating '${event.title}' $rating★\nReview: $review",
                    Toast.LENGTH_SHORT
                ).show()
            }

            eventReviewList.addView(eventView)
        }
    }
}
