package com.example.medbot

import android.annotation.SuppressLint
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.os.Handler
import android.text.method.HideReturnsTransformationMethod
import android.text.method.PasswordTransformationMethod
import android.view.Window
import android.view.WindowManager
import android.widget.Button
import android.widget.EditText
import android.widget.Switch
import android.widget.Toast
import retrofit2.Call
import retrofit2.Callback
import retrofit2.Response
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory

@Suppress("DEPRECATION")
class SigninActivity : AppCompatActivity() {

    private lateinit var retrofit: Retrofit


    @SuppressLint("UseSwitchCompatOrMaterialCode")
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_signin)


        val email = findViewById<EditText>(R.id.signin_scn_email_et)
        val pass = findViewById<EditText>(R.id.signin_scn_pass_et)
        val showPass = findViewById<Switch>(R.id.signin_scn_show_pass)
        val signinBtn = findViewById<Button>(R.id.signin_scn_signin_btn)
        val signupBtn = findViewById<Button>(R.id.signin_scn_signup_btn)


        showPass.setOnCheckedChangeListener{ _, isChecked ->

            if (showPass.isChecked){
                pass.transformationMethod = HideReturnsTransformationMethod.getInstance()
            } else{
                pass.transformationMethod = PasswordTransformationMethod.getInstance()
            }
        }

    }
}