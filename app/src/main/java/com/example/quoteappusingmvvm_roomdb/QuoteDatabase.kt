package com.example.quoteappusingmvvm_roomdb

import android.content.Context
import androidx.room.Database
import androidx.room.Entity
import androidx.room.Room
import androidx.room.RoomDatabase

@Database(entities = [Quote::class], version = 1)
abstract class QuoteDatabase : RoomDatabase() {

    abstract fun quoteDao(): QuoteDao

    //Create database Instance
    companion object {
        private var INSTANCE: QuoteDatabase? = null
        fun getDataBase(context: Context): QuoteDatabase{
            if (INSTANCE == null){
                synchronized(this){
                    INSTANCE = Room.databaseBuilder(
                        context,
                        QuoteDatabase::class.java,
                        "quote_database"
                    )
                        //Prepopulated means that to Insert All record from assets file to Room Database
                        .createFromAsset("quotes.db")
                        .build()
                }
            }
            return INSTANCE!!
        }
    }
}