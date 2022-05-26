package com.example.myapplication.ui.presenters

import com.example.myapplication.room.entity.Transactions

interface IDashboardPresenter {

    fun getAllTransactions(): List<Transactions>
    fun fetch()
}