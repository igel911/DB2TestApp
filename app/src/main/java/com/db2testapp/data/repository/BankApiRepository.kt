package com.db2testapp.data.repository

import com.db2testapp.data.mapper.NbuMapper
import com.db2testapp.data.mapper.PbMapper
import com.db2testapp.data.network.BankApiClient
import com.db2testapp.data.vo.NbuItem
import com.db2testapp.data.vo.PbItem
import com.db2testapp.domain.repository.BankRepository
import javax.inject.Inject

class BankApiRepository @Inject constructor(private val clientApi: BankApiClient) : BankRepository {

    override suspend fun getPbItems(date: String): List<PbItem> {
        val dto = clientApi.pbApiClient.getPbItems(date = date)
        return PbMapper.toValueObject(dto)
    }

    override suspend fun getNbuItems(date: String): List<NbuItem> {
        val dtoList = clientApi.nbuApiClient.getNbuItems(date = date)
        return NbuMapper.toValueObject(dtoList)
    }


}