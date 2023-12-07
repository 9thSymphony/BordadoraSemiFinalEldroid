package com.mabale.animal.myapplication

import TweetAdapter
import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import android.widget.Toast
import androidx.recyclerview.widget.LinearLayoutManager
import com.mabale.animal.myapplication.databinding.ActivityMainBinding
import retrofit2.Call
import retrofit2.Callback
import retrofit2.Response

class MainActivity : AppCompatActivity() {
    private lateinit var binding: ActivityMainBinding
    private lateinit var tweetAdapter: TweetAdapter

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)

        binding.tweetsRecyclerView.layoutManager = LinearLayoutManager(this)

        // Initialize your adapter and set it to the RecyclerView
        tweetAdapter = TweetAdapter(emptyList())
        binding.tweetsRecyclerView.adapter = tweetAdapter

        // Fetch tweets using Retrofit and update the adapter
        val tweetApiService = RetrofitClient.instance

        // Assume you want to fetch tweets for "Smith"
        tweetApiService.listTweets("Wekwek").enqueue(object : Callback<List<Tweet>> {
            override fun onResponse(call: Call<List<Tweet>>, response: Response<List<Tweet>>) {
                if (response.isSuccessful) {
                    val tweets = response.body() ?: emptyList()
                    tweetAdapter = TweetAdapter(tweets)
                    binding.tweetsRecyclerView.adapter = tweetAdapter
                } else {
                    // Handle error
                    val errorMessage = "Error: ${response.code()}"
                    showToast(errorMessage)
                }
            }

            override fun onFailure(call: Call<List<Tweet>>, t: Throwable) {
                // Handle failure
                val errorMessage = "Network request failed"
                showToast(errorMessage)
            }
        })
    }

    private fun showToast(message: String) {
        Toast.makeText(this, message, Toast.LENGTH_SHORT).show()
    }
}


