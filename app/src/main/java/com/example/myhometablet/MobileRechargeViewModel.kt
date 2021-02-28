package com.example.myhometablet

import androidx.databinding.Bindable
import androidx.databinding.Observable
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import kotlinx.coroutines.launch

class MobileRechargeViewModel(private val mobileRechargeRepository: MobileRechargeRepository) : ViewModel(), Observable {

    val recharges = mobileRechargeRepository.recharges

    @Bindable
    val mobileNumber = MutableLiveData<String>()

    @Bindable
    val amount = MutableLiveData<String>()

    @Bindable
    val paidBy = MutableLiveData<String>()

    @Bindable
    val addOrUpdate = MutableLiveData<String>()

    @Bindable
    val ClearAllOrDelete = MutableLiveData<String>()

    fun addOrUpdate()
    {
        val MobileNum = mobileNumber.value!!
        val amt = amount.value!!
        val paidby = paidBy.value!!
        val simple_recharge = Mobile_recharge(mobileNumber = MobileNum, amount = Integer.parseInt(amt), paidBy = paidby)
        insertRecharge(simple_recharge)
    }

    fun clearAllorDelete()
    {
        clearAllRecharges()
    }

    fun insertRecharge(mobileRecharge: Mobile_recharge) = viewModelScope.launch { mobileRechargeRepository.insertRecharge(mobileRecharge) }

    fun updateRecharge(mobileRecharge: Mobile_recharge) = viewModelScope.launch { mobileRechargeRepository.updateRecharge(mobileRecharge) }

    fun clearAllRecharges() = viewModelScope.launch { mobileRechargeRepository.deleteAllRecharges() }

    fun deleteRecharge(mobileRecharge: Mobile_recharge) = viewModelScope.launch { mobileRechargeRepository.deleteRecharge(mobileRecharge) }

    override fun addOnPropertyChangedCallback(callback: Observable.OnPropertyChangedCallback?) {}

    override fun removeOnPropertyChangedCallback(callback: Observable.OnPropertyChangedCallback?) {}

    init {
        addOrUpdate.value = "Add"
        ClearAllOrDelete.value = "Clear All"
    }

}