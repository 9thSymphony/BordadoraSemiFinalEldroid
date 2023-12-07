package com.gutib.semifinal.exam

import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import com.gutib.semifinal.exam.databinding.ActivityMainBinding
import kotlinx.coroutines.DelicateCoroutinesApi
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.GlobalScope
import kotlinx.coroutines.launch
import okhttp3.*
import org.json.JSONObject
import java.io.IOException

@OptIn(DelicateCoroutinesApi::class)
class MainActivity : AppCompatActivity() {

    private lateinit var binding: ActivityMainBinding
    private val baseUrl = "https://eldroid.online/tweet/gutib"

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)

        // Button click event to read all tweets
        binding.readAllTweetsButton.setOnClickListener {
            readAllTweets()
        }

        // Button click event to read a specific tweet
        binding.readSpecificTweetButton.setOnClickListener {
            val tweetId = binding.tweetIdEditText.text.toString()
            readSpecificTweet(tweetId)
        }

        // Button click event to create a new tweet
        binding.createTweetButton.setOnClickListener {
            val name = binding.userNameEditText.text.toString()
            val description = binding.tweetDescriptionEditText.text.toString()
            createTweet(name, description)
        }
    }

    private fun readAllTweets() {
        val client = OkHttpClient()
        val request = Request.Builder()
            .url(baseUrl)
            .get()
            .build()

        GlobalScope.launch(Dispatchers.IO) {
            try {
                val response = client.newCall(request).execute()
                val responseBody = response.body?.string()
                // Parse JSON response and update UI accordingly
            } catch (e: IOException) {
                e.printStackTrace()
                // Handle failure
            }
        }
    }

    private fun readSpecificTweet(tweetId: String) {
        val client = OkHttpClient()
        val url = "$baseUrl/$tweetId"
        val request = Request.Builder()
            .url(url)
            .get()
            .build()

        GlobalScope.launch(Dispatchers.IO) {
            try {
                val response = client.newCall(request).execute()
                val responseBody = response.body?.string()
                // Parse JSON response and update UI accordingly
            } catch (e: IOException) {
                e.printStackTrace()
                // Handle failure
            }
        }
    }

    private fun createTweet(name: String, description: String) {
        val client = OkHttpClient()
        val url = baseUrl
        val json = JSONObject()
            .put("name", name)
            .put("description", description)

        val requestBody = RequestBody.create(MediaType.parse("application/json"), json.toString())
        val request = Request.Builder()
            .url(url)
            .post(requestBody)
            .build()

        GlobalScope.launch(Dispatchers.IO) {
            try {
                val response = client.newCall(request).execute()
                val responseBody = response.body?.string()
                // Parse JSON response and update UI accordingly
            } catch (e: IOException) {
                e.printStackTrace()
                // Handle failure
            }
        }
    }
}
