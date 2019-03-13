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

        val searchButton = findViewById<Button>(R.id.searchButton)
        val addButton = findViewById<Button>(R.id.addButton)
        val collectionButton = findViewById<Button>(R.id.collectionButton)

        searchButton.setOnClickListener {
            val toast = Toast.makeText(this, inProgress, Toast.LENGTH_LONG)
            toast.setGravity(Gravity.TOP or Gravity.CENTER_HORIZONTAL, 0, 180)
            toast.show()
        }

        addButton.setOnClickListener {
            intent = Intent(this, AddActivity::class.java)
            startActivity(intent)
        }

        collectionButton.setOnClickListener {
            val toast = Toast.makeText(this, inProgress, Toast.LENGTH_LONG)
            toast.setGravity(Gravity.TOP or Gravity.CENTER_HORIZONTAL, 0, 180)
            toast.show()
        }
    }
}
