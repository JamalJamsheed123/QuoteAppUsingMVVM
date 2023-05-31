package com.example.quoteappusingmvvm_roomdb

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import androidx.databinding.DataBindingUtil
import androidx.lifecycle.ViewModelProvider
import com.example.quoteappusingmvvm_roomdb.databinding.ActivityMainBinding

class MainActivity : AppCompatActivity() {

    lateinit var binding: ActivityMainBinding
    lateinit var mainViewModel: MainViewModel
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = DataBindingUtil.setContentView(this, R.layout.activity_main)

        val dao = QuoteDatabase.getDataBase(applicationContext).quoteDao()
        val repository = QuoteRepository(dao)
        mainViewModel =
            ViewModelProvider(this, MainViewModelFactory(repository)).get(MainViewModel::class.java)

        mainViewModel.getQuotes().observe(this, {
            binding.quotes = it.toString()
        })
        binding.btnAddQuote.setOnClickListener {
            val quote = Quote(0,"This is Testing","Testing")
            mainViewModel.inserQuote(quote )
        }
        binding.btnDeleteQuote.setOnClickListener{
            mainViewModel.deleteQuoteById(104)
        }
    }
}