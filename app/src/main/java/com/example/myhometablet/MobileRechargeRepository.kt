package com.example.myhometablet

class MobileRechargeRepository(private val mobileRechargeDAO: mobileRechargeDAO) {
    val recharges = mobileRechargeDAO.getAllRecharges()

    suspend fun insertRecharge(mobileRecharge: Mobile_recharge){
        mobileRechargeDAO.insertMobileRecharge(mobileRecharge)
    }

    suspend fun updateRecharge(mobileRecharge: Mobile_recharge){
        mobileRechargeDAO.updateMobileRecharge(mobileRecharge)
    }

    suspend fun deleteRecharge(mobileRecharge: Mobile_recharge){
        mobileRechargeDAO.deleteMobileRecharge(mobileRecharge)
    }

    suspend fun deleteAllRecharges(){
        mobileRechargeDAO.deleteAllRecharges()
    }
}