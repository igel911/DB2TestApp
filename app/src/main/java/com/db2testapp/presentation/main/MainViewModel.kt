package com.db2testapp.presentation.main

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.db2testapp.data.vo.NbuItem
import com.db2testapp.data.vo.PbItem
import com.db2testapp.domain.usecase.BankUseCase
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.launch

class MainViewModel(private val useCase: BankUseCase) : ViewModel() {

    private val _liveDataPb = MutableLiveData<List<PbItem>>()
    val liveDataPb: LiveData<List<PbItem>> = _liveDataPb
    private val _liveDataNbu = MutableLiveData<List<NbuItem>>()
    val liveDataNbu: LiveData<List<NbuItem>> = _liveDataNbu

    fun getBankCourses() {
        viewModelScope.launch(Dispatchers.IO) {
            _liveDataPb.postValue(useCase.getPbItems())
            _liveDataNbu.postValue(useCase.getNbuItems())
        }
    }

    fun getBankCoursesByDate(year: Int, month: Int, day: Int) {
        viewModelScope.launch(Dispatchers.IO) {
            _liveDataPb.postValue(useCase.getPbItems(year, month, day))
            _liveDataNbu.postValue(useCase.getNbuItems(year, month, day))
        }
    }
}