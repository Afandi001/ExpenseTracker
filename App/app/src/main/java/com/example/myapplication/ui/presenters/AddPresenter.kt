package com.example.myapplication.ui.presenters

import com.example.myapplication.room.entity.Transactions
import com.example.myapplication.ui.repository.Repository

class AddPresenter: IAddPresenter {
    private val repository = Repository()

    override fun insert(transaction: Transactions) {
        repository.insert(transaction)
    }

    override fun deleteItemFromDatabase(transaction: Transactions) {
        repository.deleteItemFromDatabase(transaction)
    }

    override fun updateItemFromDatabase(transaction: Transactions) {
        repository.updateItemDatabase(transaction)
    }
}