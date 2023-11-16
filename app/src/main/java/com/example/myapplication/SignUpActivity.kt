package com.example.myapplication

import android.content.Intent
import android.os.Bundle
import android.util.Patterns
import android.widget.Toast
import androidx.appcompat.app.AppCompatActivity
import com.example.myapplication.databinding.ActivitySignUpBinding
import com.google.firebase.auth.FirebaseAuth
import com.google.firebase.auth.ktx.auth
import com.google.firebase.database.FirebaseDatabase
import com.google.firebase.ktx.Firebase

class SignUpActivity : AppCompatActivity() {
    private lateinit var auth : FirebaseAuth
    private lateinit var firebaseAuth: FirebaseAuth
    private lateinit var binding : ActivitySignUpBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        // Setting view binding
        //https://www.youtube.com/watch?v=RW9Fe0xDN1M&list=PLvwAoqlxB7bli9fbTrb-Y3WNGeb6DPVeD
        binding = ActivitySignUpBinding.inflate(layoutInflater)
        setContentView(binding.root)

        //Authenticate firebase
        auth = Firebase.auth
        firebaseAuth = FirebaseAuth.getInstance()

        binding.buttonLogin.setOnClickListener {
            startActivity(Intent(this, LogInactivity::class.java))
        }
        binding.buttonSignUp.setOnClickListener {
         validateData()
        }
    }
    private var name=""
    private var email=""
    private var password=""
    private fun  validateData(){
        name= binding.ETextName.text.toString().trim()
        email= binding.ETextEmail.text.toString().trim()
        password= binding.ETextPass.text.toString().trim()
        val cPassword= binding.ETextConfirm.text.toString().trim()

        if (name.isEmpty()){
            Toast.makeText(this,"Enter your name....", Toast.LENGTH_SHORT).show()
        }
        else if (!Patterns.EMAIL_ADDRESS.matcher(email).matches()){
            Toast.makeText(this,"Invalid email pattern....", Toast.LENGTH_SHORT).show()
        }
        else if (password.isEmpty()){
            Toast.makeText(this,"Enter Password....", Toast.LENGTH_SHORT).show()
        }
        else if (cPassword.isEmpty()){
            Toast.makeText(this,"Confirm Password....", Toast.LENGTH_SHORT).show()
        }
        else if (password!=cPassword){
            Toast.makeText(this,"Password doesn't match....", Toast.LENGTH_SHORT).show()
        }
        else{
            createUserAccount()
        }
    }

    private fun createUserAccount() {
        firebaseAuth.createUserWithEmailAndPassword(email,password)
            .addOnSuccessListener {
                updateUserInfo()


            }
            .addOnFailureListener {e->

                Toast.makeText(this,"Failed to create account due to ${e.message}", Toast.LENGTH_SHORT).show()
            }
    }

    private fun updateUserInfo() {


        val timestamp = System.currentTimeMillis()

        val uid = firebaseAuth.uid

        val hashMap: HashMap<String, Any?> = HashMap()
        hashMap["uid"]=uid
        hashMap["email"]=email
        hashMap["name"]=name
        hashMap["userType"]="user"
        hashMap["timestamp"]= timestamp

        val ref = FirebaseDatabase.getInstance().getReference("Users")
        ref.child(uid!!)
            .setValue(hashMap)
            .addOnSuccessListener {

                Toast.makeText(this,"Account created...", Toast.LENGTH_SHORT).show()
                startActivity(Intent(this@SignUpActivity,LogInactivity::class.java))


            }
            .addOnFailureListener {e->

                Toast.makeText(this,"Failed to save user info due to ${e.message}", Toast.LENGTH_SHORT).show()
            }
    }


    }


