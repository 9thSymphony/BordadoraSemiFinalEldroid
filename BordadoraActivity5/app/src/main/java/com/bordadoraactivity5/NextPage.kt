package com.bordadoraactivity5

import android.Manifest
import android.content.Intent
import android.content.pm.PackageManager
import android.os.Build
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Toast
import androidx.core.app.ActivityCompat
import androidx.core.content.ContextCompat
import androidx.annotation.RequiresApi
import com.bordadoraactivity5.databinding.ActivityNextPageBinding

private const val STORAGE_PERMISSION_CODE = 1
private const val LOCATION_PERMISSION_CODE = 2
private const val CAMERA_PERMISSION_CODE = 3
private const val RECORD_AUDIO_PERMISSION_CODE = 4
class NextPage : AppCompatActivity() {
    private lateinit var binding: ActivityNextPageBinding
    @RequiresApi(Build.VERSION_CODES.M)
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityNextPageBinding.inflate(layoutInflater)
        setContentView(binding.root)

        binding.camera.setOnClickListener {
            requestPermission(Manifest.permission.CAMERA, CAMERA_PERMISSION_CODE)
        }
        binding.location.setOnClickListener {
            requestPermission(Manifest.permission.ACCESS_FINE_LOCATION, LOCATION_PERMISSION_CODE)
        }
        binding.sounds.setOnClickListener {
            requestPermission(Manifest.permission.RECORD_AUDIO, RECORD_AUDIO_PERMISSION_CODE)
        }

        binding.back.setOnClickListener {
            val intent = Intent(
                this,
                BordadoraActivity5::class.java
            ) // Ensure this class exists in your project
            startActivity(intent)
        }
    }
        @RequiresApi(api = Build.VERSION_CODES.M)
        private fun requestPermission(permission: String, requestCode: Int) {
            if (ContextCompat.checkSelfPermission(this, permission) != PackageManager.PERMISSION_GRANTED) {
                ActivityCompat.requestPermissions(this, arrayOf(permission), requestCode)
            } else {
                Toast.makeText(this, "$permission permission is already granted.", Toast.LENGTH_SHORT).show()
            }
        }

        override fun onRequestPermissionsResult(requestCode: Int, permissions: Array<String>, grantResults: IntArray) {
            super.onRequestPermissionsResult(requestCode, permissions, grantResults)
            if (requestCode == CAMERA_PERMISSION_CODE || requestCode == LOCATION_PERMISSION_CODE || requestCode == RECORD_AUDIO_PERMISSION_CODE) {
                if (grantResults.isNotEmpty() && grantResults[0] == PackageManager.PERMISSION_GRANTED) {
                    Toast.makeText(this, "${permissions[0]} permission granted", Toast.LENGTH_SHORT).show()
                } else {
                    Toast.makeText(this, "${permissions[0]} permission denied", Toast.LENGTH_SHORT).show()
                }
            }
        }
    }
