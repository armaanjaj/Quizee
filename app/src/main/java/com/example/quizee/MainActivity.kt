package com.example.quizee

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Button
import android.widget.EditText
import android.widget.Toast

class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        val btnGo: Button = findViewById(R.id.btn_go)
        val userName: EditText = findViewById(R.id.main_userName)
        btnGo.setOnClickListener {
            if(userName.text.isEmpty())
                Toast.makeText(this, "Please enter your name to start", Toast.LENGTH_SHORT).show()
            else {
                val intent = Intent(this, QuizQuestionsActivity::class.java)
                startActivity(intent)
                finish()
            }
        }
    }
}