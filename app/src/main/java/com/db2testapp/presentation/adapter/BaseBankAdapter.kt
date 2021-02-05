package com.db2testapp.presentation.adapter

import androidx.recyclerview.widget.RecyclerView
import com.db2testapp.data.vo.BankItem

abstract class BaseBankAdapter<T : RecyclerView.ViewHolder>(
    private val onClick: (currency: String) -> Unit
) : RecyclerView.Adapter<T>() {

    var dataSet: List<BankItem> = emptyList()

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

    fun setList(dataSet: List<BankItem>) {
        this.dataSet = dataSet
        notifyDataSetChanged()
    }

    override fun getItemCount() = dataSet.size
}