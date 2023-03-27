package com.example.picturesdemoapp.model

import androidx.room.Embedded
import kotlinx.serialization.SerialName
import kotlinx.serialization.Serializable

@Serializable
data class User(

    @Embedded
    @SerialName("links")
    val userLinks: UserLinks,

    val username: String
)
