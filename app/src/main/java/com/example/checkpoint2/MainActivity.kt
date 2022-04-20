package com.example.checkpoint2

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.TextView

class MainActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        fun navegar(){
            val intent = Intent(this, CarrinhoActivity::class.java)
            startActivity(intent)
        }
    }

}