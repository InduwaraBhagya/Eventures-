package com.example.mobile_cw.dashboard

import android.content.Intent
import android.os.Bundle
import android.widget.Toast
import androidx.appcompat.app.ActionBarDrawerToggle
import androidx.appcompat.app.AppCompatActivity
import androidx.appcompat.widget.Toolbar
import androidx.drawerlayout.widget.DrawerLayout
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.example.mobile_cw.R
import com.example.mobile_cw.dashboard.adapter.EventAdapter
import com.example.mobile_cw.dashboard.model.Event
import com.google.android.material.bottomnavigation.BottomNavigationView

class DashboardActivity : AppCompatActivity() {
    private lateinit var drawerLayout: DrawerLayout
    private lateinit var eventAdapter: EventAdapter

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        // Setup Toolbar
        val toolbar = findViewById<Toolbar>(R.id.toolbar)
        setSupportActionBar(toolbar)

        // Setup DrawerLayout with toggle
        drawerLayout = findViewById(R.id.drawer_layout)
        val toggle = ActionBarDrawerToggle(
            this,
            drawerLayout,
            toolbar,
            R.string.navigation_drawer_open,
            R.string.navigation_drawer_close
        )
        drawerLayout.addDrawerListener(toggle)
        toggle.syncState()

        // Setup RecyclerView with event list
        val recyclerView = findViewById<RecyclerView>(R.id.recyclerView)
        val events = listOf(
            Event("Music Concert", R.drawable.baseline_headphones_24, EventsDashboard::class.java),
            Event("Food Festival", R.drawable.baseline_fastfood_24, EventsDashboard::class.java),
            Event("Sport competition", R.drawable.baseline_sports_basketball_24, EventsDashboard::class.java),
            Event("Art Exhibition", R.drawable.baseline_color_lens_24, EventsDashboard::class.java),
            Event("Tech Conference", R.drawable.baseline_computer_24, EventsDashboard::class.java),

        )

        eventAdapter = EventAdapter(events) { event ->
            event.destinationActivity?.let {
                Toast.makeText(this, "Opening ${event.title} UI", Toast.LENGTH_SHORT).show()
                val intent = Intent(this, it)
                startActivity(intent)
            } ?: Toast.makeText(this, "${event.title} has no assigned screen.", Toast.LENGTH_SHORT).show()
        }

        recyclerView.layoutManager = LinearLayoutManager(this)
        recyclerView.adapter = eventAdapter

        // Setup Bottom Navigation
        val bottomNavigation = findViewById<BottomNavigationView>(R.id.bottom_navigation)
        bottomNavigation.setOnItemSelectedListener { item ->
            when (item.itemId) {
                R.id.navigation_home -> {
                    Toast.makeText(this, "Home selected", Toast.LENGTH_SHORT).show()
                    true
                }
                R.id.navigation_search -> {
                    Toast.makeText(this, "Search selected", Toast.LENGTH_SHORT).show()
                    true
                }
                R.id.navigation_profile -> {
                    Toast.makeText(this, "Profile selected", Toast.LENGTH_SHORT).show()
                    true
                }
                else -> false
            }
        }


    }
}
