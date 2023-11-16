package com.example.myapplication

import android.content.Intent
import android.net.Uri
import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import com.example.myapplication.databinding.ActivityServicesBinding
import com.google.firebase.auth.FirebaseAuth

class ServicesActivity : AppCompatActivity() {
    private lateinit var binding: ActivityServicesBinding
    private lateinit var firebaseAuth: FirebaseAuth

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityServicesBinding.inflate(layoutInflater)
        setContentView(binding.root)

        firebaseAuth = FirebaseAuth.getInstance()

        binding.buttonBusWitUs.setOnClickListener {
            val intent = Intent(this, Business_With_Us::class.java)
            startActivity(intent)
        }
        binding.buttonCONTACTUs.setOnClickListener {
            val intent = Intent(this, ContactUsActivity::class.java)
            startActivity(intent)
        }
        binding.ButtonHome.setOnClickListener {
            val intent = Intent(this, HomeActivity::class.java)
            startActivity(intent)
        }
        binding.TextPortsAuth.setOnClickListener {
            val url = "https://www.transnet.net/Divisions/Pages/NPAuthority.aspx"
            val intent = Intent(Intent.ACTION_VIEW, Uri.parse(url))
            startActivity(intent)

        }
        binding.TextTerminals.setOnClickListener {
            val url = "https://www.transnet.net/Divisions/Pages/TPT.aspx"
            val intent = Intent(Intent.ACTION_VIEW, Uri.parse(url))
            startActivity(intent)
        }
        binding.TextEngeneering.setOnClickListener {
            val url = "https://www.transnet.net/Divisions/Pages/RailEng.aspx"
            val intent = Intent(Intent.ACTION_VIEW, Uri.parse(url))
            startActivity(intent)
        }
        binding.TextMore.setOnClickListener {
            val url = "http://twitter.com/follow_transnet"
            val intent = Intent(Intent.ACTION_VIEW, Uri.parse(url))
            startActivity(intent)
        }
        binding.TextPipelines.setOnClickListener {
            val url = "https://www.transnet.net/Divisions/Pages/PipeLines.aspx"
            val intent = Intent(Intent.ACTION_VIEW, Uri.parse(url))
            startActivity(intent)
        }
        binding.TextFreightRail.setOnClickListener {
            val url = "https://www.transnet.net/Divisions/Pages/FreightRail.aspx"
            val intent = Intent(Intent.ACTION_VIEW, Uri.parse(url))
            startActivity(intent)
        }
    }
}