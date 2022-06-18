package com.hogriders.daggerexample.di.module

import com.hogriders.daggerexample.domain.repository.UserRepository
import com.hogriders.daggerexample.domain.usecase.DeleteAllUseCase
import com.hogriders.daggerexample.domain.usecase.GetAllUseCase
import com.hogriders.daggerexample.domain.usecase.GetOldUseCase
import com.hogriders.daggerexample.domain.usecase.InsertUseCase
import dagger.Module
import dagger.Provides


@Module(includes = [UserRepositoryModule::class])
class UseCaseModule {

    @Provides
    fun providesGetAllUseCase(userRepository: UserRepository): GetAllUseCase {
        return GetAllUseCase(userRepository)
    }

    @Provides
    fun providesInsertUseCase(userRepository: UserRepository): InsertUseCase {
        return InsertUseCase(userRepository)
    }

    @Provides
    fun providesGetOldUseCase(userRepository: UserRepository): GetOldUseCase {
        return GetOldUseCase(userRepository)
    }

    @Provides
    fun providesDeleteAllUseCase(userRepository: UserRepository): DeleteAllUseCase {
        return DeleteAllUseCase(userRepository)
    }
}