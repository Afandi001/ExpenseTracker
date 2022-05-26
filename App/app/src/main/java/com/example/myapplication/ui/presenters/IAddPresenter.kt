package com.example.myapplication.ui.presenters

import com.example.myapplication.room.entity.Transactions

interface IAddPresenter {
    fun insert(transaction: Transactions)
    fun deleteItemFromDatabase(transaction: Transactions)
    fun updateItemFromDatabase(transaction: Transactions)
}