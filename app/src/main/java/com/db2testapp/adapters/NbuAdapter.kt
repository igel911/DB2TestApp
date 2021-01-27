package com.db2testapp.adapters

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.db2testapp.PbItem
import com.db2testapp.R
import com.db2testapp.databinding.ItemNbuBinding

class NbuAdapter(private val dataSet: List<PbItem>) :
    RecyclerView.Adapter<NbuAdapter.ViewHolder>() {

    override fun onCreateViewHolder(viewGroup: ViewGroup, viewType: Int): ViewHolder {
        val binding =
            ItemNbuBinding.inflate(LayoutInflater.from(viewGroup.context), viewGroup, false)

        return ViewHolder(binding)
    }

    override fun onBindViewHolder(viewHolder: ViewHolder, position: Int) {
        val item = dataSet[position]
        viewHolder.binding.itemTextViewCurrency.text = item.currency
        viewHolder.binding.itemTextViewPurchaseRate.text = item.purchaseRate
        viewHolder.binding.itemTextViewSaleRate.text = item.saleRate

        val color = if (position % 2 != 0) R.color.green_lite else R.color.white

        viewHolder.binding.itemParent.setBackgroundColor(
            viewHolder.itemView.context.getColor(color)
        )
    }

    override fun getItemCount() = dataSet.size

    class ViewHolder(val binding: ItemNbuBinding) : RecyclerView.ViewHolder(binding.root)
}