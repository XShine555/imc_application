package com.imc_application

import android.content.Intent
import android.os.Bundle
import android.widget.Button
import android.widget.TextView
import androidx.appcompat.app.AppCompatActivity

class ActivityStart : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_start)

        val helloUserText: TextView = findViewById(R.id.lastPageText);
        val username = intent.getStringExtra("username");

        helloUserText.text = "¡Bienvenido ${username}!"

        val number = (0..2).random()

        val firstButton: Button = findViewById(R.id.firstButton)
        val secondButton: Button = findViewById(R.id.secondButton)
        val thirdButton: Button = findViewById(R.id.thirdButton)
        val buttons = arrayOf(firstButton, secondButton, thirdButton)

        for (i in 0..2) {
            val current = buttons[i]
            current.setOnClickListener {
                val intent = if (number == i)
                    Intent(this, ActivitySuccess::class.java)
                else
                    Intent(this, ActivityError::class.java)
                intent.putExtra("username", username)
                startActivity(intent)
            }
        }

        val goBackStart: Button = findViewById(R.id.goBackStart)
        goBackStart.setOnClickListener {
            startActivity(Intent(this, MainActivity::class.java))
        }
    }
}
