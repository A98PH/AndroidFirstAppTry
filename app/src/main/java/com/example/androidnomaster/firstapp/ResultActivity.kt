package com.example.androidnomaster.firstapp

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.TextView
import com.example.androidnomaster.R

class ResultActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_result)
        val tvResult = findViewById<TextView>(R.id.tvResult)
        val tvResult2 = findViewById<TextView>(R.id.tvResult2)
        val name: String = intent.extras?.getString("EXTRA_NAME").orEmpty()

        if (name.all { it.isLetter()}) {
            tvResult.text = "Hola $name"
            }
        else if (name.all { it.isDigit() }) {
            tvResult.text = "H014 $name"
            }
        else {
            tvResult2.text = "Aquí ya no hacemos eso joven"
        }
    }
}