package com.example.composenavigation.model

import android.os.Parcelable
import kotlinx.parcelize.Parcelize

@Parcelize
data class User(
    val name: String,
    val age: Int,
    val email: String,
    val created: Long
): Parcelable
