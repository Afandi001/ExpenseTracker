package com.example.myapplication.ui.presenters

import com.example.myapplication.room.entity.Transactions

interface IMainView {
    fun setRecyclerView(array: List<Transactions>?)

}