package com.db2testapp.data.mapper

import com.db2testapp.data.dto.PbDto
import com.db2testapp.data.dto.PbResponseDto
import com.db2testapp.data.vo.PbItem

object PbMapper {
    fun toValueObject(dto: PbResponseDto): List<PbItem> {
        return dto.exchangeRate?.map { toValueObject(it) } ?: emptyList()
    }

    private fun toValueObject(dto: PbDto): PbItem {
        return PbItem(
            currency = dto.currency ?: "",
            purchaseRate = dto.purchaseRate?.toString() ?: 0.0.toString(),
            saleRate = dto.saleRate?.toString() ?: 0.0.toString()
        )
    }
}