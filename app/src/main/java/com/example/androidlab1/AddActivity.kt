package com.example.androidlab1

import android.support.v7.app.AppCompatActivity
import android.os.Bundle
import android.view.Gravity
import android.view.View
import android.widget.*
import kotlinx.android.synthetic.main.activity_add.*
import java.lang.StringBuilder

class AddActivity : AppCompatActivity(), AdapterView.OnItemSelectedListener {

    private lateinit var text: String

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_add)

        val adapter = ArrayAdapter.createFromResource(this, R.array.expansions, android.R.layout.simple_spinner_item)
        adapter.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item)
        expansionsSpinner.adapter = adapter
        expansionsSpinner.onItemSelectedListener = this

        backButton.setOnClickListener {
            onBackPressed()
        }

        addButton.setOnClickListener {
            val radioId = quantityRadioGroup.checkedRadioButtonId
            val cardName = cardNameEditText.text.toString()
            val quantity = findViewById<RadioButton>(radioId).text.toString()
            val promo = if (promoCheckBox.isChecked) getString(R.string.yes) else getString(R.string.no)
            val foil = if (foilCheckBox.isChecked) getString(R.string.yes) else getString(R.string.no)

            val toastInfo = makeToastInfo(cardName, quantity, promo, foil)
            val toast = Toast.makeText(this, toastInfo, Toast.LENGTH_SHORT)
            toast.setGravity(Gravity.TOP or Gravity.CENTER_HORIZONTAL, 0, 32)
            toast.show()
        }
    }

    private fun makeToastInfo(cardName: String, quantity: String, promo: String, foil: String): StringBuilder {
        val toastInfo = StringBuilder("")

        if (cardName.isNotBlank()) {
            val cardInfoList = mutableListOf("${getString(R.string.cardWithColon)} $cardName",
                "${getString(R.string.quantityWithColon)} $quantity",
                "${getString(R.string.promoWithColon)} $promo",
                "${getString(R.string.foilWithColon)} $foil",
                "${getString(R.string.expansionWithColon)} $text")

            for (i in cardInfoList)
                toastInfo.append(i)
                         .append(getString(R.string.comma))
                         .append(getString(R.string.spaceBlank))
        }
        else toastInfo.append(getString(R.string.noCardName))
        return toastInfo
    }

    override fun onItemSelected(parent: AdapterView<*>?, view: View?, position: Int, id: Long) {
        text = parent?.getItemAtPosition(position).toString()
    }

    override fun onNothingSelected(parent: AdapterView<*>?) {
        text = parent?.getItemAtPosition(0).toString()
    }
}
