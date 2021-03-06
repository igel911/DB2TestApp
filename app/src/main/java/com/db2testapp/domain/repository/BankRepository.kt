package com.db2testapp.domain.repository

import com.db2testapp.data.vo.NbuItem
import com.db2testapp.data.vo.PbItem

interface BankRepository {
    suspend fun getPbItems(date: String): List<PbItem>

    suspend fun getNbuItems(date: String): List<NbuItem>
}