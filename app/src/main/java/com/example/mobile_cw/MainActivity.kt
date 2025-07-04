package com.example.mobile_cw

import android.annotation.SuppressLint
import android.content.Intent
import android.os.Bundle
import android.widget.Button
import androidx.appcompat.app.AppCompatActivity

class MainActivity : AppCompatActivity() {
    @SuppressLint("SuspiciousIndentation")
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

       val openSignupButton = findViewById<Button>(R.id.btnOpenSignup)
          openSignupButton.setOnClickListener {
            startActivity(Intent(this, SignupActivity::class.java))
       }
    }
}
