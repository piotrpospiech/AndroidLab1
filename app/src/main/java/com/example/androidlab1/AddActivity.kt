package com.example.androidlab1

import android.support.v7.app.AppCompatActivity
import android.os.Bundle
import android.view.Gravity
import android.view.View
import android.widget.*

class AddActivity : AppCompatActivity(), AdapterView.OnItemSelectedListener {

    var text = ""

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_add)

        val expansionsSpinner = findViewById<Spinner>(R.id.expansionsSpinner)
        val adapter = ArrayAdapter.createFromResource(this, R.array.expansions, android.R.layout.simple_spinner_item)
        adapter.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item)
        expansionsSpinner.adapter = adapter
        expansionsSpinner.onItemSelectedListener = this

        val cardNameEditText = findViewById<EditText>(R.id.cardNameEditText)
        val quantityRadioGroup = findViewById<RadioGroup>(R.id.quantityRadioGroup)
        val promoCheckBox = findViewById<CheckBox>(R.id.promoCheckBox)
        val foilCheckBox = findViewById<CheckBox>(R.id.foilCheckBox)

        val backButton = findViewById<Button>(R.id.backButton)
        val addButton = findViewById<Button>(R.id.addButton)

        backButton.setOnClickListener {
            onBackPressed()
        }

        addButton.setOnClickListener {
            val radioId = quantityRadioGroup.checkedRadioButtonId

            val cardName = cardNameEditText.text.toString()
            val quantity = findViewById<RadioButton>(radioId).text.toString()
            val promo = if (promoCheckBox.isChecked) "Yes" else "No"
            val foil = if (foilCheckBox.isChecked) "Yes" else "No"

            val cardInfo = "Card: $cardName, Quantity: $quantity, Promo: $promo, Foil: $foil, Expansion: $text"
            val toast = Toast.makeText(this, cardInfo, Toast.LENGTH_LONG)
            toast.setGravity(Gravity.TOP or Gravity.CENTER_HORIZONTAL, 0, 32)
            toast.show()
        }
    }

    override fun onItemSelected(parent: AdapterView<*>?, view: View?, position: Int, id: Long) {
        text = parent?.getItemAtPosition(position).toString()
    }

    override fun onNothingSelected(parent: AdapterView<*>?) {
        text = parent?.getItemAtPosition(0).toString()
    }
}
