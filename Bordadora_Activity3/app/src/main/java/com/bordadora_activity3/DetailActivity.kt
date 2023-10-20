package com.bordadora_activity3

import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import com.bordadora_activity3.databinding.ActivityDetailActivityBinding

class DetailActivity : AppCompatActivity () {
    private lateinit var binding: ActivityDetailActivityBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityDetailActivityBinding.inflate(layoutInflater)
        setContentView(binding.root)

        binding.detailName.text =  intent.getStringExtra("NAME_PARAMS")
        binding.detailSubject.text =  intent.getStringExtra("SUBJECT_PARAMS")
        binding.detailMessage.text =  intent.getStringExtra("MESSAGE_PARAMS")
    }
}