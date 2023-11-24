package com.bordadoraactivity5

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import com.bordadoraactivity5.databinding.ActivityBordadora5Binding

class BordadoraActivity5 : AppCompatActivity() {

    private lateinit var binding: ActivityBordadora5Binding
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityBordadora5Binding.inflate(layoutInflater)
        setContentView(binding.root)

        binding.secondPage.setOnClickListener{
            val intent = Intent (this, NextPage::class.java)
            startActivity(intent);
        }
    }
}