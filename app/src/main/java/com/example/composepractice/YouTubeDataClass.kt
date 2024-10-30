package com.example.composepractice

import androidx.annotation.DrawableRes

data class YouTubeDataClass (
    @DrawableRes val thumbnail: Int,
    val videoTitle: String,
    val channelName: String
)