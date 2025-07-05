package com.example.mobile_cw

import android.content.Intent
import android.os.Bundle
import android.widget.Button
import androidx.appcompat.app.AppCompatActivity
import androidx.appcompat.widget.Toolbar

class EventsDashboard : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_event)

        val toolbar = findViewById<Toolbar>(R.id.music_toolbar)
        setSupportActionBar(toolbar)
        supportActionBar?.setDisplayHomeAsUpEnabled(true)
        supportActionBar?.setDisplayShowHomeEnabled(true)

        toolbar.setNavigationOnClickListener {
            val intent = Intent(this, DashboardActivity::class.java)
            intent.addFlags(Intent.FLAG_ACTIVITY_CLEAR_TOP or Intent.FLAG_ACTIVITY_NEW_TASK)
            startActivity(intent)
            finish()
        }

        // Get the event type from the intent
        val eventType = intent.getStringExtra("EVENT_TYPE") ?: "Event"

        // Find buttons
        val btnCreate = findViewById<Button>(R.id.btn_create)
        val btnManage = findViewById<Button>(R.id.btn_manage)
        val btnViewAll = findViewById<Button>(R.id.btn_view_all)

        // Set dynamic button texts
        btnCreate.text = "Create $eventType Event"
        btnManage.text = "Manage $eventType Events"
        btnViewAll.text = "View All $eventType Events"

        // Set click listeners (you can pass eventType if needed)
        btnCreate.setOnClickListener {
            // Navigate to Create screen for $eventType
        }

        btnManage.setOnClickListener {
            // Navigate to Manage screen for $eventType
        }

        btnViewAll.setOnClickListener {
            // Navigate to View All screen for $eventType
        }
    }
}
