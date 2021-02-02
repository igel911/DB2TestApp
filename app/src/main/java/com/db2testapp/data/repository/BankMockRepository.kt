package com.db2testapp.data.repository

import com.db2testapp.data.dto.NbuDto
import com.db2testapp.data.dto.PbDto
import com.db2testapp.data.dto.PbResponseDto
import com.db2testapp.data.mapper.NbuMapper
import com.db2testapp.data.mapper.PbMapper
import com.db2testapp.data.vo.NbuItem
import com.db2testapp.data.vo.PbItem
import com.db2testapp.domain.repository.BankRepository

class BankMockRepository : BankRepository {

    private fun getPBCourses(): List<PbDto> {
        return MutableList(15) { PbDto("ABC$it", 123.0 + it, 321.0 + it) }
    }

    private fun getNBUCourses(): List<NbuDto> {
        return MutableList(15) { NbuDto("ABC${it + 10}", "123+$it", 321.0 + it) }
    }

    override suspend  fun getPbItems(): List<PbItem> {
        val dto = PbResponseDto(getPBCourses())
        return PbMapper.toValueObject(dto)
    }

    override suspend fun getNbuItems(): List<NbuItem> {
        return NbuMapper.toValueObject(getNBUCourses())
    }

    companion object {
        @Volatile
        private var instance: BankMockRepository? = null

        fun getInstance() =
            instance ?: synchronized(this) {
                instance ?: BankMockRepository().also { instance = it }
            }
    }
}