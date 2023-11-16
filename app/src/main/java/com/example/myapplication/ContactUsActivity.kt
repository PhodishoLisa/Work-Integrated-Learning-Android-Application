package com.example.myapplication

import android.content.Intent
import android.net.Uri
import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import com.example.myapplication.databinding.ActivityContactUsBinding
import com.google.firebase.auth.FirebaseAuth

class ContactUsActivity : AppCompatActivity() {
    private lateinit var firebaseAuth: FirebaseAuth
    private lateinit var binding: ActivityContactUsBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityContactUsBinding.inflate(layoutInflater)
        setContentView(binding.root)

        firebaseAuth = FirebaseAuth.getInstance()

        binding.button11.setOnClickListener {
            // Create an Intent to navigate to SecondActivity
            val intent = Intent(this, HomeActivity::class.java)
            startActivity(intent)
        }

        binding.button12.setOnClickListener {
            // Create an Intent to navigate to SecondActivity
            val intent = Intent(this, AboutUsActivity::class.java)
            startActivity(intent)
        }

        binding.button13.setOnClickListener {
            // Create an Intent to navigate to SecondActivity
            val intent = Intent(this, ContactUsActivity::class.java)
            startActivity(intent)
        }
        binding.imageFacebook.setOnClickListener{
            val url = "https://www.facebook.com/Transnet-SOC-Ltd-140849535994869/"
            val intent = Intent(Intent.ACTION_VIEW, Uri.parse(url))
            startActivity(intent)
        }
        binding.imageEmail.setOnClickListener{
            val url = "enquiries@transnet.net"
            val intent = Intent(Intent.ACTION_VIEW, Uri.parse(url))
            startActivity(intent)
        }
        binding.imageTwitter.setOnClickListener{
            val url = "http://twitter.com/follow_transnet"
            val intent = Intent(Intent.ACTION_VIEW, Uri.parse(url))
            startActivity(intent)
        }
    }
}