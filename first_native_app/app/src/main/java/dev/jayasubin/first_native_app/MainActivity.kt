package dev.jayasubin.first_native_app

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Button
import android.widget.TextView
import android.widget.Toast

class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        val startButton=findViewById<Button>(R.id.start_button)
        val theOnlyText=findViewById<TextView>(R.id.only_text)

        var count=0

        startButton.setOnClickListener {
            count++

            theOnlyText.text=count.toString()
            Toast.makeText(this, "Someone just clicked",Toast.LENGTH_SHORT).show()
        }
    }
}