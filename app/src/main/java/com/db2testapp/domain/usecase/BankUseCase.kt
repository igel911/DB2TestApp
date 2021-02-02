package com.db2testapp.domain.usecase

import com.db2testapp.data.vo.NbuItem
import com.db2testapp.data.vo.PbItem
import com.db2testapp.domain.repository.BankRepository

class BankUseCase(private val repository: BankRepository) {

    suspend fun getPbItems(year: Int = 2015, month: Int = 1, day: Int = 1): List<PbItem> {
        val date = getDateString(day)
            .plus(".")
            .plus(getDateString(month + 1))
            .plus(".")
            .plus(year.toString())
        return repository.getPbItems(date)
    }

    suspend fun getNbuItems(year: Int = 2015, month: Int = 1, day: Int = 1): List<NbuItem> {
        val date = "$year"
            .plus(getDateString(month + 1))
            .plus(getDateString(day))
        return repository.getNbuItems(date)
    }

    private fun getDateString(date: Int): String = if (date < 10) "0$date" else date.toString()
}