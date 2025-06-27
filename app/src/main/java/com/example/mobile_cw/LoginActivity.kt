package com.example.mobile_cw

import android.content.Intent
import android.os.Bundle
import android.widget.Button
import android.widget.EditText
import android.widget.TextView
import android.widget.Toast
import androidx.appcompat.app.AppCompatActivity
import com.example.mobile_cw.R

class LoginActivity : AppCompatActivity() {

    // Dummy user data (email and password)
    private val dummyEmail = "bhagya@gmail.com"
    private val dummyPassword = "123456"

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_login)

        val emailInput = findViewById<EditText>(R.id.etLoginEmail)
        val passwordInput = findViewById<EditText>(R.id.etLoginPassword)
        val loginButton = findViewById<Button>(R.id.btnLogin)
        val signupText = findViewById<TextView>(R.id.tvSignupRedirect)

        loginButton.setOnClickListener {
            val email = emailInput.text.toString().trim()
            val password = passwordInput.text.toString().trim()

            if (email.isEmpty() || password.isEmpty()) {
                Toast.makeText(this, "Please fill in both fields", Toast.LENGTH_SHORT).show()
            } else if (email == dummyEmail && password == dummyPassword) {
                Toast.makeText(this, "Login successful!", Toast.LENGTH_SHORT).show()
                // Redirect to Home or Dashboard activity
                //val intent = Intent(this, HomeActivity::class.java) // Replace with your actual Home Activity
                //startActivity(intent)
                finish()
            } else {
                Toast.makeText(this, "Invalid email or password", Toast.LENGTH_SHORT).show()
            }
        }

        //signupText.setOnClickListener {
           // val intent = Intent(this, AdminSignupActivity::class.java)
           // startActivity(intent)
       // }
    }
}
