package com.example.myhometablet

import androidx.lifecycle.ViewModel
import androidx.lifecycle.ViewModelProvider
import java.lang.IllegalArgumentException

class MobileRechargeVMFactory(private val repository: MobileRechargeRepository): ViewModelProvider.Factory{
    override fun <T : ViewModel?> create(modelClass: Class<T>): T {
        if(modelClass.isAssignableFrom(MobileRechargeViewModel::class.java))
            return MobileRechargeViewModel(repository) as T
        throw IllegalArgumentException("Unknown view model class")
    }

}