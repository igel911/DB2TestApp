package com.db2testapp.presentation.main

import android.app.DatePickerDialog
import android.os.Bundle
import android.text.SpannableString
import android.text.style.UnderlineSpan
import android.widget.DatePicker
import android.widget.TextView
import androidx.lifecycle.ViewModelProvider
import androidx.recyclerview.widget.RecyclerView
import com.db2testapp.R
import com.db2testapp.databinding.ActivityMainBinding
import com.db2testapp.presentation.DatePickerFragment
import com.db2testapp.presentation.adapter.*
import dagger.android.support.DaggerAppCompatActivity
import javax.inject.Inject


class MainActivity : DaggerAppCompatActivity(), DatePickerDialog.OnDateSetListener {

    private lateinit var binding: ActivityMainBinding

    @Inject
    lateinit var viewModelFactory: ViewModelProvider.Factory
    lateinit var viewModel: MainViewModel

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)

        viewModel = ViewModelProvider(this, viewModelFactory)
            .get(MainViewModel::class.java)

        with(binding) {
            includeHeaderPb.textViewBankName.text = getString(R.string.pb_name)
            includeHeaderNbu.textViewBankName.text = getString(R.string.nbu_name)

            includeHeaderPb.imageViewCalendar.setOnClickListener {
                DatePickerFragment().show(supportFragmentManager, "datePickerPb")
            }
            includeHeaderNbu.imageViewCalendar.setOnClickListener {
                DatePickerFragment().show(supportFragmentManager, "datePickerNbu")

            }

            val pbAdapter = PbAdapter { currency ->
                setSelectedItem(recyclerViewNbu, currency)
            }
            recyclerViewPb.apply {
                adapter = pbAdapter
                addItemDecoration(ItemDecoratorBank())
            }

            val nbuAdapter = NbuAdapter { currency ->
                setSelectedItem(recyclerViewPb, currency)
            }
            recyclerViewNbu.apply {
                adapter = nbuAdapter
                addItemDecoration(ItemDecoratorBank())
            }

            viewModel.liveDataPb.observe(this@MainActivity) { pbAdapter.setList(it) }
            viewModel.liveDataNbu.observe(this@MainActivity) { nbuAdapter.setList(it) }
        }

        viewModel.getBankCourses()
    }

    override fun onDateSet(view: DatePicker, year: Int, month: Int, day: Int) {
        with(binding) {
            setDateToTextView(includeHeaderPb.textViewDate, year, month, day)
            setDateToTextView(includeHeaderNbu.textViewDate, year, month, day)
            viewModel.getBankCoursesByDate(year, month, day)
        }
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