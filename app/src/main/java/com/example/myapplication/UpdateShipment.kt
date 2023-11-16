package com.example.myapplication

import android.content.Intent
import android.os.Bundle
import android.widget.Toast
import androidx.appcompat.app.AppCompatActivity
import com.example.myapplication.databinding.ActivityUpdateShipmentBinding
import com.google.firebase.database.DatabaseReference
import com.google.firebase.database.FirebaseDatabase

class UpdateShipment : AppCompatActivity() {
    private lateinit var binding: ActivityUpdateShipmentBinding
    private lateinit var database: DatabaseReference

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityUpdateShipmentBinding.inflate(layoutInflater)
        setContentView(binding.root)

        binding.buttonTrack.setOnClickListener{
            val intent = Intent(this, TrackShipmentActivity::class.java)
            startActivity(intent)
        }
        binding.ButtonUpdate.setOnClickListener {
            val ID = binding.editTextText2.text.toString()
            val destination = binding.editTextText3.text.toString()
            val weight = binding.editTextText4.text.toString()
            val method = binding.editTextText5.text.toString()
            val date = binding.editTextText6.text.toString()

            updateShipment(ID, destination, weight, method, date)
        }
    }

    private fun updateShipment(
        ID: String,
        destination: String,
        weight: String,
        method: String,
        date: String
    ) {
       database= FirebaseDatabase.getInstance().getReference("Shipment")
        val ships = mapOf<String,String>(
            "id" to ID,
            "destination" to destination,
            "weight" to weight,
            "method" to method,
            "date" to date
        )
database.child(ID).updateChildren(ships).addOnSuccessListener {
    binding.editTextText2.text.clear()
    binding.editTextText3.text.clear()
    binding.editTextText4.text.clear()
    binding.editTextText5.text.clear()
    binding.editTextText6.text.clear()
}.addOnFailureListener{
    Toast.makeText(this, "failed to update details", Toast.LENGTH_SHORT).show()

        }
    }
}