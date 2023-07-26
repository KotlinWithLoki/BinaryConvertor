package com.example.binaryconvertor

import android.annotation.SuppressLint
import android.content.ClipData
import android.content.ClipboardManager
import android.content.Context
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import android.view.View
import android.widget.Button
import android.widget.EditText
import android.widget.TextView
import android.widget.Toast

class MainActivity : AppCompatActivity() {
    @SuppressLint("MissingInflatedId")
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)


        var edt = findViewById<EditText>(R.id.text2)
        var btn = findViewById<Button>(R.id.convt)
        var copy = findViewById<Button>(R.id.copy)
        var txtbin = findViewById<TextView>(R.id.txtbin)

        btn.setOnClickListener {
            if (edt.text.toString() != ""){
                var text = edt.text.toString()
                var i = 0
                var textNumber = text.length
                var mainText = ""
                while (i < textNumber){
                    var binaryNumber = strToBinary(text[i].toString())
                    mainText += "$binaryNumber "
                    i++
                }

                txtbin.text = mainText
                txtbin.visibility = View.VISIBLE
            } else {
                Toast.makeText(this, "TEXT ISN'T AVAILABLE!", Toast.LENGTH_SHORT).show()
            }
        }

        copy.setOnClickListener {
            if (txtbin.text  != ""){
                var text = txtbin.text.toString()
                val clipboardManager = getSystemService(Context.CLIPBOARD_SERVICE) as ClipboardManager
                val clipData = ClipData.newPlainText("text", text)
                clipboardManager.setPrimaryClip(clipData)
                Toast.makeText(this, "COPIED!", Toast.LENGTH_SHORT).show()
            } else {
                Toast.makeText(this, "TEXT ISN'T AVAILABLE!", Toast.LENGTH_SHORT).show()
            }
        }

    }


    fun strToBinary(str:String) : String {

        val builder = StringBuilder()


        for (c in str.toCharArray()) {
            val toString = Integer.toString(c.toInt(), 2); // get char value in binary
            builder.append(String.format("%08d", Integer.parseInt(toString))); // we complete to have 8 digits
        }
        // LOKI

        return builder.toString()
    }
}