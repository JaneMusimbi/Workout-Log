package com.jane.workoutlog

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import androidx.fragment.app.Fragment
import androidx.fragment.app.FragmentContainer
import androidx.fragment.app.FragmentContainerView
import com.google.android.material.bottomnavigation.BottomNavigationItemView
import com.google.android.material.bottomnavigation.BottomNavigationView
import com.jane.workoutlog.databinding.ActivityHomeBinding
import com.jane.workoutlog.databinding.ActivitySignUpBinding

class HomeActivity : AppCompatActivity() {
   lateinit var binding: ActivityHomeBinding
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
       binding=ActivityHomeBinding.inflate(layoutInflater)
        setContentView(binding.root)

    }


    fun setupBottomNav(){
        binding.bottomNavigation.setOnItemSelectedListener {  item ->
            when(item.itemId){
                R.id.plan ->{
                    var  transaction=supportFragmentManager.beginTransaction()
                    transaction.replace(R.id.fcvHome,planFragment())
                    transaction.commit()
                    true

                }
                R.id.track ->{
                    supportFragmentManager.beginTransaction().replace(R.id.fcvHome,trackfragment()).commit()
                    true
                }
                R.id.profile ->{
                    supportFragmentManager.beginTransaction().replace(R.id.fcvHome,profileFragment()).commit()
                    true
                }
                else->false
        }

        }
    }

    }
