package com.mabale.animal.myapplication

import retrofit2.Call
import retrofit2.http.Body
import retrofit2.http.DELETE
import retrofit2.http.GET
import retrofit2.http.POST
import retrofit2.http.PUT
import retrofit2.http.Path

interface TweetApiService {
    @GET("tweet/{lastname}")
    fun listTweets(@Path("lastname") lastname: String): Call<List<Tweet>>

    @POST("tweet")
    fun createTweet(@Body newTweet: Tweet): Call<Tweet>

    @PUT("tweet/{id}")
    fun updateTweet(@Path("id") id: String, @Body tweet: Tweet): Call<Tweet>

    @DELETE("tweet/{id}")
    fun deleteTweet(@Path("id") id: String): Call<Unit>
}