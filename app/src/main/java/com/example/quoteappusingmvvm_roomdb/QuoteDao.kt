package com.example.quoteappusingmvvm_roomdb

import androidx.lifecycle.LiveData
import androidx.room.Dao
import androidx.room.Insert
import androidx.room.Query

@Dao
interface QuoteDao {

    @Query("SELECT * from quote")
    fun getQuotes(): LiveData<List<Quote>>

    @Insert
    suspend fun insertQuote(quote: Quote)

    @Query("DELETE FROM quote WHERE id = :id")
    fun deleteQuoteById(id: Int)
}