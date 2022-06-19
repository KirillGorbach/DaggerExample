package com.hogriders.di.component

import com.hogriders.di.module.UseCaseModule
import com.hogriders.domain.usecase.DeleteAllUseCase
import com.hogriders.domain.usecase.GetAllUseCase
import com.hogriders.domain.usecase.GetOldUseCase
import com.hogriders.domain.usecase.InsertUseCase
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