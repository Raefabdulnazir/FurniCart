package com.example.furnicart

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.text.method.HideReturnsTransformationMethod
import android.text.method.PasswordTransformationMethod
import android.widget.Button
import android.widget.EditText
import android.widget.TextView
import android.widget.Toast
import com.google.firebase.auth.FirebaseAuth

class LoginActivity : AppCompatActivity() {
    private lateinit var etEmail: EditText
    private lateinit var etPass: EditText
    private lateinit var btnLogin: Button
    private lateinit var notRegisteredTextView: TextView
    private lateinit var auth: FirebaseAuth

    private var isPasswordVisible: Boolean = false
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_login2)

        // View Bindings
        etEmail = findViewById(R.id.editTextTextEmailAddress3)
        etPass = findViewById(R.id.editTextTextPassword)
        btnLogin = findViewById(R.id.loginBtn)
        notRegisteredTextView = findViewById(R.id.notRegisteredTextView)

        // Initializing the auth object
        auth = FirebaseAuth.getInstance()

        // Centering the card view
        /*val cardView = findViewById<androidx.cardview.widget.CardView>(R.id.cardView)
        val params = cardView.layoutParams as androidx.constraintlayout.widget.ConstraintLayout.LayoutParams
        params.horizontalBias = 0.5f // Setting horizontal bias to the center
        cardView.layoutParams = params*/

        //Toggle password
        etPass.transformationMethod = PasswordTransformationMethod.getInstance()//hide password by default
        etPass.setOnTouchListener { _, event ->
            val DRAWABLE_RIGHT = 2
            if (event.action == android.view.MotionEvent.ACTION_UP) {
                if (event.rawX >= (etPass.right - etPass.compoundDrawables[DRAWABLE_RIGHT].bounds.width())) {
                    isPasswordVisible = !isPasswordVisible
                    if (isPasswordVisible) {
                        etPass.transformationMethod = HideReturnsTransformationMethod.getInstance()
                        etPass.setCompoundDrawablesWithIntrinsicBounds(
                            0,
                            0,
                            R.drawable.password_icon,
                            0
                        )
                    } else {
                        etPass.transformationMethod = PasswordTransformationMethod.getInstance()
                        etPass.setCompoundDrawablesWithIntrinsicBounds(
                            0,
                            0,
                            R.drawable.password_icon,
                            0
                        )

                    }
                    return@setOnTouchListener true
                }
            }
            false
        }


        btnLogin.setOnClickListener {
            loginUser()
        }

        notRegisteredTextView.setOnClickListener {
            val intent = Intent(this, SignupActivity::class.java)
            startActivity(intent)
        }
    }

    private fun loginUser() {
        val email = etEmail.text.toString()
        val pass = etPass.text.toString()

        // Email and password validation
        if (email.isBlank() || pass.isBlank()) {
            Toast.makeText(this, "Email and password cannot be blank", Toast.LENGTH_SHORT).show()
            return
        }

        // Firebase user login
        auth.signInWithEmailAndPassword(email, pass).addOnCompleteListener(this) { task ->
            if (task.isSuccessful) {
                Toast.makeText(this, "Login successful", Toast.LENGTH_SHORT).show()
                // You might add further actions here upon successful login
                finish()
            } else {
                // Handle login failure
                Toast.makeText(this, "Login failed: ${task.exception?.message}", Toast.LENGTH_SHORT).show()
            }
        }
    }
}
