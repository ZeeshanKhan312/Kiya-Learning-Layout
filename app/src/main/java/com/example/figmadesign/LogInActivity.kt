package com.example.figmadesign

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.EditText
import android.widget.Toast
import androidx.appcompat.widget.AppCompatButton

class LogInActivity : AppCompatActivity() {
    lateinit var number: EditText
    lateinit var logIn:AppCompatButton
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_log_in)

        number=findViewById(R.id.number)
        logIn=findViewById(R.id.log_in)

        logIn.setOnClickListener{
            val num=number.text.toString()
            if(num.isNotEmpty()){
                startActivity(Intent(this@LogInActivity,VerificationPage::class.java))
                finish()
            }
            else
                Toast.makeText(this, "Enter Phone Number!!", Toast.LENGTH_SHORT).show()
        }

    }
}