package com.hogriders.daggerexample.di.module

import com.hogriders.daggerexample.data.storage.local.dao.UsersDao
import com.hogriders.daggerexample.data.storage.repository.UserRepositoryImpl
import com.hogriders.daggerexample.domain.repository.UserRepository
import dagger.Module
import dagger.Provides


@Module(includes = [RoomModule::class])
class UserRepositoryModule {
    @Provides
    fun providesUserRepository(usersDao: UsersDao): UserRepository {
        return UserRepositoryImpl(usersDao)
    }
}