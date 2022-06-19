package com.hogriders.di.component

import com.hogriders.data.storage.local.UsersDatabase
import com.hogriders.data.storage.local.dao.UsersDao
import com.hogriders.di.module.RoomModule
import dagger.Component

//@Component(modules = [RoomModule::class])
//interface RoomComponent{
//    fun getRoomDatabase(): UsersDatabase
//    fun getDao(): UsersDao
//}