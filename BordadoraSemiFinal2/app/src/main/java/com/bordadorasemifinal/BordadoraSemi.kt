package com.bordadorasemifinal

import android.os.Bundle
import android.widget.TextView
import androidx.appcompat.app.AppCompatActivity
import com.bordadorasemifinal.databinding.ActivityBordadoraSemiBinding
import retrofit2.Call
import retrofit2.Callback
import retrofit2.Response
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory

class BordadoraSemi : AppCompatActivity() {
    private lateinit var binding: ActivityBordadoraSemiBinding
    private lateinit var tweetApiServices: TweetApiServices

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityBordadoraSemiBinding.inflate(layoutInflater)
        setContentView(binding.root)

        initializeRetrofit()

        binding.buttonCreate.setOnClickListener {
            val tweet = createTweetFromInput()
            createTweet(tweet, binding.textViewResult)
        }

        binding.buttonUpdate.setOnClickListener {
            val tweetId = binding.tweetIdInput.text.toString()
            val updatedTweet = createTweetFromInput()
            updateTweet(tweetId, updatedTweet, binding.textViewResult)
        }

        binding.buttonDelete.setOnClickListener {
            // Logic to delete a tweet
            binding.textViewResult.text = "Tweet deleted"
        }
    }

    private fun initializeRetrofit() {
        val retrofit = Retrofit.Builder()
            .baseUrl("https://eldroid.online/")
            .addConverterFactory(GsonConverterFactory.create())
            .build()

        tweetApiServices = retrofit.create(TweetApiServices::class.java)
    }

    private fun createTweetFromInput(): Tweet {
        return Tweet(
            binding.lastNameInput.text.toString(),
            binding.tweetIdInput.text.toString(),
            binding.nameInput.text.toString(),
            binding.descriptionInput.text.toString()
        )
    }

    private fun createTweet(tweet: Tweet, textViewResult: TextView) {
        val call = tweetApiServices.createTweet(tweet)

        call.enqueue(object : Callback<Void> {
            override fun onResponse(call: Call<Void>, response: Response<Void>) {
                if (response.isSuccessful) {
                    textViewResult.text = "New tweet created"
                } else {
                    textViewResult.text =
                        "Failed to create tweet: ${response.code()} - ${response.message()}"
                }
            }

            override fun onFailure(call: Call<Void>, t: Throwable) {
                textViewResult.text = "Error: ${t.message}"
            }
        })
    }

    private fun updateTweet(tweetId: String, tweet: Tweet, textViewResult: TextView) {
        val call = tweetApiServices.updateTweet(tweetId, tweet)

        call.enqueue(object : Callback<Tweet> {
            override fun onResponse(call: Call<Tweet>, response: Response<Tweet>) {
                if (response.isSuccessful) {
                    textViewResult.text = "Tweet updated successfully"
                } else {
                    textViewResult.text =
                        "Failed to update tweet: ${response.code()} - ${response.message()}"
                }
            }

            override fun onFailure(call: Call<Tweet>, t: Throwable) {
                textViewResult.text = "Error: ${t.message}"
            }
        })
    }
}