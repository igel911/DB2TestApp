package com.db2testapp.presentation

import android.os.Bundle
import androidx.activity.viewModels
import androidx.appcompat.app.AppCompatActivity
import androidx.recyclerview.widget.RecyclerView
import com.db2testapp.R
import com.db2testapp.presentation.adapter.BaseBankAdapter
import com.db2testapp.presentation.adapter.NbuAdapter
import com.db2testapp.presentation.adapter.PbAdapter
import com.db2testapp.presentation.adapter.ItemDecoratorBank
import com.db2testapp.databinding.ActivityMainBinding

class MainActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        val binding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)

        binding.includeHeaderPb.textViewBankName.text = getString(R.string.pb_name)
        binding.includeHeaderNbu.textViewBankName.text = getString(R.string.nbu_name)

        binding.includeHeaderPb.imageViewCalendar.setOnClickListener { }
        binding.includeHeaderNbu.imageViewCalendar.setOnClickListener { }

        val viewModel: MainViewModel by viewModels()

        viewModel.liveDataPb.observe(this@MainActivity) {
            val pbAdapter = PbAdapter(it) { currency ->
                setSelectedItem(binding.recyclerViewNbu, currency)
            }
            binding.recyclerViewPb.apply {
                adapter = pbAdapter
                addItemDecoration(ItemDecoratorBank())
            }
        }

        viewModel.liveDataNbu.observe(this@MainActivity) {
            val nbuAdapter = NbuAdapter(it) { currency ->
                setSelectedItem(binding.recyclerViewPb, currency)
            }
            binding.recyclerViewNbu.apply {
                adapter = nbuAdapter
                addItemDecoration(ItemDecoratorBank())
            }
        }
        viewModel.getBankCourses()
    }

    private fun setSelectedItem(recyclerView: RecyclerView, currency: String) {
        val adapter = recyclerView.adapter as BaseBankAdapter
        val itemIndex = adapter.getItemIndexByCurrency(currency)
        if (itemIndex >= 0) {
            recyclerView.scrollToPosition(itemIndex)
            adapter.setItemSelected(itemIndex)
        } else {
            adapter.clearSelection()
        }
    }
}