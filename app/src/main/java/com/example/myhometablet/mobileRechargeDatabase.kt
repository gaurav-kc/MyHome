package com.example.myhometablet

import android.content.Context
import androidx.room.Database
import androidx.room.Room
import androidx.room.RoomDatabase

@Database(entities = [Mobile_recharge::class], version = 1)
abstract class mobileRechargeDatabase : RoomDatabase() {

    abstract val mobileRechargeDAO : mobileRechargeDAO

    companion object{
        @Volatile
        private var INSTANCE : mobileRechargeDatabase ?= null
        fun getInstance(context:Context):mobileRechargeDatabase{
            synchronized(this){
                var instance = INSTANCE
                if(instance == null)
                {
                    //we need to create one
                    instance = Room.databaseBuilder(context.applicationContext,
                        mobileRechargeDatabase::class.java, "HomeDatabase").build()
                }
                return instance
            }
        }
    }
}