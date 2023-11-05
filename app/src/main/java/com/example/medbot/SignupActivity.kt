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
    private val fullName: EditText = findViewById<EditText>(R.id.signup_fullname_et)
    private val email: EditText = findViewById<EditText>(R.id.signup_email_et)
    private val phone_no:EditText = findViewById<EditText>(R.id.signup_phone_et)
    private val age: EditText = findViewById<EditText>(R.id.signup_age_et)
    private val createPass:EditText = findViewById<EditText>(R.id.signup_create_pass_et)
    private val confirmPass:EditText = findViewById<EditText>(R.id.signup_retype_pass_et)
    @SuppressLint("UseSwitchCompatOrMaterialCode")
    private val showPassSwitch: Switch = findViewById<Switch>(R.id.signup_scn_show_pass)
    private val signupBtn:Button = findViewById<Button>(R.id.signup_scn_sbm_btn)
    private val signinBtn:Button = findViewById<Button>(R.id.signup_scn_signin_btn)


    @SuppressLint("UseSwitchCompatOrMaterialCode")
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_signup)


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
            val intent = Intent(this@SignupActivity, HomeActivity::class.java)
            startActivity(intent)

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

        val userData = UserData(
            fullName.text.toString(),
            email.text.toString(),
            phone_no.text.toString(),
            age.text.toString().toInt(),
            confirmPass.text.toString())

        val call = RetrofitClient.instance.signUp(userData)

        call.enqueue(object : Callback<ApiResponse> {
            override fun onResponse(call: Call<ApiResponse>, response: Response<ApiResponse>) {
                if (response.isSuccessful) {
                    val message = response.body()?.message
                    // Handle the success response here
                    Toast.makeText(this@SignupActivity, "Signed up Successfully!", Toast
                        .LENGTH_SHORT).show()
                } else {
                    Toast.makeText(this@SignupActivity, "Signed up Unsuccessfully!", Toast
                        .LENGTH_SHORT).show()
                }
            }

            override fun onFailure(call: Call<ApiResponse>, t: Throwable) {
                // Handle the network or other errors here
            }
        })
    }
}