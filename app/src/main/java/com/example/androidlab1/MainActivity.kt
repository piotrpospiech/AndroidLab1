package com.example.androidlab1

import android.content.Intent
import android.graphics.Color
import android.support.v7.app.AppCompatActivity
import android.os.Bundle
import android.widget.Toast
import android.view.Gravity
import kotlinx.android.synthetic.main.activity_main.*


class MainActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        supportActionBar?.hide()

        var changedColor = false

        cardImageView.setOnLongClickListener {
            if (changedColor) cardImageView.setColorFilter(Color.rgb(0, 0, 0))
            else cardImageView.setColorFilter(Color.rgb(255, 255, 255))

            changedColor = !changedColor
            false
        }

        signInButton.setOnClickListener { 
            val toast = Toast.makeText(this, getString(R.string.wrongInputs), Toast.LENGTH_LONG)
            toast.setGravity(Gravity.TOP or Gravity.CENTER_HORIZONTAL, 0, 32)
            toast.show()
        }

        forgotTextView.setOnClickListener {
            val toast = Toast.makeText(this, getString(R.string.workInProgress), Toast.LENGTH_LONG)
            toast.setGravity(Gravity.TOP or Gravity.CENTER_HORIZONTAL, 0, 32)
            toast.show()
        }

        continueTextView.setOnClickListener {
            val intent = Intent(this, MenuActivity::class.java)
            startActivity(intent)
        }
    }
}
