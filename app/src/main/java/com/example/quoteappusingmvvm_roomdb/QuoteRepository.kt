package com.example.quoteappusingmvvm_roomdb

import androidx.lifecycle.LiveData

//Provide Clear Interface which help to talk Data sources
class QuoteRepository(private val quoteDao: QuoteDao) {

    fun getQuotes(): LiveData<List<Quote>>{
        return quoteDao.getQuotes()
    }

    suspend fun insertQuote(quote: Quote){
        quoteDao.insertQuote(quote)
    }

    suspend fun deleteQuoteById(id:Int) {
        quoteDao.deleteQuoteById(id)
    }
}