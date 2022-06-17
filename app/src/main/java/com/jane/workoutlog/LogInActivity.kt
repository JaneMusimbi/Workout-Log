package com.jane.workoutlog

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Patterns
import android.widget.Button
import android.widget.TextView
import com.google.android.material.textfield.TextInputEditText
import com.google.android.material.textfield.TextInputLayout
import com.jane.workoutlog.databinding.ActivityLogInBinding

class LogInActivity : AppCompatActivity() {
    lateinit var binding:ActivityLogInBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityLogInBinding.inflate(layoutInflater)
        setContentView(binding.root)

        binding.tvSignup.setOnClickListener{
            val intent = Intent(this, SignUpActivity::class.java)
            startActivity(intent)
        }
        binding.btnLogin.setOnClickListener {
            validateLogin()
            startActivity(Intent(this,HomeActivity::class.java))
        }
    }
    fun validateLogin(){
        var error=false
        binding.tilEmail.error=null
       binding.tlPassword.error=null
        var email=binding.etEmail.text.toString()
        if (email.isBlank()){
            binding.tilEmail.error="Email is required"
           error=true
        }
        if (!Patterns.EMAIL_ADDRESS.matcher(email).matches()){
            binding.tilEmail.error="Not a valid email address"
            error=true
        }
        var password=binding.etPassword.text.toString()
        if (password.isBlank()){
            binding.tlPassword.error="Password is required"
            error=true
        }
       if (!error){

        }
    }
}