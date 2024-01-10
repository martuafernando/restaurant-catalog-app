package com.example.katalog_restoran

import android.os.Parcelable
import kotlinx.parcelize.Parcelize

@Parcelize
data class Restaurant(
    val name: String,
    val description: String,
    val photo: Int,
) : Parcelable
