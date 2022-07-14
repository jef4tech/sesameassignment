package com.example.sesameassignment.ViewModel

import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.example.sesameassignment.model.Customer
import com.example.sesameassignment.network.RestApiImpl
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.launch
import kotlinx.coroutines.withContext

class CustomerViewModel : ViewModel() {
    var customers= MutableLiveData<Customer>()
    val loading = MutableLiveData<Boolean>()
    val errorMessage = MutableLiveData<String>()
    fun getAllCustomers(){
        viewModelScope.launch {
            val response= RestApiImpl.getCustomers()
            withContext(Dispatchers.Main){
                if (response.isSuccessful){
                    customers.postValue(response.body())
                    loading.postValue(false)
                }
                else {
                    onError("Error ${response.message()}")
                }
            }
        }
    }
//    fun insertUser(){
//        viewModelScope.launch {
//            val response= RestApiImpl.getCustomers()
//            withContext(Dispatchers.Main){
//                if (response.isSuccessful){
//                    customers.postValue(response.body())
//                    loading.postValue(false)
//                }
//                else {
//                    onError("Error ${response.message()}")
//                }
//            }
//        }
//    }
    private fun onError(message: String) {
        errorMessage.value = message
        loading.value = false
    }
}