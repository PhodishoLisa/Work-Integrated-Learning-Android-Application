package com.example.myapplication

import android.content.Intent
import android.os.Bundle
import android.util.Patterns
import android.widget.Toast
import androidx.appcompat.app.AppCompatActivity
import com.example.myapplication.databinding.ActivityResetPasswordBinding
import com.google.firebase.auth.FirebaseAuth
import com.google.firebase.auth.ktx.auth
import com.google.firebase.ktx.Firebase

class Reset_Password : AppCompatActivity() {
    private lateinit var auth: FirebaseAuth
    private lateinit var binding: ActivityResetPasswordBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        binding = ActivityResetPasswordBinding.inflate(layoutInflater)
        setContentView(binding.root)

        auth = Firebase.auth

        binding.resetPasswordBtn.setOnClickListener {
            val email = binding.editTextTextEmailAddress2.text.toString()
            if(checkEmail()){
                auth.sendPasswordResetEmail(email).addOnCompleteListener {
                    if(it.isSuccessful){
                        Toast.makeText(this, "Check your emails for password", Toast.LENGTH_SHORT).show()
                        val intent = Intent(this, LogInactivity::class.java)
                        startActivity(intent)
                        finish()
                    }

                }
            }

        }
    }

    private fun checkEmail(): Boolean {
        val email = binding.editTextTextEmailAddress2.text.toString()
        if (binding.editTextTextEmailAddress2.text.toString() == "") {
            binding.editTextTextEmailAddress2.error = "Input the correct email address"
            return false
        }
        if (!Patterns.EMAIL_ADDRESS.matcher(email).matches()) {
            binding.editTextTextEmailAddress2.error = "Check email format!!"
            return false
        }
        return true
    }
}