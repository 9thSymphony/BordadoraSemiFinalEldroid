package com.bordadoraactivity6

import android.app.DatePickerDialog
import android.app.Dialog
import android.app.TimePickerDialog
import android.view.LayoutInflater
import android.widget.DatePicker
import android.widget.EditText
import android.widget.TimePicker
import android.widget.Toast
import androidx.appcompat.app.AlertDialog
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import com.bordadoraactivity6.databinding.ActivityBordadora6Binding
import java.util.Calendar

class BordadoraActivity6 : AppCompatActivity() {

    private lateinit var binding: ActivityBordadora6Binding
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityBordadora6Binding.inflate(layoutInflater)
        val view = binding.root
        setContentView(view)

        binding.AlertDialog.setOnClickListener{
            showAlertDialog()
        }

        binding.DatePickerDialog.setOnClickListener{
            showDatePickerDialog()
        }

        binding.TimePickerDialog.setOnClickListener{
            showTimePickerDialog()
        }
    }

    private fun showAlertDialog () {
        val alertDialogBuilder = AlertDialog.Builder(this)
        alertDialogBuilder.setTitle("Alert Dialog")
        alertDialogBuilder.setMessage("This is a part of the Alert Dialog")
        alertDialogBuilder.setPositiveButton("OK!") { _, _ ->
            showToast("OK Clicked")
        }
        alertDialogBuilder.setNegativeButton("Cancel") { _, _ ->
            showToast("Cancel Clicked")
        }


        alertDialogBuilder.show()
    }

    private fun showDatePickerDialog () {
        val calendar = Calendar.getInstance()
        val year = calendar.get(Calendar.YEAR)
        val month = calendar.get(Calendar.MONTH)
        val day = calendar.get(Calendar.DAY_OF_MONTH)
        val datePickerDialog = DatePickerDialog(
            this,
            { _: DatePicker?, selectedYear: Int, selectedMonth: Int, selectedDay: Int ->
                showToast("Date selected: $selectedDay/${selectedMonth + 1}/$selectedYear")
            },
            year,
            month,
            day
        )

        datePickerDialog.show()
    }

    private fun showTimePickerDialog() {
        val calendar = Calendar.getInstance()
        val hour = calendar.get(Calendar.HOUR_OF_DAY)
        val minute = calendar.get(Calendar.MINUTE)

        val timePickerDialog = TimePickerDialog(
            this,
            { _: TimePicker?, selectedHour: Int, selectedMinute: Int ->
                showToast("Time selected: $selectedHour:$selectedMinute")
            },
            hour,
            minute,
            true
        )

        timePickerDialog.show()
    }

    private fun showToast(message: String) {
        Toast.makeText(this, message, Toast.LENGTH_SHORT).show()
    }
}