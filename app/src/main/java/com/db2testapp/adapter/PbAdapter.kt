package com.db2testapp.adapter

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.db2testapp.R
import com.db2testapp.model.PbItem
import com.db2testapp.databinding.ItemPbBinding

class PbAdapter(
    dataSet: List<PbItem>,
    onClick: (currency: String) -> Unit
) : BaseBankAdapter<PbAdapter.ViewHolder>(dataSet, onClick) {

    override fun onCreateViewHolder(viewGroup: ViewGroup, viewType: Int) =
        ViewHolder(
            ItemPbBinding.inflate(
                LayoutInflater.from(viewGroup.context),
                viewGroup,
                false
            )
        )

    override fun onBindViewHolder(viewHolder: ViewHolder, position: Int) {
        val item = dataSet[position] as PbItem
        viewHolder.binding.itemTextViewCurrency.text = item.currency
        viewHolder.binding.itemTextViewPurchaseRate.text = item.purchaseRate
        viewHolder.binding.itemTextViewSaleRate.text = item.saleRate

        val color = if (item.isSelected) R.color.dark_gray else R.color.white
        viewHolder.itemView.setBackgroundColor(viewHolder.itemView.context.getColor(color))

        viewHolder.itemView.setOnClickListener { makeSelection(item, position) }
    }

    class ViewHolder(val binding: ItemPbBinding) : RecyclerView.ViewHolder(binding.root)
}