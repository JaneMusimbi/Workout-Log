package com.jane.workoutlog

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.provider.ContactsContract
import android.util.Patterns
import android.widget.Button
import android.widget.TextView
import com.google.android.material.textfield.TextInputEditText
import com.google.android.material.textfield.TextInputLayout
import com.jane.workoutlog.databinding.ActivityLogInBinding
import com.jane.workoutlog.databinding.ActivitySignUpBinding

class SignUpActivity : AppCompatActivity() {
    lateinit var binding: ActivitySignUpBinding
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_sign_up)
        binding = ActivitySignUpBinding.inflate(layoutInflater)
        setContentView(binding.root)

        binding.btnSignUp.setOnClickListener{
            val intent = Intent(this, SignUpActivity::class.java)
            startActivity(intent)
        }
        binding.btnSignUp.setOnClickListener {
            validateSignUP()
            startActivity(Intent(this,HomeActivity::class.java))
        }
    }
       fun validateSignUP(){
        var error=false
       binding.tilEmail.error=null
       binding.tilPassword.error=null
        var name=binding.etName.text.toString()
        var Last=binding.etLast.text.toString()
        var Email=binding.etEmail.text.toString()
        var Password=binding.etPassword.text.toString()
        var Confirm=binding.etconfirm.text.toString()
        if (name.isBlank()){
            binding.tillName.error="firstname is required"
            error=true
        }




            if (Last.isBlank()){
               binding. tilLast.error="Lastname is required"
                error=true
            }
            if (Email.isBlank()){
                binding.tilEmail.error="Email is required"
                error=true
            }
           if(!Patterns.EMAIL_ADDRESS.matcher(Email).matches()){
              binding. tilEmail.error="Not a valid email address"
               error=true

           }
            if (Password.isBlank()){
               binding. tilPassword.error="Password is required"
                error=true
            }
            if (Confirm.isBlank()){
                binding.tilConfirm.error="PasswordConfirmation is required"
                error=true
            }

            if (Password!=Confirm){
                binding.tilConfirm.error="Wrong Password"
                error=true

            }
    }
}