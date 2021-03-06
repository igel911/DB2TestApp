package com.db2testapp.presentation.adapter

import android.graphics.Rect
import android.view.View
import androidx.recyclerview.widget.RecyclerView
import com.db2testapp.R

class ItemDecoratorBank : RecyclerView.ItemDecoration() {

    override fun getItemOffsets(
        outRect: Rect,
        view: View,
        parent: RecyclerView,
        state: RecyclerView.State
    ) {
        super.getItemOffsets(outRect, view, parent, state)
        val padding = view.context.resources.getDimension(R.dimen.material_padding_small).toInt()
        outRect.top = padding
        outRect.bottom = padding
    }
}