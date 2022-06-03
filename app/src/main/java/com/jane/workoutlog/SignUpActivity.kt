package com.jane.workoutlog

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.provider.ContactsContract
import android.widget.Button
import android.widget.TextView
import com.google.android.material.textfield.TextInputEditText
import com.google.android.material.textfield.TextInputLayout

class SignUpActivity : AppCompatActivity() {
    lateinit var btnSignUp: Button
    lateinit var tvLongIn:TextView
    lateinit var tilName: TextInputLayout
    lateinit var etName: TextInputEditText
    lateinit var tilEmail: TextInputLayout
    lateinit var etEmail: TextInputEditText
    lateinit var tilLast: TextInputLayout
    lateinit var etLast: TextInputEditText
    lateinit var tilPassword: TextInputLayout
    lateinit var etPassword: TextInputEditText
    lateinit var tilConfirm: TextInputLayout
    lateinit var etConfirm: TextInputEditText
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_sign_up)
        btnSignUp = findViewById(R.id.btnSignUp)
        tilName = findViewById(R.id.tillName)
        etName = findViewById(R.id.etName)
        tvLongIn = findViewById(R.id.tvLogIn)
        tilLast = findViewById(R.id.tilLast)
        etLast = findViewById(R.id.etLast)
        tilEmail = findViewById(R.id.tilEmail)
        etEmail = findViewById(R.id.etEmail)
        tilPassword = findViewById(R.id.tilPassword)
        etPassword = findViewById(R.id.etPassword)
        tilConfirm = findViewById(R.id.tilConfirm)
        etConfirm = findViewById(R.id.etconfirm)
        tvLongIn.setOnClickListener {
            var intent = Intent(this, LogInActivity::class.java)
            startActivity(intent)

        }
        btnSignUp.setOnClickListener {
            validateSignUP()
        }
    }
       fun validateSignUP(){
        var error=false
        tilEmail.error=null
        tilPassword.error=null
        var name=etName.text.toString()
        var Last=etLast.text.toString()
        var Email=etEmail.text.toString()
        var Password=etPassword.text.toString()
        var Confirm=etConfirm.text.toString()
        if (name.isBlank()){
            tilName.error="firstname is required"
            error=true
        }




            if (Last.isBlank()){
                tilLast.error="Lastname is required"
                error=true
            }
            if (Email.isBlank()){
                tilEmail.error="Email is required"
                error=true
            }
            if (Password.isBlank()){
                tilPassword.error="Password is required"
                error=true
            }
            if (Confirm.isBlank()){
                tilConfirm.error="PasswordConfirmation is required"
                error=true
            }

            if (!error){

            }
    }
}