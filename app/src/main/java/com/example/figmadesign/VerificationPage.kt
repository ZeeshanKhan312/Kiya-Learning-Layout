package com.example.figmadesign

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.text.Editable
import android.text.TextWatcher
import android.widget.EditText
import android.widget.Toast
import androidx.appcompat.widget.AppCompatButton
import androidx.core.view.size
import androidx.core.widget.doOnTextChanged
import `in`.aabhasjindal.otptextview.OTPListener
import `in`.aabhasjindal.otptextview.OtpTextView

class VerificationPage : AppCompatActivity() {
    lateinit var otpView:OtpTextView
    lateinit var verifyBtn:AppCompatButton
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_verification_page)
        otpView=findViewById(R.id.otpView)
        verifyBtn=findViewById(R.id.verifyBtn)

        otpView.requestFocusOTP()

        otpView.otpListener= object : OTPListener {
            override fun onInteractionListener() {}

            override fun onOTPComplete(otp: String?) {
                if(otp?.length!!.equals(4)) {
                    startActivity(Intent(this@VerificationPage, LocationActivity::class.java))
                    finish()
                } else {
                    Toast.makeText(this@VerificationPage, "Incorrect otp", Toast.LENGTH_LONG).show()
                }
            }
        }

        verifyBtn.setOnClickListener{
            if(otpView.size==4){
                startActivity(Intent(this@VerificationPage, LocationActivity::class.java))
                finish()
            }
//            else if
            else
                Toast.makeText(this@VerificationPage, "Enter the whole OTP", Toast.LENGTH_SHORT).show()
        }


    }
}