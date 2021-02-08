package com.db2testapp.domain.usecase

import com.db2testapp.data.vo.PbItem
import com.db2testapp.domain.repository.BankRepository
import javax.inject.Inject

class PbUseCase @Inject constructor(private val repository: BankRepository) : BankUseCase() {

    suspend fun getPbItems(year: Int = 2015, month: Int = 1, day: Int = 1): List<PbItem> {
        val date = getDateString(day)
            .plus(".")
            .plus(getDateString(month + 1))
            .plus(".")
            .plus(year.toString())
        return repository.getPbItems(date)
    }
}