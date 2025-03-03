package com.example.attendance.room

import android.content.Context
import androidx.room.Room
import androidx.room.RoomDatabase

abstract class AppDatabase : RoomDatabase() {
    companion object{
        @Volatile
        private var INSTANCE: AppDatabase? = null
        fun getDatabase(context: Context): AppDatabase{

            return INSTANCE?: synchronized(this){
                INSTANCE?: Room.databaseBuilder(
                    context.applicationContext,
                    AppDatabase::class.java,
                    "user-db").build().also {
                    INSTANCE = it
                }
            }
        }
    }
}