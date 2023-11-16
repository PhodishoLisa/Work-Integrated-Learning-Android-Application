package com.example.myapplication

import android.content.Intent
import android.os.Bundle
import android.widget.Toast
import androidx.appcompat.app.AppCompatActivity
import com.example.myapplication.databinding.ActivityAddShipmentBinding
import com.google.firebase.FirebaseApp
import com.google.firebase.database.DatabaseReference
import com.google.firebase.database.FirebaseDatabase


class AddShipmentActivity : AppCompatActivity() {

    private lateinit var binding:ActivityAddShipmentBinding
   // private lateinit var firebaseAuth: FirebaseAuth
    private lateinit var database: DatabaseReference

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityAddShipmentBinding.inflate(layoutInflater)
        setContentView(binding.root)

        FirebaseApp.initializeApp(this)

        //firebaseAuth = FirebaseAuth.getInstance()

        binding.textView2.setOnClickListener{
            val intent = Intent(this, HomeActivity::class.java)
            startActivity(intent)
        }

        binding.BtnTrack.setOnClickListener{
            val intent = Intent(this, TrackShipmentActivity::class.java)
            startActivity(intent)
        }
        binding.BtnSubmit.setOnClickListener{
            val ID = binding.ETid.text.toString()
            val destination = binding.ETdestination.text.toString()
            val weight = binding.ETweight.text.toString()
            val method = binding.ETMethod.text.toString()
            val date = binding.ETDate.text.toString()

            database = FirebaseDatabase.getInstance().getReference("Shipment")
            val Shipments = ShipmentDetails(ID,destination,weight,method,date)
            database.child(ID).setValue(Shipments).addOnSuccessListener{
                binding.ETid.text.clear()
                binding.ETdestination.text.clear()
                binding.ETweight.text.clear()
                binding.ETMethod.text.clear()
                binding.ETDate.text.clear()

                Toast.makeText(this, "Shipment added successfully", Toast.LENGTH_SHORT).show()

            }.addOnFailureListener{
                Toast.makeText(this, "Shipment failure to load!!", Toast.LENGTH_SHORT).show()
            }


        }

    }
}