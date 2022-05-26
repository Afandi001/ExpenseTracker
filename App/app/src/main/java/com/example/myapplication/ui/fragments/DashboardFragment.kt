package com.example.myapplication.ui.fragments

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.navigation.fragment.findNavController
import androidx.recyclerview.widget.ItemTouchHelper
import androidx.recyclerview.widget.RecyclerView
import com.example.myapplication.R
import com.example.myapplication.databinding.FragmentDashboardBinding
import com.example.myapplication.room.entity.Transactions
import com.example.myapplication.ui.adapter.TransactionAdapter
import com.example.myapplication.ui.presenters.DashboardPresenter
import com.example.myapplication.ui.presenters.IMainView

class DashboardFragment : Fragment(), IMainView {

    private lateinit var binding: FragmentDashboardBinding
    private lateinit var presenter: DashboardPresenter
    private var adapter: TransactionAdapter? = null

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {

        binding = FragmentDashboardBinding.inflate(inflater, container, false)
        presenter = DashboardPresenter(this)

        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        binding.addBtn.setOnClickListener {
            openAddFragment()
        }
    }

    override fun setRecyclerView(array: List<Transactions>?) {
        adapter = TransactionAdapter(array as List<Transactions>)
        binding.recyclerview.adapter = adapter
        val balance = array.map { it.amount }.sum()
        val budget = array.filter { it.amount > 0 }.map { it.amount }.sum()
        val expense = balance - budget
        binding.balance.text = "$ %.2f".format(balance)
        binding.budget.text = "$ %.2f".format(budget)
        binding.expense.text = "$ %.2f".format(expense)

    }

    private fun openAddFragment(){

        findNavController().navigate(R.id.action_dashboardFragment_to_addTransactionFragment)

    }
}