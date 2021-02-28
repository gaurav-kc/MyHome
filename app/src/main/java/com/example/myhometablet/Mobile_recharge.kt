package com.example.myhometablet

import androidx.room.ColumnInfo
import androidx.room.Entity
import androidx.room.PrimaryKey

@Entity(tableName = "mobile_recharge_history")
data class Mobile_recharge(
    @PrimaryKey()
    @ColumnInfo(name = "mobile_number")
    val mobileNumber: String,

    @ColumnInfo(name = "amount_paid")
    val amount: Int,

    @ColumnInfo(name = "paid_by")
    val paidBy: String
)
