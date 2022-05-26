package com.example.myapplication.ui.repository

import com.example.myapplication.App
import com.example.myapplication.room.entity.Transactions

class Repository {

    private val db = App.instance
    private val dao = db?.getDatabase()?.transactionDao()

    init {
        getAllTransaction()
    }

    fun insert(transaction: Transactions) {
        dao?.insert(transaction)
    }

    fun getAllTransaction(): List<Transactions> {
        return dao!!.getAll()
    }

    fun deleteItemFromDatabase(transaction: Transactions) {
        dao?.delete(transaction)
    }

    fun updateItemDatabase(transaction: Transactions) {
        dao?.update(transaction)
    }

}