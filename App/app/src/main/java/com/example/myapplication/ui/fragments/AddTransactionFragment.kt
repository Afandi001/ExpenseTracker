package com.example.myapplication.ui.fragments

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.navigation.fragment.findNavController
import com.example.myapplication.R
import com.example.myapplication.databinding.FragmentAddTransactionBinding
import com.example.myapplication.room.entity.Transactions
import com.example.myapplication.ui.presenters.AddPresenter

class AddTransactionFragment : Fragment() {

    private lateinit var binding: FragmentAddTransactionBinding

    private val presenter by lazy { AddPresenter() }

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {

        binding = FragmentAddTransactionBinding.inflate(inflater, container, false)

        return binding.root

    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        binding.btnSave.setOnClickListener {
            val transaction = Transactions(
                0,
                binding.label.text.toString(),
                binding.amount.text.toString().toDouble(),
            )
            presenter.insert(transaction)
            findNavController().navigate(R.id.action_addTransactionFragment_to_dashboardFragment)
        }
    }
}