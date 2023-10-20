package com.mabale_ciedner_activity4

import android.content.Context
import android.content.SharedPreferences
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Toast
import com.mabale_ciedner_activity4.databinding.ActivityMabaleCiednerAct4Binding

class Mabale_Ciedner_Act_4 : AppCompatActivity() {
    private lateinit var sharedPreferences: SharedPreferences
    private lateinit var binding: ActivityMabaleCiednerAct4Binding
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityMabaleCiednerAct4Binding.inflate(layoutInflater)
        setContentView(binding.root)

        sharedPreferences = getPreferences(Context.MODE_PRIVATE)
        loadPreferences()
        binding.save.setOnClickListener{
            save ()
            Toast.makeText(this ,"Saved!", Toast.LENGTH_LONG).show()
        }
    }

    private fun save () {
        val editor = sharedPreferences.edit()
        editor.putString("email", binding.emailT.text.toString())
        editor.putString("nickname",binding.nickanameT.text.toString())
        editor.putBoolean("allowNotification", binding.allow.isChecked)
        editor.putInt("selectedTheme", binding.theme.checkedRadioButtonId)
        editor.apply()
    }

    private fun loadPreferences () {
        binding.emailT.setText(sharedPreferences.getString("email", ""))
        binding.nickanameT.setText(sharedPreferences.getString("nickname", ""))
        binding.allow.isChecked = sharedPreferences.getBoolean("allowNotification", false)

        val selectedThemeId = sharedPreferences.getInt("selectedTheme", -1)
        if (selectedThemeId != -1) {
            binding.theme.check(selectedThemeId)
        }
    }
}