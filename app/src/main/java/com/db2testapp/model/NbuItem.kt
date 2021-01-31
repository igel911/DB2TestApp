package com.db2testapp.model

class NbuItem (currency: String,
               val purchaseRate: String,
               val saleRate: String,
               isSelected: Boolean = false
) : BankItem(currency, isSelected)