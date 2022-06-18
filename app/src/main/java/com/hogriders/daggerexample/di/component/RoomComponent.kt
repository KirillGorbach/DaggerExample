package com.hogriders.daggerexample.di.component

import com.hogriders.daggerexample.data.storage.local.UsersDatabase
import com.hogriders.daggerexample.data.storage.local.dao.UsersDao
import com.hogriders.daggerexample.di.module.RoomModule
import dagger.Component

//@Component(modules = [RoomModule::class])
//interface RoomComponent{
//    fun getRoomDatabase(): UsersDatabase
//    fun getDao(): UsersDao
//}