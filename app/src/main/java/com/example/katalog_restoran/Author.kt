package com.example.katalog_restoran

import android.os.Parcelable
import kotlinx.parcelize.Parcelize

@Parcelize
data class Author(
    val name: String,
    val photo: Int,
) : Parcelable
