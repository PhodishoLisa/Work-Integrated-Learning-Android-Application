package com.example.myapplication

import android.content.Intent
import android.net.Uri
import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import com.example.myapplication.databinding.ActivityAboutUsBinding
import com.google.firebase.auth.FirebaseAuth

class AboutUsActivity : AppCompatActivity() {
    private lateinit var binding : ActivityAboutUsBinding
    private lateinit var firebaseAuth: FirebaseAuth

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityAboutUsBinding.inflate(layoutInflater)
        setContentView(binding.root)

        firebaseAuth = FirebaseAuth.getInstance()

        binding.VisitWebsiteTextview.setOnClickListener{
            val url = "https://www.transnet.net/Pages/Home.aspx"
            val intent = Intent(Intent.ACTION_VIEW, Uri.parse(url))
            startActivity(intent)
        }

        binding.buttonHome.setOnClickListener{
            val intent = Intent(this, HomeActivity::class.java)
            startActivity(intent)
        }
        binding.buttonServices.setOnClickListener{
            val intent = Intent(this, ServicesActivity::class.java)
            startActivity(intent)
        }
    }
}