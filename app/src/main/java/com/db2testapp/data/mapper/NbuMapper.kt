package com.db2testapp.data.mapper

import com.db2testapp.data.dto.NbuDto
import com.db2testapp.data.vo.NbuItem


object NbuMapper {
    fun toValueObject(dtoList: List<NbuDto>?): List<NbuItem> {
        return dtoList?.map { toValueObject(it) } ?: emptyList()
    }

    private fun toValueObject(dto: NbuDto): NbuItem {
        return NbuItem(
            currency = dto.currency ?: "",
            currencyName = dto.currencyName ?: "",
            rate = dto.rate?.toString() ?: 0.0.toString()
        )
    }
}