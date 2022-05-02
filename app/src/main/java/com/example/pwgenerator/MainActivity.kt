package com.example.pwgenerator

import android.content.ClipData.newPlainText
import android.content.ClipboardManager
import android.os.Bundle
import android.widget.Button
import android.widget.Switch
import android.widget.TextView
import android.widget.Toast
import androidx.appcompat.app.AppCompatActivity
import androidx.core.view.isVisible
import com.google.android.material.slider.Slider


class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        var btnLuoSalasana: Button = findViewById(R.id.btn_generatePw)
        var passWordField: TextView = findViewById(R.id.txtPassword)
        var slider: Slider = findViewById(R.id.slider)
        var sliderValue: TextView = findViewById(R.id.txtSliderValue)
        var capitalLetters: Switch = findViewById(R.id.isotKirjaimet)
        var smallLetters: Switch = findViewById(R.id.pienetKirjaimet)
        var numbers: Switch = findViewById(R.id.numerot)

        btnLuoSalasana.setOnClickListener {
            var passwordGeneration = PasswordGeneration()
            var newPassWord = passwordGeneration.createPassWord(slider.value.toInt(), capitalLetters.isChecked, smallLetters.isChecked, numbers.isChecked)
            passWordField.text = newPassWord
            passWordField.isVisible = true
        }
        slider.addOnChangeListener(Slider.OnChangeListener { slider, value, fromUser ->
            sliderValue.text = "Salasanan pituus: " + value.toInt()
        })

        passWordField.setOnClickListener {
            copyToClipBoard(passWordField)
            Toast.makeText(this@MainActivity, "Copied to clipboard", Toast.LENGTH_LONG).show()
        }

    }
    private fun copyToClipBoard(view: TextView) {
        val clipboard = getSystemService(CLIPBOARD_SERVICE) as ClipboardManager
        var myClip  = newPlainText("Copy text", view.text.toString())
        clipboard.setPrimaryClip(myClip)
    }

}


