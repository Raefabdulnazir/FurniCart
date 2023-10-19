package com.example.furnicart

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Button
import android.widget.EditText
import android.widget.TextView
import android.widget.Toast
import com.google.firebase.auth.FirebaseAuth

class LoginActivity : AppCompatActivity() {
    lateinit var etEmail : EditText
    private lateinit var etPass : EditText
    lateinit var btnLogin : Button

    lateinit var auth: FirebaseAuth
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_login2)

        btnLogin = findViewById(R.id.loginBtn)
        etEmail = findViewById(R.id.editTextTextEmailAddress3)
        etPass = findViewById(R.id.editTextTextConfirmPassword)

        btnLogin.setOnClickListener {
            login()
        }

        val notRegisteredTextView = findViewById<TextView>(R.id.notRegisteredTextView)
        notRegisteredTextView.setOnClickListener {
            val intent = Intent(this,SignupActivity::class.java)
            startActivity(intent)
        }
    }

    private fun login(){
        val email = etEmail.text.toString()
        val pass = etPass.text.toString()
        auth.signInWithEmailAndPassword(email,pass).addOnCompleteListener(this){
            if(it.isSuccessful){
                Toast.makeText(this,"Successfully LoggedIn",Toast.LENGTH_SHORT).show()
            }
            else{
                Toast.makeText(this,"Log in failed",Toast.LENGTH_SHORT).show()
            }
        }
    }
}