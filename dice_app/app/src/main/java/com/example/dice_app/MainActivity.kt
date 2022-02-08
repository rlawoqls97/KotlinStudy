package com.example.dice_app

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import androidx.databinding.DataBindingUtil
import com.example.dice_app.databinding.ActivityMainBinding
import kotlin.random.Random

class MainActivity : AppCompatActivity() {

    private lateinit var binding : ActivityMainBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)


        val diceImg1 = binding.dice1
        val diceImg2 = binding.dice2
        binding = DataBindingUtil.setContentView(this, R.layout.activity_main)
        binding.diceStartBtn.setOnClickListener {

            val number1 = Random.nextInt(1, 6)
            val number2 = Random.nextInt(1, 6)
            when(number1) {
                1 -> diceImg1.setImageResource(R.drawable.dice_1)
                2 -> diceImg1.setImageResource(R.drawable.dice_2)
                3 -> diceImg1.setImageResource(R.drawable.dice_3)
                4 -> diceImg1.setImageResource(R.drawable.dice_4)
                5 -> diceImg1.setImageResource(R.drawable.dice_5)
                6 -> diceImg1.setImageResource(R.drawable.dice_6)
            }
            when(number2) {
                1 -> diceImg2.setImageResource(R.drawable.dice_1)
                2 -> diceImg2.setImageResource(R.drawable.dice_2)
                3 -> diceImg2.setImageResource(R.drawable.dice_3)
                4 -> diceImg2.setImageResource(R.drawable.dice_4)
                5 -> diceImg2.setImageResource(R.drawable.dice_5)
                6 -> diceImg2.setImageResource(R.drawable.dice_6)
            }



        }
    }
}