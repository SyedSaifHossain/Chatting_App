package com.example.chattingapp

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import com.example.chattingapp.databinding.ActivityOtpBinding
import com.example.chattingapp.databinding.ActivityVerificationBinding
import com.google.firebase.auth.FirebaseAuth

class VerificationActivity : AppCompatActivity() {
    private lateinit var binding: ActivityVerificationBinding
    var auth: FirebaseAuth?= null
    override fun onCreate(savedInstanceState: Bundle?) {
        binding = ActivityVerificationBinding.inflate(layoutInflater)
        super.onCreate(savedInstanceState)
        setContentView(binding.root)

        auth = FirebaseAuth.getInstance()
        if(auth!!.currentUser!=null){
            startActivity(Intent(this@VerificationActivity, MainActivity::class.java))
            finish()
        }

        binding.otpText.requestFocus()
        binding.continueBtn.setOnClickListener {
            var intent = Intent(this@VerificationActivity, OtpActivity::class.java)
            intent.putExtra("phoneNumber", binding.otpText.text.toString())
            startActivity(intent)
        }

    }
}