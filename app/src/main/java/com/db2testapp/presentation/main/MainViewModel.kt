package com.db2testapp.presentation.main

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.db2testapp.data.vo.NbuItem
import com.db2testapp.data.vo.PbItem
import com.db2testapp.domain.usecase.NbuUseCase
import com.db2testapp.domain.usecase.PbUseCase
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.launch

class MainViewModel(
    private val pbUseCase: PbUseCase,
    private val nbuUseCase: NbuUseCase
) : ViewModel() {

    private val _liveDataPb = MutableLiveData<List<PbItem>>()
    val liveDataPb: LiveData<List<PbItem>> = _liveDataPb
    private val _liveDataNbu = MutableLiveData<List<NbuItem>>()
    val liveDataNbu: LiveData<List<NbuItem>> = _liveDataNbu

    fun getBankCourses() {
        viewModelScope.launch(Dispatchers.IO) {
            _liveDataPb.postValue(pbUseCase.getPbItems())
            _liveDataNbu.postValue(nbuUseCase.getNbuItems())
        }
    }

    fun getBankCoursesByDate(year: Int, month: Int, day: Int) {
        viewModelScope.launch(Dispatchers.IO) {
            _liveDataPb.postValue(pbUseCase.getPbItems(year, month, day))
            _liveDataNbu.postValue(nbuUseCase.getNbuItems(year, month, day))
        }
    }
}