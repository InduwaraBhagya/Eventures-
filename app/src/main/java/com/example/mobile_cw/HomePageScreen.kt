package com.example.eventuresapp

import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView

class HomeActivity : AppCompatActivity() {

    private lateinit var recyclerView: RecyclerView
    private lateinit var adapter: EventAdapter
    private lateinit var eventList: List<Event>

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_home)

        recyclerView = findViewById(R.id.rvEvents)
        recyclerView.layoutManager = LinearLayoutManager(this)

        // Dummy event list
        eventList = listOf(
            Event("Tech Conference", "Colombo", "2025-07-15"),
            Event("Food Festival", "Kandy", "2025-07-20"),
            Event("Music Night", "Galle", "2025-07-25")
        )

        adapter = EventAdapter(eventList)
        recyclerView.adapter = adapter
    }
}

