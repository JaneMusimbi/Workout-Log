package com.jane.workoutlog

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Button
import android.widget.TextView
import com.google.android.material.textfield.TextInputEditText
import com.google.android.material.textfield.TextInputLayout

class LogInActivity : AppCompatActivity() {
    lateinit var btnLogin:Button
    lateinit var tilEmail:TextInputLayout
    lateinit var etEmail: TextInputEditText
    lateinit var tilPassword:TextInputLayout
    lateinit var etPassword: TextInputEditText
    lateinit var tvSignUp: TextView
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_log_in)
        castviews()}
        fun castviews() {
            btnLogin = findViewById(R.id.btnLogin)
            tilEmail = findViewById(R.id.tilEmail)
            etEmail = findViewById(R.id.etEmail)
            tilPassword = findViewById(R.id.tlPassword)
            etPassword = findViewById(R.id.etPassword)
            tvSignUp = findViewById(R.id.tvSignup)

            tvSignUp.setOnClickListener {
                val intent = Intent(this, SignUpActivity::class.java)
                startActivity(intent)
            }
            btnLogin.setOnClickListener {
                validateLogin()
                startActivity(Intent(this, HomeActivity::class.java))

            }
        }


    fun validateLogin(){
//        var error=false
//        tilEmail.error=null
//        tilPassword.error=null
        var email=etEmail.text.toString()
        if (email.isBlank()){
            tilEmail.error="Email is required"
//            error=true
        }
        var password=etPassword.text.toString()
        if (password.isBlank()){
            tilPassword.error="Password is required"
//            error=true
        }
//        if (!error){
//
//        }



    }
}