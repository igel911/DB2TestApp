package com.db2testapp

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.db2testapp.model.NbuItem
import com.db2testapp.model.PbItem
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.launch

class MainViewModel : ViewModel() {

    private val _liveDataPb = MutableLiveData<List<PbItem>>()
    val liveDataPb: LiveData<List<PbItem>> = _liveDataPb
    private val _liveDataNbu = MutableLiveData<List<NbuItem>>()
    val liveDataNbu: LiveData<List<NbuItem>> = _liveDataNbu
    private val repository = BankMockRepository.getInstance()

    fun getBankCourses() {
        viewModelScope.launch(Dispatchers.IO) {
            _liveDataPb.postValue(repository.getPBCourses())
            _liveDataNbu.postValue(repository.getNBUCourses())
        }
    }
}