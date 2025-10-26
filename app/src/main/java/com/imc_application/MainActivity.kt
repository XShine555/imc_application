package com.imc_application

import android.content.Intent
import android.os.Build
import android.os.Bundle
import android.widget.Button
import android.widget.EditText
import android.widget.TextView
import androidx.activity.enableEdgeToEdge
import androidx.annotation.RequiresApi
import androidx.appcompat.app.AppCompatActivity
import androidx.core.view.ViewCompat
import androidx.core.view.WindowInsetsCompat
import java.time.LocalDateTime
import java.time.format.DateTimeFormatter

class MainActivity : AppCompatActivity() {
    @RequiresApi(Build.VERSION_CODES.O)
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        enableEdgeToEdge()
        setContentView(R.layout.activity_main)
        ViewCompat.setOnApplyWindowInsetsListener(findViewById(R.id.main)) { v, insets ->
            val systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars())
            v.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom)
            insets
        }

        val dateMessageView: TextView = findViewById(R.id.dateMessage);

        val currentDateTime = LocalDateTime.now()
        val dateTimeFormatPattern = DateTimeFormatter.ofPattern("dd/MM/yyyy")
        val dateTimeFormat = currentDateTime.format(dateTimeFormatPattern)

        dateMessageView.text = dateTimeFormat

        val accessButton: Button = findViewById(R.id.accessButton);
        val textInput: EditText = findViewById(R.id.userNameTextEdit)
        accessButton.setOnClickListener {
            val intent = Intent(this, ActivityStart::class.java)
            intent.putExtra("username", textInput.text.toString())
            startActivity(intent)
        }
    }
}