package com.jane.workoutlog

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import androidx.fragment.app.Fragment
import androidx.fragment.app.FragmentContainer
import androidx.fragment.app.FragmentContainerView
import com.google.android.material.bottomnavigation.BottomNavigationItemView
import com.google.android.material.bottomnavigation.BottomNavigationView

class HomeActivity : AppCompatActivity() {
    lateinit var bnvHome:BottomNavigationView
    lateinit var fcvHome:FragmentContainerView
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_home)
        CostViews()
        setupBottomNav()
    }

        fun CostViews(){
        bnvHome=findViewById(R.id.bottom_navigation)
        fcvHome=findViewById(R.id.fcvHome)}
    fun setupBottomNav(){
        bnvHome.setOnItemSelectedListener {  item ->
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
