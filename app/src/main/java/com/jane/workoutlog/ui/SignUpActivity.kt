package com.jane.workoutlog.ui

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.provider.ContactsContract
import android.util.Patterns
import android.widget.Toast
import androidx.activity.viewModels
import androidx.lifecycle.Observer
import androidx.lifecycle.ViewModel
import com.jane.workoutlog.R
import com.jane.workoutlog.ViewModel.UserViewModel
import com.jane.workoutlog.api.ApiInterface
import com.jane.workoutlog.api.Apiclient
import com.jane.workoutlog.databinding.ActivitySignUpBinding
import com.jane.workoutlog.models.RegisterRequest
import com.jane.workoutlog.models.RegisterResponse
import retrofit2.Call
import retrofit2.Callback
import retrofit2.Response
import java.util.jar.Attributes

class SignUpActivity : AppCompatActivity() {
    lateinit var binding: ActivitySignUpBinding
    val userViewModel:UserViewModel by viewModels()
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_sign_up)
        binding=ActivitySignUpBinding.inflate(layoutInflater)
        setContentView(binding.root)

//        binding.btnSignUp.setOnClickListener{
//            val intent = Intent(this, SignUpActivity::class.java)
//            startActivity(intent)
//        }
        binding.btnSignUp.setOnClickListener {
            validateSignUP()
            startActivity(Intent(this, LogInActivity::class.java))
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
        var Number=binding.etNumber.text.toString()
        if (name.isBlank()){
            binding.tillName.error="firstname is required"
            error=true
        }
           if (Last.isBlank()){
               binding. tilLast.error="Lastname is required"
                error=true
            }
           if (Number.isBlank()){
               binding. tilLast.error="phoneNumber is required"
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
           if (!error){
               var registerRequest=RegisterRequest(name, Last, Password,Email,Number)
           userViewModel.registerUser(registerRequest)
           }
    }

    override fun onResume() {
        super.onResume()
        userViewModel.registerResponseLiveData.observe(this, Observer { RegisterResponse->
            Toast.makeText(baseContext,RegisterResponse.message,Toast.LENGTH_LONG).show()
            startActivity(Intent(this,LogInActivity::class.java))
        })
        userViewModel.registererrorLiveData.observe(this, Observer { error->
            Toast.makeText(baseContext,error,Toast.LENGTH_LONG).show()
        })
    }
}