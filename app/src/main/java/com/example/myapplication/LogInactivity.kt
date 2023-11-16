package com.example.myapplication

import android.content.Intent
import android.os.Bundle
import android.util.Log
import android.util.Patterns
import android.widget.Button
import android.widget.Toast
import androidx.appcompat.app.AppCompatActivity
import com.example.myapplication.databinding.ActivityLogInactivityBinding
import com.google.firebase.auth.FirebaseAuth
import com.google.firebase.auth.ktx.auth
import com.google.firebase.ktx.Firebase

class LogInactivity : AppCompatActivity() {
    private lateinit var auth: FirebaseAuth
    private lateinit var binding: ActivityLogInactivityBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_log_inactivity)

        //set view binding
        binding = ActivityLogInactivityBinding.inflate(layoutInflater)
        setContentView(binding.root)

        auth = Firebase.auth

        binding.LogInButton.setOnClickListener{
            val email = binding.LogInEmail.text.toString()
            val password = binding.LogInPassword.text.toString()
            if(checkAllFields()){
                auth.signInWithEmailAndPassword(email, password).addOnCompleteListener{
                  if(it.isSuccessful){
                      Toast.makeText( this, "Successfully logged in!!", Toast.LENGTH_SHORT).show()
                      val buttonHome = findViewById<Button>(R.id.LogIn_Button)
                      buttonHome.setOnClickListener {
                          // Create an Intent to navigate to SecondActivity
                          val intent = Intent(this, HomeActivity::class.java)
                          startActivity(intent)
                          
                      }
                  }
                    else {
                        Log.e("Error", it.exception.toString())
                    }

                }
            }

        }
        binding.textViewCreateAccount.setOnClickListener{
            val intent = Intent(this, SignUpActivity::class.java)
            startActivity(intent)
            finish()
        }
        binding.textViewResetPassword.setOnClickListener{
            val intent = Intent(this, Reset_Password::class.java)
            startActivity(intent)
            finish()
        }

    }
    private fun checkAllFields(): Boolean {
        val email = binding.LogInEmail.text.toString()
        if (binding.LogInEmail.text.toString() == "") {
            binding.LogInEmail.error = "Input the correct email address"
            return false
        }
        if (!Patterns.EMAIL_ADDRESS.matcher(email).matches()) {
            binding.LogInEmail.error = "Check email format!!"
            return false
        }
        if(binding.LogInPassword.text.toString() == ""){
            binding.LogInPassword.error = "Input correct passowrd"
            return false
        }
        if(binding.LogInPassword.length() <= 6 ){
            binding.LogInPassword.error = "Password should be atleast 6 or more characters"

            return false
        }
        return true

    }
}