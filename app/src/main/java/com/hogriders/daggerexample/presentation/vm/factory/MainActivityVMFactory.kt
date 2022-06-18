package com.hogriders.daggerexample.presentation.vm.factory


import androidx.lifecycle.ViewModel
import androidx.lifecycle.ViewModelProvider
import com.hogriders.daggerexample.di.module.UseCaseModule
import com.hogriders.daggerexample.domain.usecase.GetAllUseCase
import com.hogriders.daggerexample.domain.usecase.InsertUseCase
import com.hogriders.daggerexample.presentation.vm.MainActivityViewModel
import javax.inject.Inject

//class MainActivityVMFactory: ViewModelProvider.Factory {
//
//    override fun <T : ViewModel?> create(modelClass: Class<T>): T {
//
////        val useCaseModule = DaggerUseCaseComponent
//
//        return MainActivityViewModel(
//            insertUseCase = insertUseCase,
//            getAllUseCase = getAllUseCase
//        ) as T
//    }
//}