package com.example.androidlab1

import android.content.Intent
import android.support.v7.app.AppCompatActivity
import android.os.Bundle
import android.view.Gravity
import android.widget.Button
import android.widget.Toast

class MenuActivity : AppCompatActivity() {

    private val inProgress = "Work in progress"

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_menu)

        val buyButton = findViewById<Button>(R.id.buyButton)
        val sellButton = findViewById<Button>(R.id.sellButton)
        val auctionsButton = findViewById<Button>(R.id.auctionsButton)

        buyButton.setOnClickListener {
            val toast = Toast.makeText(this, inProgress, Toast.LENGTH_LONG)
            toast.setGravity(Gravity.TOP or Gravity.CENTER_HORIZONTAL, 0, 180)
            toast.show()
        }

        sellButton.setOnClickListener {
            val intent = Intent(this, SellActivity::class.java)
            startActivity(intent)
        }

        auctionsButton.setOnClickListener {
            val intent = Intent(this, AuctionsActivity::class.java)
            startActivity(intent)
        }
    }
}
