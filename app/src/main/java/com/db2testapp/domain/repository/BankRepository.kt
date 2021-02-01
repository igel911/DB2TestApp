package com.db2testapp.domain.repository

import com.db2testapp.data.vo.NbuItem
import com.db2testapp.data.vo.PbItem

interface BankRepository {
    fun getPbItems(): List<PbItem>

    fun getNbuItems(): List<NbuItem>
}