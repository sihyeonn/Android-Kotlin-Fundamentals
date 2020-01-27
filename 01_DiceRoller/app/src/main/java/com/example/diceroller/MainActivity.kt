package com.example.diceroller

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Button
import android.widget.ImageView
import android.widget.Toast

class MainActivity : AppCompatActivity() {

    private lateinit var diceImages : List<ImageView>

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        diceImages = listOf(findViewById(R.id.dice_image), findViewById(R.id.dice_image2))

        val rollButton: Button = findViewById(R.id.roll_button)
        rollButton.setOnClickListener({ rollDice() })

        val resetButton: Button = findViewById(R.id.reset_button)
        resetButton.setOnClickListener({ resetResult() })
    }

    private fun rollDice() {
        Toast.makeText(this, "rollButton clicked.", Toast.LENGTH_SHORT).show()
        diceImages.forEach {
            var randomInt = (1..6).random()
            it.setImageResource(getDiceResource(randomInt))
        }
    }

    private fun resetResult() {
        Toast.makeText(this, "resetButton clicked.", Toast.LENGTH_SHORT).show()
        diceImages.forEach {
            it.setImageResource(getDiceResource(0))
        }
    }

    private fun getDiceResource(n: Int): Int {
        return when (n) {
            1 -> R.drawable.dice_1
            2 -> R.drawable.dice_2
            3 -> R.drawable.dice_3
            4 -> R.drawable.dice_4
            5 -> R.drawable.dice_5
            6 -> R.drawable.dice_6
            else -> R.drawable.empty_dice
        }
    }
}
