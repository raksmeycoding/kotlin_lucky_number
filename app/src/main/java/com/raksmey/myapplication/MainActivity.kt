package com.raksmey.myapplication

import android.annotation.SuppressLint
import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Button
import android.widget.EditText

class MainActivity : AppCompatActivity() {

    private lateinit var btnWishMeALuck: Button
    private lateinit var exitTextUseNmae: EditText


    @SuppressLint("MissingInflatedId")
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)


        btnWishMeALuck = findViewById(R.id.id_wish_me_a_luck)
        exitTextUseNmae = findViewById(R.id.id_editText_enter_name)


        btnWishMeALuck.setOnClickListener { _ ->
            val username = exitTextUseNmae.text.toString()

            // explicit intent
            val intent = Intent(applicationContext, SecondActivity::class.java)

            // put extra data to pass along from one activity to anther activity
            intent.putExtra("name", username)

            startActivity(intent)

        }


    }
}