package com.jane.workoutlog.ui

import android.content.Intent
import android.content.SharedPreferences
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import com.jane.workoutlog.R
import com.jane.workoutlog.databinding.ActivityHomeBinding

class HomeActivity : AppCompatActivity() {
   lateinit var binding: ActivityHomeBinding
    lateinit var  sharedPrefs: SharedPreferences
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
       binding=ActivityHomeBinding.inflate(layoutInflater)
        setContentView(binding.root)
        setupBottomNav()

        binding.tvLogout.setOnClickListener {
            sharedPrefs = getSharedPreferences("WORKOUTLOG_PREFS", MODE_PRIVATE)
            val editor=sharedPrefs.edit()
            editor.putString("ACCESS_TOKEN", "")
            editor.putString("USER_ID", "")
            editor.putString("PROFILE_ID", "")
            editor.apply()
            startActivity(Intent(this,LogInActivity::class.java))
            finish()
        }


    }


    fun setupBottomNav(){
        binding.bottomNavigation.setOnItemSelectedListener {  item ->
            when(item.itemId){
                R.id.plan ->{
                    var  transaction=supportFragmentManager.beginTransaction()
                    transaction.replace(R.id.fcvHome, planFragment())
                    transaction.commit()
                    true

                }
                R.id.track ->{
                    supportFragmentManager.beginTransaction().replace(R.id.fcvHome, trackfragment()).commit()
                    true
                }
                R.id.profile ->{
                    supportFragmentManager.beginTransaction().replace(
                        R.id.fcvHome,
                        profileFragment()
                    ).commit()
                    true
                }
                else->false
        }

        }
    }

    }
