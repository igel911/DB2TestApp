package com.db2testapp.presentation.adapter

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.db2testapp.R
import com.db2testapp.databinding.ItemNbuBinding
import com.db2testapp.data.vo.NbuItem

class NbuAdapter(
    dataSet: List<NbuItem>,
    onClick: (currency: String) -> Unit
) : BaseBankAdapter<NbuAdapter.ViewHolder>(dataSet, onClick) {

    override fun onCreateViewHolder(viewGroup: ViewGroup, viewType: Int) =
        ViewHolder(
            ItemNbuBinding.inflate(
                LayoutInflater.from(viewGroup.context),
                viewGroup,
                false
            )
        )

    override fun onBindViewHolder(viewHolder: ViewHolder, position: Int) {
        val item = dataSet[position] as NbuItem
        viewHolder.binding.itemTextViewCurrency.text = item.currencyName
        viewHolder.binding.itemTextViewPurchaseRate.text = item.rate
        viewHolder.binding.itemTextViewBaseCurrency.text = item.baseCurrencyName

        val color = if (item.isSelected) {
            R.color.dark_gray
        } else {
            if (position % 2 != 0) R.color.green_lite else R.color.white
        }

        viewHolder.itemView.setBackgroundColor(viewHolder.itemView.context.getColor(color))

        viewHolder.itemView.setOnClickListener { makeSelection(item, position) }
    }

    class ViewHolder(val binding: ItemNbuBinding) : RecyclerView.ViewHolder(binding.root)
}