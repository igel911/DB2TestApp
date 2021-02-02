package com.db2testapp.data.dto

import com.google.gson.annotations.SerializedName

class PbResponseDto(
    @SerializedName("exchangeRate")
    val exchangeRate: List<PbDto>?
)