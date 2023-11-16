package com.example.myapplication

import android.content.Intent
import android.net.Uri
import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import com.example.myapplication.databinding.ActivityBusinessWithUsBinding
import com.google.firebase.auth.FirebaseAuth

class Business_With_Us : AppCompatActivity() {
    private lateinit var binding:ActivityBusinessWithUsBinding
    private lateinit var firebaseAuth: FirebaseAuth

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityBusinessWithUsBinding.inflate(layoutInflater)
        setContentView(binding.root)

        firebaseAuth = FirebaseAuth.getInstance()


        binding.buttonAddShip.setOnClickListener{
            val intent = Intent(this, AddShipmentActivity::class.java)
            startActivity(intent)
        }
        binding.buttonHomeBus.setOnClickListener{
            val intent = Intent(this, HomeActivity::class.java)
            startActivity(intent)
        }
        binding.VisitWebsiteTextview.setOnClickListener{
            val url = "https://www.transnet.net/Pages/Home.aspx"
            val intent = Intent(Intent.ACTION_VIEW, Uri.parse(url))
            startActivity(intent)
        }
        binding.buttonContactUs.setOnClickListener{
            val intent = Intent(this, ContactUsActivity::class.java)
            startActivity(intent)
        }
        /* Find your TextView in the layout XML file
        val textView: TextView = findViewById(R.id.textView)

        // Set the text you want to display (including URLs)
        val textWithLink = "Visit our website: https://www.transnet.net/BusinessWithUs/Pages/BEE.aspx"

        // Set the text of the TextView
        textView.text = textWithLink

        // Make the link clickable
        Linkify.addLinks(textView, Linkify.WEB_URLS)
*/

    }
}