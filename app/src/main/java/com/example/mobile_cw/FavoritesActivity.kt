package com.example.mobile_cw

import android.os.Bundle
import android.view.View
import android.widget.Button
import android.widget.LinearLayout
import android.widget.TextView
import androidx.appcompat.app.AppCompatActivity

class FavoritesActivity : AppCompatActivity() {

    data class Event(val title: String, val date: String, val location: String, val description: String)

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.favorites_activity)

        val eventListLayout = findViewById<LinearLayout>(R.id.eventList)

        val favoriteEvents = listOf(
            Event("Music Fest 2025", "July 20, 2025", "Colombo", "Live performances by top bands."),
            Event("Food Carnival", "August 5, 2025", "Kandy", "Explore local and international cuisine."),
            Event("Tech Expo", "September 15, 2025", "Galle", "Latest innovations in AI and Robotics."),
            Event("Yoga Retreat", "July 10, 2025", "Nuwara Eliya", "Peaceful sessions to refresh your mind.")
        )

        for (event in favoriteEvents) {
            val eventView = layoutInflater.inflate(R.layout.event_item, null)

            val titleText = eventView.findViewById<TextView>(R.id.eventTitle)
            val dateText = eventView.findViewById<TextView>(R.id.eventDate)
            val locationText = eventView.findViewById<TextView>(R.id.eventLocation)
            val descText = eventView.findViewById<TextView>(R.id.eventDescription)
            val cancelBtn = eventView.findViewById<Button>(R.id.cancelButton)

            titleText.text = event.title
            dateText.text = event.date
            locationText.text = event.location
            descText.text = event.description

            cancelBtn.setOnClickListener {
                eventListLayout.removeView(eventView)
            }

            eventListLayout.addView(eventView)
        }
    }
}
