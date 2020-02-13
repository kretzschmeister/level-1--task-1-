package com.example.higherlower

import android.app.Activity
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.TextView
import android.widget.Toast
import androidx.annotation.IdRes
import kotlinx.android.synthetic.main.activity_higher_lower.*

class HigherLowerActivity : AppCompatActivity() {

    private var currentThrow: Int = 1
    private var lastThrow: Int = 1


    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_higher_lower)
        initViews()
    }

    /*init state UI */
    private fun initViews(){
        btnLower.setOnClickListener {onLowerClick()}
        btnEquals.setOnClickListener{onEqualClick()}
        btnHigher.setOnClickListener {onHigherClick()}
        updateUI()
    }

    fun updateUI(){
tvLastThrow.text= getString(R.string.lastThrow, lastThrow)
        when (currentThrow) {
            1 -> ivDice.setImageResource(R.drawable.dice1)
            2 -> ivDice.setImageResource(R.drawable.dice2)
            3 -> ivDice.setImageResource(R.drawable.dice3)
            4 -> ivDice.setImageResource(R.drawable.dice4)
            5 -> ivDice.setImageResource(R.drawable.dice5)
            6 -> ivDice.setImageResource(R.drawable.dice6)
        }
    }

    private fun rollDice(){
        lastThrow = currentThrow
        currentThrow = (1..6).random()
        updateUI()
    }
    private fun onAnswerCorrect(){
        Toast.makeText(this, getString(R.string.correct),Toast.LENGTH_LONG).show()
        //toast message correct
    }
    private fun onAnswerInCorrect(){
        Toast.makeText(this, getString(R.string.incorrect),Toast.LENGTH_LONG).show()
        //toast message incorrect
    }
    private fun onHigherClick(){
        rollDice()
        if (lastThrow < currentThrow)onAnswerCorrect()
        else onAnswerInCorrect()
        //checkifcorrect
    }
    private fun onLowerClick(){
        rollDice()
        if(lastThrow > currentThrow)onAnswerInCorrect()
        else onAnswerCorrect()
    }
    private fun onEqualClick(){
        if(lastThrow == currentThrow)onAnswerCorrect()
        else onAnswerInCorrect()
    }


}
