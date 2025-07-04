package com.example.mobile_cw

import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.example.mobile_cw.Event
import com.example.mobile_cw.EventAdapter
import com.example.mobile_cw.R
import android.content.Intent
import android.widget.Button


class HomeActivity : AppCompatActivity() {

    private lateinit var recyclerView: RecyclerView
    private lateinit var adapter: EventAdapter
    private lateinit var eventList: List<Event>

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_home)

        // Set up RecyclerView
        recyclerView = findViewById(R.id.rvEvents)
        recyclerView.layoutManager = LinearLayoutManager(this)

        // Dummy data
        eventList = listOf(
            Event("Tech Conference", "Colombo", "2025-07-15"),
            Event("Food Festival", "Kandy", "2025-07-20"),
            Event("Music Night", "Galle", "2025-07-25")
        )

        adapter = EventAdapter(eventList)
        recyclerView.adapter = adapter

        // 🔹 Set up Recommendation Button
        val btnRecommendation = findViewById<Button>(R.id.btnUserRecommendation)
        btnRecommendation.setOnClickListener {
            val intent = Intent(this, UserRecommendationActivity::class.java)
            startActivity(intent)
        }
    }
}
