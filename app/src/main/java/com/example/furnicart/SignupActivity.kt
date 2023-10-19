package com.example.furnicart

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Button
import android.widget.EditText
import android.widget.TextView
import android.widget.Toast
import com.google.firebase.Firebase
import com.google.firebase.auth.FirebaseAuth
import com.google.firebase.auth.auth

class SignupActivity : AppCompatActivity() {
    lateinit var etEmail: EditText
    lateinit var etConfPass: EditText
    private lateinit var etPass: EditText
    private lateinit var btnSignUp: Button
    private lateinit var auth:FirebaseAuth
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_signup)

        //View Bindings
        etEmail = findViewById(R.id.editTextTextEmailAddress3)
        etConfPass = findViewById(R.id.editTextTextConfirmPassword)
        etPass = findViewById(R.id.editTextTextPassword)
        btnSignUp = findViewById(R.id.signUpBtn)

        val alreadyHaveAnAccountTextView = findViewById<TextView>(R.id.aldreadyHaveAnAccountTextView)
        alreadyHaveAnAccountTextView.setOnClickListener {
            val intent = Intent(this, LoginActivity::class.java)
            startActivity(intent)
        }

        //initialising auth object
        auth = Firebase.auth
        btnSignUp.setOnClickListener{
            signUpUser()
        }
    }

    private fun signUpUser(){
        val email = etEmail.text.toString()
        val pass = etPass.text.toString()
        val confirmPass = etConfPass.text.toString()

        //check pass
        if(email.isBlank()||pass.isBlank()||confirmPass.isBlank()){
            Toast.makeText(this,"Email and password cannot be blank",Toast.LENGTH_SHORT).show()
            return
        }

        if(pass!=confirmPass){
            Toast.makeText(this,"Password and Confirm password do not match",Toast.LENGTH_SHORT).show()
            return
        }

        auth.createUserWithEmailAndPassword(email,pass).addOnCompleteListener(this){
            if(it.isSuccessful){
                Toast.makeText(this,"Successfully signed up",Toast.LENGTH_SHORT).show()
                finish()
            } else {
                Toast.makeText(this,"Signed up failed",Toast.LENGTH_SHORT).show()
            }
        }
    }

}