package com.db2testapp.data.network

import com.db2testapp.data.dto.NbuDto
import retrofit2.http.GET
import retrofit2.http.Query

interface NbuApiInterface {

    @GET("exchange/")
    suspend fun getNbuItems(
        @Query("date") date: String = "20150101",
        @Query("json") json: String = "json"
    ): List<NbuDto>
}