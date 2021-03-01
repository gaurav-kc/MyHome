package com.example.myhometablet

import android.icu.number.IntegerWidth
import android.widget.Toast
import androidx.databinding.Bindable
import androidx.databinding.Observable
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import kotlinx.coroutines.launch

class MobileRechargeViewModel(private val mobileRechargeRepository: MobileRechargeRepository) : ViewModel(), Observable {

    val recharges = mobileRechargeRepository.recharges
    private var updateOrDelete = false
    private lateinit var currentRecharge : Mobile_recharge

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
        val mobNo = mobileNumber.value!!.trim()
        val amt = amount.value!!.trim()
        val paidby = paidBy.value!!.trim()
        if(mobNo!="" && amt!="" && paidby!="")
        {
            if(updateOrDelete){
                //update the entry
                currentRecharge.mobileNumber = mobNo
                currentRecharge.amount = Integer.parseInt(amt)
                currentRecharge.paidBy = paidby
                updateRecharge(currentRecharge)
            }else{
                //insert an entry
                val recharge = Mobile_recharge(0,mobNo, Integer.parseInt(amt), paidby)
                insertRecharge(recharge)
            }
        }
        mobileNumber.value = ""
        amount.value = ""
        paidBy.value = ""
        addOrUpdate.value = "Add"
        ClearAllOrDelete.value = "Clear All"
        updateOrDelete = false
    }
//    function no longer in use as the common button for clear all and delete was removed
//    fun clearAllorDelete()
//    {
//        if(updateOrDelete){
//            deleteRecharge(currentRecharge)
//        }else{
//            clearAllRecharges()
//        }
//        mobileNumber.value = ""
//        amount.value = ""
//        paidBy.value = ""
//        addOrUpdate.value = "Add"
//        ClearAllOrDelete.value = "Clear All"
//        updateOrDelete = false
//    }

    fun insertRecharge(mobileRecharge: Mobile_recharge) = viewModelScope.launch { mobileRechargeRepository.insertRecharge(mobileRecharge) }

    fun updateRecharge(mobileRecharge: Mobile_recharge) = viewModelScope.launch { mobileRechargeRepository.updateRecharge(mobileRecharge) }

    fun clearAllRecharges() = viewModelScope.launch { mobileRechargeRepository.deleteAllRecharges() }

    fun deleteRecharge(mobileRecharge: Mobile_recharge) = viewModelScope.launch { mobileRechargeRepository.deleteRecharge(mobileRecharge) }

    fun setUpdateOrDeleteMode(mobileRecharge: Mobile_recharge){
        updateOrDelete = true
        mobileNumber.value = mobileRecharge.mobileNumber
        amount.value = mobileRecharge.amount.toString()
        paidBy.value = mobileRecharge.paidBy
        addOrUpdate.value = "Update"
        ClearAllOrDelete.value = "Delete"
        currentRecharge = mobileRecharge
    }

    override fun addOnPropertyChangedCallback(callback: Observable.OnPropertyChangedCallback?) {}

    override fun removeOnPropertyChangedCallback(callback: Observable.OnPropertyChangedCallback?) {}

    init {
        addOrUpdate.value = "Add"
        ClearAllOrDelete.value = "Clear All"
    }

}