package com.example.medbot

import android.annotation.SuppressLint
import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.text.method.HideReturnsTransformationMethod
import android.text.method.PasswordTransformationMethod
import android.widget.Button
import android.widget.EditText
import android.widget.Switch
import android.widget.Toast
import retrofit2.Call
import retrofit2.Retrofit
import retrofit2.Callback
import retrofit2.Response
import retrofit2.converter.gson.GsonConverterFactory

@Suppress("DEPRECATION")
class SignupActivity : AppCompatActivity() {

    private lateinit var retrofit: Retrofit
    @SuppressLint("UseSwitchCompatOrMaterialCode")
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_signup)


        val createPass:EditText = findViewById<EditText>(R.id.signup_create_pass_et)
        val confirmPass:EditText = findViewById<EditText>(R.id.signup_retype_pass_et)
        @SuppressLint("UseSwitchCompatOrMaterialCode")
        val showPassSwitch: Switch = findViewById<Switch>(R.id.signup_scn_show_pass)
        val signupBtn:Button = findViewById<Button>(R.id.signup_scn_sbm_btn)
        val signinBtn:Button = findViewById<Button>(R.id.signup_scn_signin_btn)


        showPassSwitch.setOnCheckedChangeListener{ _, isChecked ->

            if (showPassSwitch.isChecked){
                createPass.transformationMethod = HideReturnsTransformationMethod.getInstance()
                confirmPass.transformationMethod = HideReturnsTransformationMethod.getInstance()
            } else{
                createPass.transformationMethod = PasswordTransformationMethod.getInstance()
                confirmPass.transformationMethod = PasswordTransformationMethod.getInstance()

            }
        }

        signupBtn.setOnClickListener() {
            if (createPass.text.toString() == confirmPass.text.toString()){
                handleSignup()
            }
            else{
                Toast.makeText(this@SignupActivity, "Please enter the same password!", Toast
                    .LENGTH_SHORT).show()
            }


        }
        signinBtn.setOnClickListener(){
            val signupToSigninIntent = Intent(this@SignupActivity, SigninActivity::class.java)
            startActivity(signupToSigninIntent)
        }
    }

    private fun handleSignup() {
        val username: EditText =  findViewById<EditText>(R.id.signup_fullname_et)
        val email: EditText = findViewById<EditText>(R.id.signup_email_et)
        val phone_no:EditText = findViewById<EditText>(R.id.signup_phone_et)
        val age: EditText = findViewById<EditText>(R.id.signup_age_et)
        val createPass:EditText = findViewById<EditText>(R.id.signup_create_pass_et)
        val confirmPass:EditText = findViewById<EditText>(R.id.signup_retype_pass_et)

        val userData = UserData(
            username.text.toString(),
            email.text.toString(),
            phone_no.text.toString(),
            age.text.toString().toInt(),
            confirmPass.text.toString())

        val call = RetrofitClient.instance.signUp(userData)

        call.enqueue(object : Callback<ApiResponse> {
            override fun onResponse(call: Call<ApiResponse>, response: Response<ApiResponse>) {
                if (response.isSuccessful) {
                    val intent = Intent(this@SignupActivity, HomeActivity::class.java)
                    startActivity(intent)
                    val message = response.body()?.message
                    // Handle the success response here
                    Toast.makeText(this@SignupActivity, message, Toast
                        .LENGTH_SHORT).show()
                } else {
                    Toast.makeText(this@SignupActivity, "Signed up Unsuccessfully!", Toast
                        .LENGTH_SHORT).show()
                }
            }

            override fun onFailure(call: Call<ApiResponse>, t: Throwable) {
                Toast.makeText(this@SignupActivity, "Failed!${t}", Toast.LENGTH_SHORT).show()
                println(t)
            }
        })
    }
}