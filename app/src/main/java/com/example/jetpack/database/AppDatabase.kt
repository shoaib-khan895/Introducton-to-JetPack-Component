package com.example.jetpack.database

import androidx.room.Database
import androidx.room.RoomDatabase
import com.example.jetpack.PersonDataClass

@Database(entities = [PersonDataClass::class], version = 2)
abstract class AppDatabase: RoomDatabase() {
    abstract fun personDao() : PersonDao
}