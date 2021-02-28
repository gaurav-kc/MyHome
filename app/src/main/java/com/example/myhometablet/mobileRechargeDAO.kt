package com.example.myhometablet

import androidx.lifecycle.LiveData
import androidx.room.*
// need to add other DAO here
@Dao
interface mobileRechargeDAO {
    //insert update delete query to delete all and query to get all
    @Insert
    suspend fun insertMobileRecharge(mobileRecharge: Mobile_recharge) : Long

    @Update
    suspend fun updateMobileRecharge(mobileRecharge: Mobile_recharge)

    @Delete
    suspend fun deleteMobileRecharge(mobileRecharge: Mobile_recharge)

    @Query("Delete From mobile_recharge_history")
    suspend fun deleteAllRecharges()

    @Query("Select * from mobile_recharge_history")
    fun getAllRecharges() : LiveData<List<Mobile_recharge>>
}