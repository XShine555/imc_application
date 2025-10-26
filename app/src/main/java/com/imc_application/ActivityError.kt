package com.imc_application

import android.content.Intent
import android.os.Bundle
import android.widget.Button
import androidx.appcompat.app.AppCompatActivity

class ActivityError : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_error)
        val username = intent.getStringExtra("username");

        val goBackError: Button = findViewById(R.id.goBackError)
        goBackError.setOnClickListener {
            val intent = Intent(this, ActivityStart::class.java)
            intent.putExtra("username", username)
            startActivity(intent)
        }
    }
}