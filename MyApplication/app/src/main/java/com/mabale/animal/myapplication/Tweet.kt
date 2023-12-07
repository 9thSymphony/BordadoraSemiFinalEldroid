package com.mabale.animal.myapplication

data class Tweet(
    val id: String,
    val name: String,
    val description: String,
    val timestamp: Map<String, Long>
)