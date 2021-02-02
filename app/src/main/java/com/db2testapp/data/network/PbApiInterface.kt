package com.db2testapp.data.network

import com.db2testapp.data.dto.PbResponseDto
import retrofit2.http.GET
import retrofit2.http.Query

interface PbApiInterface {

    @GET("exchange_rates")
    suspend fun getPbItems(
        @Query("json") json: String = "json",
        @Query("date") date: String = "01.01.2015"
    ): PbResponseDto
}