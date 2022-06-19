package com.hogriders.data.storage.local

import androidx.room.Database
import androidx.room.RoomDatabase
import com.hogriders.data.storage.local.dao.UsersDao
import com.hogriders.data.storage.local.model.UserDB

@Database(entities = [UserDB::class], version = 1, exportSchema = false)
abstract class UsersDatabase : RoomDatabase() {
    abstract fun getUsersDao(): UsersDao
}