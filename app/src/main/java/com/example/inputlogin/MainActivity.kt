package com.example.inputlogin

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.Gravity
import android.widget.Button
import android.widget.TextView
import android.widget.Toast
import com.google.android.material.textfield.TextInputEditText

class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        findViewById<Button>(R.id.enter_button)?.setOnClickListener {
            // mendapatkan tampilan ucapan
            val greetingDisplay = findViewById<TextView>(R.id.greeting_display)

            //mendapatkan nilai nama awal dari input text
            val firstName = findViewById<TextInputEditText>(R.id.first_name)?.text.toString().trim()

            //mendapatkan nilai nama akhir dari input text
            val lastName = findViewById<TextInputEditText>(R.id.last_name)?.text.toString().trim()

            //melakukan pengecekan jika nilainya kosong
            if (firstName.isNotEmpty() && lastName.isNotEmpty()){
                val nameToDisplay = firstName.plus(" ").plus(lastName)
                //gunakan string template
                greetingDisplay?.text = "${getString(R.string.welcome_to_the_app)} $nameToDisplay !"
            }else{
                Toast.makeText(this, getString(R.string.please_enter_a_name),
                Toast.LENGTH_SHORT).
                        apply {
                            setGravity(Gravity.CENTER,0,0)
                                show()
                        }
            }
        }
    }
}