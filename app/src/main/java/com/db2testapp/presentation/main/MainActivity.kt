package com.db2testapp.presentation.main

import android.app.DatePickerDialog
import android.os.Bundle
import android.text.SpannableString
import android.text.style.UnderlineSpan
import android.widget.DatePicker
import android.widget.TextView
import androidx.activity.viewModels
import androidx.appcompat.app.AppCompatActivity
import androidx.recyclerview.widget.RecyclerView
import com.db2testapp.BankApp
import com.db2testapp.R
import com.db2testapp.databinding.ActivityMainBinding
import com.db2testapp.domain.usecase.NbuUseCase
import com.db2testapp.domain.usecase.PbUseCase
import com.db2testapp.presentation.DatePickerFragment
import com.db2testapp.presentation.MainViewModelFactory
import com.db2testapp.presentation.adapter.*


class MainActivity : AppCompatActivity(), DatePickerDialog.OnDateSetListener {

    private lateinit var binding: ActivityMainBinding
    private val viewModel: MainViewModel by viewModels {
        MainViewModelFactory(
            PbUseCase(BankApp.bankApiRepository),
            NbuUseCase(BankApp.bankApiRepository)
        )
    }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)

        binding.includeHeaderPb.textViewBankName.text = getString(R.string.pb_name)
        binding.includeHeaderNbu.textViewBankName.text = getString(R.string.nbu_name)

        binding.includeHeaderPb.imageViewCalendar.setOnClickListener {
            DatePickerFragment().show(supportFragmentManager, "datePickerPb")
        }
        binding.includeHeaderNbu.imageViewCalendar.setOnClickListener {
            DatePickerFragment().show(supportFragmentManager, "datePickerNbu")

        }

        val pbAdapter = PbAdapter { currency ->
            setSelectedItem(binding.recyclerViewNbu, currency)
        }
        binding.recyclerViewPb.apply {
            adapter = pbAdapter
            addItemDecoration(ItemDecoratorBank())
        }

        val nbuAdapter = NbuAdapter { currency ->
            setSelectedItem(binding.recyclerViewPb, currency)
        }
        binding.recyclerViewNbu.apply {
            adapter = nbuAdapter
            addItemDecoration(ItemDecoratorBank())
        }

        viewModel.liveDataPb.observe(this@MainActivity) { pbAdapter.setList(it) }
        viewModel.liveDataNbu.observe(this@MainActivity) { nbuAdapter.setList(it) }

        viewModel.getBankCourses()
    }

    override fun onDateSet(view: DatePicker, year: Int, month: Int, day: Int) {
        setDateToTextView(binding.includeHeaderPb.textViewDate, year, month, day)
        setDateToTextView(binding.includeHeaderNbu.textViewDate, year, month, day)
        viewModel.getBankCoursesByDate(year, month, day)
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

    private fun setDateToTextView(textView: TextView, year: Int, month: Int, day: Int) {
        val content = SpannableString("$day.${month + 1}.$year")
        content.setSpan(UnderlineSpan(), 0, content.length, 0)
        textView.text = content
    }
}