package com.hogriders.daggerexample.di.component

import com.hogriders.daggerexample.data.storage.local.UsersDatabase
import com.hogriders.daggerexample.di.module.RoomDatabaseModule
import com.hogriders.daggerexample.di.scope.DaggerApplicationScope
import dagger.Component

@DaggerApplicationScope
@Component(modules = [RoomDatabaseModule::class])
interface RoomDatabaseComponent{
    fun getRoomDatabase(): UsersDatabase
}