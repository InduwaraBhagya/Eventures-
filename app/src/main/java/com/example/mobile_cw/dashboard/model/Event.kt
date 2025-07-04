package com.example.mobile_cw.dashboard.model

data class Event(
    val title: String,
    val iconResId: Int,
    val destinationActivity: Class<*>? = null
)