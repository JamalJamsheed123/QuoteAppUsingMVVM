package com.example.quoteappusingmvvm_roomdb


import androidx.lifecycle.LiveData
import androidx.lifecycle.ViewModel
import kotlinx.coroutines.*

class MainViewModel(private val quoteRepository: QuoteRepository): ViewModel() {

    fun getQuotes(): LiveData<List<Quote>>{
        return quoteRepository.getQuotes()
    }

    @OptIn(DelicateCoroutinesApi::class)
    fun inserQuote(quote: Quote){
        //Launch Coroutine because its retrieve data from suspend function
        GlobalScope.launch(Dispatchers.IO){

            quoteRepository.insertQuote(quote)
        }
    }

    fun deleteQuoteById(id: Int){
        GlobalScope.launch (Dispatchers.IO){
            quoteRepository.deleteQuoteById(id)
        }
    }
}