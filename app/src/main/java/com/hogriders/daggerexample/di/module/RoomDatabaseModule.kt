package com.hogriders.daggerexample.di.module

import android.content.Context
import androidx.room.Room
import com.hogriders.daggerexample.db.UsersDatabase
import com.hogriders.daggerexample.di.qualifier.ApplicationContext
import com.hogriders.daggerexample.di.scope.DaggerApplicationScope
import dagger.Module
import dagger.Provides

@Module(includes = [ContextModule::class])
class RoomDatabaseModule {
    @DaggerApplicationScope
    @Provides
    fun getRoomDatabase(@ApplicationContext context: Context): UsersDatabase {
        return Room.databaseBuilder(
            context,
            UsersDatabase::class.java,
            "users.db"
        )
            //.allowMainThreadQueries()
            .fallbackToDestructiveMigration()
            .build()
    }
}