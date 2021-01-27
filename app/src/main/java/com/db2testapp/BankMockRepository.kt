package com.db2testapp

class BankMockRepository {

    fun getBankCourses(): List<PbItem> {
        return MutableList(15) { PbItem("ABC$it", "123+$it", "321+$it") }
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