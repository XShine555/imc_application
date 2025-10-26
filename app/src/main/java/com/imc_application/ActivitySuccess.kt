package com.imc_application

import android.content.Intent
import android.os.Bundle
import android.widget.Button
import androidx.appcompat.app.AppCompatActivity

class ActivitySuccess : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_success)
        val username = intent.getStringExtra("username");

        val goBackCorrect: Button = findViewById(R.id.goBackCorrect);
        goBackCorrect.setOnClickListener {
            val intent = Intent(this, ActivityStart::class.java)
            intent.putExtra("username", username)
            startActivity(intent)
        }
    }
}