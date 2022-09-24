package com.jane.workoutlog.ui

import android.content.Intent
import android.content.SharedPreferences
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Patterns
import android.view.View
import android.widget.Toast
import androidx.activity.viewModels
import androidx.lifecycle.Observer
import com.jane.workoutlog.ViewModel.UserViewModel
import com.jane.workoutlog.api.ApiInterface
import com.jane.workoutlog.api.Apiclient
import com.jane.workoutlog.databinding.ActivityLogInBinding
import com.jane.workoutlog.models.LogInResponse
import com.jane.workoutlog.models.loginRequest
import retrofit2.Call
import retrofit2.Callback
import retrofit2.Response

class LogInActivity : AppCompatActivity() {
    lateinit var binding:ActivityLogInBinding
    lateinit var  sharedPrefs:SharedPreferences
    val userViewModel:UserViewModel by viewModels()


    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityLogInBinding.inflate(layoutInflater)
        setContentView(binding.root)
        castView()

        sharedPrefs = getSharedPreferences("WORKOUTLOG_PREFS", MODE_PRIVATE)

    }
        override fun onResume(){
            super.onResume()
            userViewModel.logInResponseLiveData.observe(this, Observer{LogInResponse->
            Toast.makeText(baseContext,LogInResponse?.message, Toast.LENGTH_LONG).show()
            saveLoginDetails(LogInResponse!!)
            startActivity(Intent(baseContext, HomeActivity::class.java))
        })
          userViewModel.errorLiveData.observe(this, Observer {errorMessage->
              Toast.makeText(baseContext,errorMessage,Toast.LENGTH_LONG).show()
          })
        }
    fun castView() {
        var error = false
        binding.tlPassword.error = null
        binding.tilEmail.error = null

        binding.tvSignup.setOnClickListener{
            startActivity(Intent(this, SignUpActivity::class.java))

        }
        binding.btnLogin.setOnClickListener{
            validateLogin()
            startActivity(Intent(this, HomeActivity::class.java))
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
           val loginRequest =loginRequest(email,password)
           binding.pblogin.visibility=View.VISIBLE

        }
    }

     fun saveLoginDetails(logInResponse:LogInResponse){
         val editor = sharedPrefs.edit()
         editor.putString("ACCES_TOKEN",logInResponse.accessToken)
         editor.putString("USER_ID",logInResponse.userId)
         editor.putString("PROFILE_ID",logInResponse.profileId)
         editor.apply()
     }
    }

