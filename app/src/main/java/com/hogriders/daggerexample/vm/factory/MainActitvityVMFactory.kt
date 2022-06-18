package com.hogriders.daggerexample.vm.factory


import androidx.lifecycle.ViewModel
import androidx.lifecycle.ViewModelProvider
import com.hogriders.daggerexample.domain.usecase.GetAllUseCase
import com.hogriders.daggerexample.domain.usecase.InsertUseCase
import com.hogriders.daggerexample.vm.MainActivityViewModel
import javax.inject.Inject

class MainActitvityVMFactory @Inject constructor(
    val insertUseCase: InsertUseCase,
    val getAllUseCase: GetAllUseCase
): ViewModelProvider.Factory {

    override fun <T : ViewModel?> create(modelClass: Class<T>): T {
        return MainActivityViewModel(
            insertUseCase = insertUseCase,
            getAllUseCase = getAllUseCase
        ) as T
    }
}