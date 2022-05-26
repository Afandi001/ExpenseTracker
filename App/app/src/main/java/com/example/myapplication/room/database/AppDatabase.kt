package com.example.myapplication.room.database

import androidx.room.Database
import androidx.room.RoomDatabase
import com.example.myapplication.room.dao.TransactionDao
import com.example.myapplication.room.entity.Transactions

@Database(entities = arrayOf(Transactions::class), version = 2, exportSchema = false)
abstract class AppDatabase: RoomDatabase() {
    abstract fun transactionDao(): TransactionDao
}