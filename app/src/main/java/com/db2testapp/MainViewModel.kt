package com.db2testapp

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.launch

class MainViewModel : ViewModel() {

    private val _mLiveData = MutableLiveData<List<PbItem>>()
    val mLiveData: LiveData<List<PbItem>> = _mLiveData
    private val repository = BankMockRepository.getInstance()

    fun getBankCourses() {
        viewModelScope.launch(Dispatchers.IO) {
            val list = repository.getBankCourses()
            _mLiveData.postValue(list)
        }
    }
}