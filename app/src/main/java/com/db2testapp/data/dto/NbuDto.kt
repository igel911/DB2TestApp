package com.db2testapp.data.dto

import com.google.gson.annotations.SerializedName

class NbuDto(
    @SerializedName("cc")
    val currency: String?,
    @SerializedName("txt")
    val currencyName: String?,
    @SerializedName("rate")
    val rate: Double?
)