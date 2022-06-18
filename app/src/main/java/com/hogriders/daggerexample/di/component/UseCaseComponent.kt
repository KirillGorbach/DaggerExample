package com.hogriders.daggerexample.di.component

import com.hogriders.daggerexample.di.module.UseCaseModule
import com.hogriders.daggerexample.domain.usecase.DeleteAllUseCase
import com.hogriders.daggerexample.domain.usecase.GetAllUseCase
import com.hogriders.daggerexample.domain.usecase.GetOldUseCase
import com.hogriders.daggerexample.domain.usecase.InsertUseCase
import dagger.Component
import javax.inject.Singleton

@Singleton
@Component(modules = [UseCaseModule::class])
interface UseCaseComponent {

    fun getAllUseCase(): GetAllUseCase
    fun getOldUseCase(): GetOldUseCase
    fun getInsertUseCase(): InsertUseCase
    fun getDeleteAllUseCase(): DeleteAllUseCase
}