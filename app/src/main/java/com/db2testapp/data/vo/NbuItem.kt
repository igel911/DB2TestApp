package com.db2testapp.data.vo

class NbuItem (currency: String,
               val currencyName: String,
               val baseCurrencyName: String,
               val rate: String,
               isSelected: Boolean = false
) : BankItem(currency, isSelected)