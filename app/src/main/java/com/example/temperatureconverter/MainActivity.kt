package com.example.temperatureconverter

import android.os.Bundle
import android.view.View
import android.widget.*
import androidx.appcompat.app.AppCompatActivity
import com.example.temperatureconverter.R
import kotlin.math.roundToInt

class MainActivity : AppCompatActivity() {
    private lateinit var tempInDegree: EditText
    private lateinit var calcButton: Button
    private lateinit var convertOption: RadioGroup
    private lateinit var roundUpSwitch: Switch
    private lateinit var amountText: TextView
    private var convertAmount: Float = 0.0f

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        tempInDegree = findViewById<EditText>(R.id.temp_in_degree)
        calcButton = findViewById<Button>(R.id.calculate_button)
        convertOption = findViewById<RadioGroup>(R.id.radioGroup)
        roundUpSwitch = findViewById<Switch>(R.id.round_up_switch)
        amountText = findViewById<TextView>(R.id.conv_result)

        calcButton.setOnClickListener(View.OnClickListener {
            val cost = tempInDegree.text.toString()
            val costAmount = cost.toFloat()
            when (convertOption.checkedRadioButtonId) {
                R.id.option_Fahrenheit -> convertAmount = (costAmount * 9 / 5 + 32)
                R.id.option_Kelvin -> convertAmount = (costAmount + 273.15).toFloat()
                R.id.option_Rankine -> convertAmount = ((costAmount + 273.15) * 9 / 5).toFloat()
                else -> convertAmount = convertAmount
            }

            //convertAmount = costAmount * convertPercentage;
            if (roundUpSwitch.isChecked) {
                convertAmount = convertAmount.roundToInt().toFloat()
            }
            amountText.text = "Result: ${convertAmount.toString()}"
        })
    }
}