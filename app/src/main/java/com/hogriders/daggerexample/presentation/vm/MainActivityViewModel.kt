package com.hogriders.daggerexample.presentation.vm

import android.app.Application
import androidx.lifecycle.AndroidViewModel
import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import com.hogriders.daggerexample.di.component.DaggerUseCaseComponent
import com.hogriders.daggerexample.di.module.ContextModule
import com.hogriders.daggerexample.domain.model.User
import com.hogriders.daggerexample.domain.usecase.GetAllUseCase
import com.hogriders.daggerexample.domain.usecase.InsertUseCase
import io.reactivex.rxjava3.android.schedulers.AndroidSchedulers
import io.reactivex.rxjava3.core.Observable
import io.reactivex.rxjava3.schedulers.Schedulers

class MainActivityViewModel(app: Application): AndroidViewModel(app) {

    val users: LiveData<List<User>>
        get() =_users
    private val _users = MutableLiveData<List<User>>()

    private var getAllUseCase: GetAllUseCase
    private var insertUseCase: InsertUseCase

    init {
        val useCaseComponent = DaggerUseCaseComponent.builder()
            .contextModule(ContextModule(getApplication<Application>().applicationContext))
            .build()
        getAllUseCase = useCaseComponent.getAllUseCase()
        insertUseCase = useCaseComponent.getInsertUseCase()

        getAllUsers()
    }

    fun getAllUsers(){
        getAllUseCase.invoke()
            .subscribeOn(Schedulers.io())
            .observeOn(AndroidSchedulers.mainThread())
            .subscribe { _users.value = it }
    }

    fun insertUser(user: User){
        Observable.fromCallable {
            insertUseCase.invoke(user)
        }   .subscribeOn(Schedulers.io())
            .observeOn(AndroidSchedulers.mainThread())
            .subscribe{
                getAllUsers()
            }
    }

}