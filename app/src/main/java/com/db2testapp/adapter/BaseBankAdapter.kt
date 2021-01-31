package com.db2testapp.adapter

import androidx.recyclerview.widget.RecyclerView
import com.db2testapp.model.BankItem

abstract class BaseBankAdapter<T : RecyclerView.ViewHolder>(
    val dataSet: List<BankItem>,
    private val onClick: (currency: String) -> Unit
) : RecyclerView.Adapter<T>() {

    fun getItemIndexByCurrency(currency: String) =
        dataSet.indexOfFirst { it.currency == currency }

    fun clearSelection() {
        dataSet.forEach { it.isSelected = false }
        notifyDataSetChanged()
    }

    fun setItemSelected(position: Int) {
        clearSelection()
        dataSet[position].isSelected = true
        notifyItemChanged(position)
    }

    fun makeSelection(item: BankItem, position: Int) {
        clearSelection()
        item.isSelected = true
        notifyItemChanged(position)
        onClick.invoke(item.currency)
    }

    override fun getItemCount() = dataSet.size
}