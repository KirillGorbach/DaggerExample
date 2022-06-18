package com.hogriders.daggerexample.vm

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.Observer
import androidx.lifecycle.ViewModel
import com.hogriders.daggerexample.domain.model.User
import com.hogriders.daggerexample.domain.usecase.GetAllUseCase
import com.hogriders.daggerexample.domain.usecase.InsertUseCase
import io.reactivex.rxjava3.android.schedulers.AndroidSchedulers
import io.reactivex.rxjava3.core.Observable
import io.reactivex.rxjava3.schedulers.Schedulers
import java.util.*

class MainActivityViewModel(
    private val insertUseCase: InsertUseCase,
    private val getAllUseCase: GetAllUseCase
): ViewModel() {

    val users: LiveData<List<User>>
        get() =_users
    private val _users = MutableLiveData<List<User>>()

    init {
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