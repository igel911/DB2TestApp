package com.db2testapp.adapters

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.db2testapp.PbItem
import com.db2testapp.databinding.ItemPbBinding

class PbAdapter(private val dataSet: List<PbItem>) :
    RecyclerView.Adapter<PbAdapter.ViewHolder>() {

    override fun onCreateViewHolder(viewGroup: ViewGroup, viewType: Int): ViewHolder {
        val binding =
            ItemPbBinding.inflate(LayoutInflater.from(viewGroup.context), viewGroup, false)

        return ViewHolder(binding)
    }

    override fun onBindViewHolder(viewHolder: ViewHolder, position: Int) {

        val item = dataSet[position]
        viewHolder.binding.itemTextViewCurrency.text = item.currency
        viewHolder.binding.itemTextViewPurchaseRate.text = item.purchaseRate
        viewHolder.binding.itemTextViewSaleRate.text = item.saleRate
    }

    override fun getItemCount() = dataSet.size

    class ViewHolder(val binding: ItemPbBinding) : RecyclerView.ViewHolder(binding.root)
}