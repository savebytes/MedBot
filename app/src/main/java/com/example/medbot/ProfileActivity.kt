package com.example.medbot

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Button


@Suppress("DEPRECATION")
class ProfileActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_profile)

        val backButton = findViewById<Button>(R.id.profile_scn_back_button)

        backButton.setOnClickListener(){
            val backToHomeIntent = Intent(this@ProfileActivity, HomeActivity::class.java)
            startActivity(backToHomeIntent)
        }

    }
}