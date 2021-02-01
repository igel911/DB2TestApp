package com.db2testapp.data.vo

class PbItem(
    currency: String,
    val purchaseRate: String,
    val saleRate: String,
    isSelected: Boolean = false
) : BankItem(currency, isSelected)
