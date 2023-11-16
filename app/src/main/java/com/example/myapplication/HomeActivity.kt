package com.example.myapplication

import android.content.Intent
import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import com.example.myapplication.databinding.ActivityHomeBinding
import com.google.firebase.auth.FirebaseAuth

class HomeActivity : AppCompatActivity() {
    private lateinit var binding:ActivityHomeBinding
    private lateinit var firebaseAuth: FirebaseAuth

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityHomeBinding.inflate(layoutInflater)
        setContentView(binding.root)

        firebaseAuth = FirebaseAuth.getInstance()

        binding.button7.setOnClickListener{
            val intent = Intent(this, AboutUsActivity::class.java)
            startActivity(intent)
        }

       binding.buttonServicesHome.setOnClickListener{
           val intent = Intent(this, ServicesActivity::class.java)
           startActivity(intent)
       }

        binding.buttonContactHome.setOnClickListener{
            val intent = Intent(this, ContactUsActivity::class.java)
            startActivity(intent)
        }
    }
}