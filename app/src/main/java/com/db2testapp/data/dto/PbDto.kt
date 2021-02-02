package com.db2testapp.data.dto

import com.google.gson.annotations.SerializedName

class PbDto(
    @SerializedName("currency")
    val currency: String?,
    @SerializedName("purchaseRate")
    val purchaseRate: Double?,
    @SerializedName("saleRate")
    val saleRate: Double?
)