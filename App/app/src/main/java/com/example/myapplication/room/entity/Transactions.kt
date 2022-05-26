package com.example.myapplication.room.entity

import androidx.room.Entity
import androidx.room.PrimaryKey
import java.io.Serializable


@Entity(tableName = "transactions")
data class Transactions(
    @PrimaryKey(autoGenerate = true)
    var id: Int,
    var label: String,
    var amount: Double
): Serializable
