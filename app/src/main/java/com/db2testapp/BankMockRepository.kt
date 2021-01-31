package com.db2testapp

import com.db2testapp.model.NbuItem
import com.db2testapp.model.PbItem

class BankMockRepository {

    fun getPBCourses(): List<PbItem> {
        return MutableList(15) { PbItem("ABC$it", "123+$it", "321+$it") }
    }

    fun getNBUCourses(): List<NbuItem> {
        return MutableList(15) { NbuItem("ABC${it + 10}", "123+$it", "321+$it") }
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