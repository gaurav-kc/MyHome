package com.example.myhometablet

import androidx.room.ColumnInfo
import androidx.room.Entity
import androidx.room.PrimaryKey

@Entity(tableName = "mobile_recharge_history")
data class Mobile_recharge(
    @PrimaryKey(autoGenerate = true)
    @ColumnInfo(name = "row_id")
    var entryid: Long,

    @ColumnInfo(name = "mobile_number")
    var mobileNumber: String,

    @ColumnInfo(name = "amount_paid")
    var amount: Int,

    @ColumnInfo(name = "paid_by")
    var paidBy: String
)
