package com.ericg.pagingmovies.data

import android.os.Parcelable
import com.google.gson.annotations.SerializedName
import kotlinx.parcelize.Parcelize

@Parcelize
data class Movie(
    @SerializedName("title")
    val title: String?,
    @SerializedName("backdrop_path")
    val path: String?
): Parcelable
