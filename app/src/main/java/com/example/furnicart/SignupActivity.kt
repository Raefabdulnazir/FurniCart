package com.example.furnicart

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Button
import android.widget.EditText
import android.widget.TextView
import android.widget.Toast
import com.google.firebase.auth.FirebaseAuth

class SignupActivity : AppCompatActivity() {
    private lateinit var etEmail: EditText
    private lateinit var etConfPass: EditText
    private lateinit var etPass: EditText
    private lateinit var btnSignUp: Button
    private lateinit var auth: FirebaseAuth

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_signup)

        // View Bindings
        etEmail = findViewById(R.id.editTextTextEmailAddress3)
        etConfPass = findViewById(R.id.editTextTextConfirmPassword)
        etPass = findViewById(R.id.editTextTextPassword)
        btnSignUp = findViewById(R.id.signUpBtn)

        val alreadyHaveAnAccountTextView = findViewById<TextView>(R.id.aldreadyHaveAnAccountTextView)
        alreadyHaveAnAccountTextView.setOnClickListener {
            val intent = Intent(this, LoginActivity::class.java)
            startActivity(intent)
        }

        // Initializing the auth object
        auth = FirebaseAuth.getInstance()

        btnSignUp.setOnClickListener {
            signUpUser()
        }
    }

    private fun signUpUser() {
        val email = etEmail.text.toString()
        val pass = etPass.text.toString()
        val confirmPass = etConfPass.text.toString()

        // Email and password validation
        if (email.isBlank() || pass.isBlank() || confirmPass.isBlank()) {
            Toast.makeText(this, "Email and password cannot be blank", Toast.LENGTH_SHORT).show()
            return
        }

        if (pass != confirmPass) {
            Toast.makeText(this, "Password and Confirm password do not match", Toast.LENGTH_SHORT).show()
            return
        }

        // Firebase user sign-up
        auth.createUserWithEmailAndPassword(email, pass).addOnCompleteListener(this) { task ->
            if (task.isSuccessful) {
                Toast.makeText(this, "Successfully signed up", Toast.LENGTH_SHORT).show()
                // You might add further actions here upon successful signup
                finish()
            } else {
                // Handle sign-up failure
                Toast.makeText(this, "Sign up failed: ${task.exception?.message}", Toast.LENGTH_SHORT).show()
            }
        }
    }
}
