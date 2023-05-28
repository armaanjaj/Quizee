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

                // add value of the user's name to the key 'user_name' so that other activities can get it's value
                intent.putExtra(Constants.USER_NAME, userName.text.toString())

                startActivity(intent)
                finish()
            }
        }
    }
}