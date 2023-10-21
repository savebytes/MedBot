package com.example.medbot

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Button

@Suppress("DEPRECATION")
class SignupActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_signup)

        findViewById<Button>(R.id.signup_scn_sbm_btn).setOnClickListener(){
            val intent = Intent(this@SignupActivity, HomeActivity::class.java)
            startActivity(intent)
        }
    }
}