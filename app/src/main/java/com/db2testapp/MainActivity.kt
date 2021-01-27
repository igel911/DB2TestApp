package com.db2testapp

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import androidx.activity.viewModels
import com.db2testapp.adapters.PbAdapter
import com.db2testapp.adapters.PbItemDecorator
import com.db2testapp.databinding.ActivityMainBinding

class MainActivity : AppCompatActivity() {

    private lateinit var binding: ActivityMainBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)

        binding.includeHeaderPb.textViewBankName.text = getString(R.string.pb_name)
        binding.includeHeaderNbu.textViewBankName.text = getString(R.string.nbu_name)

        binding.includeHeaderPb.imageViewCalendar.setOnClickListener { }
        binding.includeHeaderNbu.imageViewCalendar.setOnClickListener { }

        val viewModel: MainViewModel by viewModels()
        viewModel.mLiveData.observe(this@MainActivity) {
            binding.recyclerViewPb.apply {
                adapter = PbAdapter(it)
                addItemDecoration(PbItemDecorator())
            }
            binding.recyclerViewNbu.apply {
                adapter = PbAdapter(it)
                addItemDecoration(PbItemDecorator())
            }
        }
        viewModel.getBankCourses()

    }
}