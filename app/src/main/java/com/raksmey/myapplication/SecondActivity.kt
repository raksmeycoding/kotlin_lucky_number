package com.raksmey.myapplication

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Button
import android.widget.TextView
import java.util.Random

class SecondActivity : AppCompatActivity() {


    private lateinit var luckyNumberTextView: TextView
    private lateinit var btnShareLuckyNumber: Button


    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_second)

        luckyNumberTextView = findViewById(R.id.id_this_is_lucky_number)
        btnShareLuckyNumber = findViewById(R.id.id_share_lucky_number)


        // receive data from activity
        val i = intent
        val username = i.getStringExtra("name")

        // random number
        val randomNUm = randomNumber()
        luckyNumberTextView.text = randomNUm.toString()


        btnShareLuckyNumber.setOnClickListener { _ ->
            if (username != null) {
                shareData(username, randomNUm)
            }
        }


    }

    private fun shareData(username: String, randomNUm: Int) {
        // Implicit Intent
        val i = Intent(Intent.ACTION_SEND)

        i.type = "text/plain"

        // additional info

        i.putExtra(Intent.EXTRA_SUBJECT, "$username got lucky today!")
        i.putExtra(Intent.EXTRA_TEXT, "Your lucky number is $randomNUm")


        startActivity(Intent.createChooser(i, "Choose a platform"))


    }


    private fun randomNumber(): Int {
        val random = Random()
        val upperLimit = 1000
        return random.nextInt(upperLimit)
    }
}