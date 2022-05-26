package com.example.myapplication.ui.presenters

import com.example.myapplication.room.entity.Transactions
import com.example.myapplication.ui.repository.Repository

class DashboardPresenter(private val iMainView: IMainView): IDashboardPresenter {

    private val repository = Repository()

    init {
        getAllTransactions()
        fetch()
    }

    override fun getAllTransactions(): List<Transactions> {
        return repository.getAllTransaction()

    }

    override fun fetch() {
        iMainView.setRecyclerView(getAllTransactions())
    }
}