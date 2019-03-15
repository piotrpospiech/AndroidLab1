package com.example.androidlab1

import android.content.Intent
import android.support.v7.app.AppCompatActivity
import android.os.Bundle
import android.view.Gravity
import android.widget.Toast
import kotlinx.android.synthetic.main.activity_menu.*

class MenuActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_menu)

        searchButton.setOnClickListener {
            val toast = Toast.makeText(this, getString(R.string.workInProgress), Toast.LENGTH_LONG)
            toast.setGravity(Gravity.TOP or Gravity.CENTER_HORIZONTAL, 0, 180)
            toast.show()
        }

        addButton.setOnClickListener {
            intent = Intent(this, AddActivity::class.java)
            startActivity(intent)
        }

        collectionButton.setOnClickListener {
            val toast = Toast.makeText(this, getString(R.string.workInProgress), Toast.LENGTH_LONG)
            toast.setGravity(Gravity.TOP or Gravity.CENTER_HORIZONTAL, 0, 180)
            toast.show()
        }
    }
}
