package com.example.registrationapp

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Button

class YourInfoActivity : AppCompatActivity() {
    lateinit var btn:Button
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_your_info)
        btn=findViewById(R.id.Button03)

        btn.setOnClickListener{
            val intent = Intent(this,YourAdressActivity::class.java)
            startActivity(intent)
        }
    }
}