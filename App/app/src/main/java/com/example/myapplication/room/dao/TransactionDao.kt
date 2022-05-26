package com.example.myapplication.room.dao

import androidx.room.*
import com.example.myapplication.room.entity.Transactions

@Dao
interface TransactionDao {

    @Query("SELECT * from transactions")
    fun getAll(): List<Transactions>

    @Insert
    fun insert(vararg transactions: Transactions)

    @Delete
    fun delete(transactions: Transactions)

    @Update
    fun update(vararg transactions: Transactions)

}