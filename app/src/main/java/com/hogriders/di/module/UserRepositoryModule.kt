package com.hogriders.di.module

import com.hogriders.data.storage.local.dao.UsersDao
import com.hogriders.data.storage.repository.UserRepositoryImpl
import com.hogriders.domain.repository.UserRepository
import dagger.Module
import dagger.Provides


@Module(includes = [RoomModule::class])
class UserRepositoryModule {
    @Provides
    fun providesUserRepository(usersDao: UsersDao): UserRepository {
        return UserRepositoryImpl(usersDao)
    }
}