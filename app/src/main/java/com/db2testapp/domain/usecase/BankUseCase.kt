package com.db2testapp.domain.usecase

import com.db2testapp.data.vo.NbuItem
import com.db2testapp.data.vo.PbItem
import com.db2testapp.domain.repository.BankRepository

class BankUseCase(private val repository: BankRepository) {

    fun getPbItems(): List<PbItem> {
        return repository.getPbItems()
    }

    fun getNbuItems(): List<NbuItem> {
        return repository.getNbuItems()
    }
}