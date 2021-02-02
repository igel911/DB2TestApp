package com.db2testapp.data.mapper

import com.db2testapp.data.dto.NbuDto
import com.db2testapp.data.vo.NbuItem


object NbuMapper {
    fun toValueObject(dtoList: List<NbuDto>?): List<NbuItem> {
        return dtoList?.map { toValueObject(it) } ?: emptyList()
    }

    private fun toValueObject(dto: NbuDto): NbuItem {
        var finalRate = dto.rate ?: 0.00
        val baseCurrencyCount = if (finalRate > 1.0) {
            "1"
        } else {
            finalRate *= 100
            "100"
        }

        return NbuItem(
            currency = dto.currency ?: "",
            currencyName = dto.currencyName ?: "",
            baseCurrencyName = baseCurrencyCount.plus(dto.currency),
            rate = String.format("%.2f", finalRate).plus("UAH")
        )
    }
}