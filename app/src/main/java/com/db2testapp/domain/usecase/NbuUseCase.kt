package com.db2testapp.domain.usecase

import com.db2testapp.data.vo.NbuItem
import com.db2testapp.domain.repository.BankRepository

class NbuUseCase(private val repository: BankRepository) : BankUseCase() {

    suspend fun getNbuItems(year: Int = 2015, month: Int = 1, day: Int = 1): List<NbuItem> {
        val date = "$year"
            .plus(getDateString(month + 1))
            .plus(getDateString(day))
        return repository.getNbuItems(date)
    }
}