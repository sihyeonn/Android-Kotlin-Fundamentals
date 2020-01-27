package com.example.diceroller

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Button
import android.widget.TextView
import android.widget.Toast

class MainActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        val rollButton: Button = findViewById(R.id.roll_button)
        rollButton.setOnClickListener({ rollDice() })

        val countUpButton: Button = findViewById(R.id.count_up_button)
        countUpButton.setOnClickListener({ countUpResult() })

        val resetButton: Button = findViewById(R.id.reset_button)
        resetButton.setOnClickListener({ resetResult() })
    }

    private fun rollDice() {
        Toast.makeText(this, "rollButton clicked.", Toast.LENGTH_SHORT).show()
        val randomInt = (1..6).random()
        val resultText: TextView = findViewById(R.id.result_text)
        resultText.text = randomInt.toString()
    }

    private fun countUpResult() {
        Toast.makeText(this, "countUpButton clicked.", Toast.LENGTH_SHORT).show()
        val resultText: TextView = findViewById(R.id.result_text)
        val resultTextStr = resultText.text.toString()
        if (resultTextStr == getString(R.string.welcome_msg)) {
            resultText.text = "1"
        } else {
            var resultInt = resultTextStr.toInt()
            if (resultInt < 6)
                resultText.text = (++resultInt).toString()
        }
    }

    private fun resetResult() {
        Toast.makeText(this, "resetButton clicked.", Toast.LENGTH_SHORT).show()
        val resultText: TextView = findViewById(R.id.result_text)
        resultText.text = 0.toString()
    }
}
