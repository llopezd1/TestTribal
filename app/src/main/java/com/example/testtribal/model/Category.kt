package com.example.testtribal.model

import android.os.Parcelable
import kotlinx.parcelize.Parcelize
import java.io.Serializable

@Parcelize
class Category(
    val created_at: String,
    val icon_url: String,
    val updated_at: String,
    val id: String,
    val url: String,
    val value: String
) : Parcelable, Serializable