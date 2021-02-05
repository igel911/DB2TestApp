package com.db2testapp.domain.usecase

abstract class BankUseCase {

    fun getDateString(date: Int): String = if (date < 10) "0$date" else date.toString()
}