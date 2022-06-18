package com.hogriders.daggerexample.di.module

import android.content.Context
import androidx.room.Room
import com.hogriders.daggerexample.data.storage.local.UsersDatabase
import com.hogriders.daggerexample.data.storage.local.dao.UsersDao
import dagger.Module
import dagger.Provides

@Module(includes = [ContextModule::class])
class RoomModule {
    @Provides
    fun getDatabase(context: Context): UsersDatabase {
        return Room.databaseBuilder(
            context,
            UsersDatabase::class.java,
            "users.db"
        )
            //.allowMainThreadQueries()
            .fallbackToDestructiveMigration()
            .build()
    }

    @Provides
    fun providesDao(usersDatabase: UsersDatabase): UsersDao {
        return usersDatabase.getUsersDao()
    }
}