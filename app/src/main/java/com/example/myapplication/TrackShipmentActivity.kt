package com.example.myapplication

import android.content.Intent
import android.os.Bundle
import android.widget.Toast
import androidx.appcompat.app.AppCompatActivity
import com.example.myapplication.databinding.ActivityTrackShipmentBinding
import com.google.firebase.database.DatabaseReference
import com.google.firebase.database.FirebaseDatabase

class TrackShipmentActivity : AppCompatActivity() {
    private lateinit var binding : ActivityTrackShipmentBinding
    private lateinit var database : DatabaseReference

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityTrackShipmentBinding.inflate(layoutInflater)
        setContentView(binding.root)

        binding.back.setOnClickListener{
            val intent = Intent(this, AddShipmentActivity::class.java)
            startActivity(intent)
        }
        binding.buttonSearch.setOnClickListener{

            val I_D : String = binding.editTextText.text.toString()
            if(I_D.isNotEmpty()){
                search(I_D)

            }else{
                Toast.makeText(this, "Enter valid id", Toast.LENGTH_SHORT).show()
            }

        }

    }

    private fun search(I_D: String) {
        database = FirebaseDatabase.getInstance().getReference("Shipment")
        database.child(I_D).get().addOnSuccessListener {
            if(it.exists()){
                val i_d = it.child("ID").value
                val dest = it.child("destination").value
                val weigh = it.child("weight").value
                val meth = it.child("method").value
                val dat = it.child("date").value

                binding.editTextText.text.clear()

                binding.id.text = i_d.toString()
                binding.destination.text = dest.toString()
                binding.weight.text = weigh.toString()
                binding.method.text = meth.toString()
                binding.date.text = dat.toString()

            }else{
                Toast.makeText(this, "Shipment does not exist. Enter another shipment ID.", Toast.LENGTH_SHORT).show()
            }
        }.addOnFailureListener{
            Toast.makeText(this, "Failed", Toast.LENGTH_SHORT).show()
        }

        }

    }
