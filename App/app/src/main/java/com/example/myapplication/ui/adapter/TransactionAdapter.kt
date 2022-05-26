package com.example.myapplication.ui.adapter

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.TextView
import androidx.core.content.ContextCompat
import androidx.navigation.findNavController
import androidx.recyclerview.widget.RecyclerView
import com.example.myapplication.R
import com.example.myapplication.room.entity.Transactions

class TransactionAdapter(private var transactions: List<Transactions>):
    RecyclerView.Adapter<TransactionAdapter.TransactionViewHolder>() {

     class TransactionViewHolder(view: View): RecyclerView.ViewHolder(view){

        val label : TextView = view.findViewById(R.id.label)
        val amount : TextView = view.findViewById(R.id.amount)

    }
    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): TransactionViewHolder {

        val view = LayoutInflater.from(parent.context).inflate(R.layout.transaction_layout, parent, false)
        return TransactionViewHolder(view)

    }
    override fun onBindViewHolder(holder: TransactionViewHolder, position: Int) {
        var transaction = transactions[position]
        val context = holder.amount.context
        holder.label.text = transaction.label
        if(transaction.amount >= 0){
            holder.amount.text = "+ $%.2f".format(transaction.amount)
            holder.amount.setTextColor(ContextCompat.getColor(context, R.color.green))
        }else {
            holder.amount.text = "- $%.2f".format(Math.abs(transaction.amount))
            holder.amount.setTextColor(ContextCompat.getColor(context, R.color.red))
        }
    }

    override fun getItemCount(): Int {
        return transactions.size
    }

}