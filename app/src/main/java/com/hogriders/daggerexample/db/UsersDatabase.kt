package com.hogriders.daggerexample.db

import androidx.room.Database
import androidx.room.RoomDatabase
import com.hogriders.daggerexample.db.dao.UsersDao
import com.hogriders.daggerexample.db.model.UserDB

@Database(entities = [UserDB::class], version = 1, exportSchema = false)
abstract class UsersDatabase : RoomDatabase() {
    abstract fun getUsersDao(): UsersDao
}