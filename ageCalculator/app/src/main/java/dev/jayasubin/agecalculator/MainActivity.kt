package dev.jayasubin.agecalculator

import android.app.DatePickerDialog
import android.os.Bundle
import android.widget.Button
import android.widget.TextView
import android.widget.Toast
import androidx.appcompat.app.AppCompatActivity
import java.text.SimpleDateFormat
import java.util.*

class MainActivity : AppCompatActivity() {
    private var selectedDate:TextView?=null
    private var differenceMinutes:TextView?=null

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        val datePickerButton: Button = findViewById(R.id.date_pick_button)
        selectedDate=findViewById(R.id.tv_date)
        differenceMinutes=findViewById(R.id.diff_minutes)

        datePickerButton.setOnClickListener {
            onDatePickerClick()
        }
    }

    private fun onDatePickerClick() {
        val instance = Calendar.getInstance()

        val year = instance.get(Calendar.YEAR)
        val month = instance.get(Calendar.MONTH)
        val day = instance.get(Calendar.DAY_OF_MONTH)

       val picker= DatePickerDialog(
            this,
            { _, pYear, pMonth, pDay ->
                val dateString="$pDay/${pMonth+1}/$pYear"

                val sdf=SimpleDateFormat("dd/MM/yyyy", Locale.ENGLISH)
                val dateObj=sdf.parse(dateString)
                if(dateObj!=null){
                    val selectedMinutes = (dateObj.time) / 60000

                    val curDate = sdf.parse(sdf.format(System.currentTimeMillis()))
                    val curMinutes = (curDate?.time ?: 0) / 60000

                    val difference = curMinutes - selectedMinutes

                    Toast.makeText(this, "selected $dateString", Toast.LENGTH_SHORT).show()
                    selectedDate?.text = dateString
                    differenceMinutes?.text = difference.toString()
                }
            },
            year,
            month,
            day
        )

        picker.datePicker.maxDate=System.currentTimeMillis()-86400000
        picker.show()
    }
}