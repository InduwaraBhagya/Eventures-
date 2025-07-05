package com.example.mobile_cw.model

data class Event(
    val title: String,
    val iconResId: Int,
    val destinationActivity: Class<*>? = null
)