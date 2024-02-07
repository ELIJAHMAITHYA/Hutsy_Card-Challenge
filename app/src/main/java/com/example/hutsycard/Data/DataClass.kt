package com.example.hutsycard.Data

import android.annotation.SuppressLint
import androidx.annotation.DrawableRes
import androidx.annotation.StringRes
import com.example.hutsycard.R


data class User(
    var name: String,
    val email: String,
    @StringRes val description: Int,
    @DrawableRes val profile_image: Int
)

val users = listOf(
    User(
        name = "Vipen Biesk",
        email = "kelvindurant343@aol.com",
        R.string.profile_desc,
        R.drawable.silaelijah
    ),
    User(
        name = "Paul Scholles",
        email = "paulScholles354#yahoo.com",
        R.string.profile_desc,
        R.drawable.paul
    ),
    User(
        name = "Eden Hazard",
        email = "hazardCfc10@gmail.com",
        R.string.profile_desc,
        R.drawable.paul
    ),
    User(
        name = "Maithya Sila",
        email = "szelijah219@gmail.com",
        R.string.profile_desc,
        R.drawable.silaelijah
    )
)

