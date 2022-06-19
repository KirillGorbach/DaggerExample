package com.hogriders.presentation.vm

import android.app.Application
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.setValue
import androidx.lifecycle.AndroidViewModel
import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import com.hogriders.di.component.DaggerUseCaseComponent
import com.hogriders.di.module.ContextModule
import com.hogriders.domain.model.User
import com.hogriders.domain.usecase.GetAllUseCase
import io.reactivex.rxjava3.android.schedulers.AndroidSchedulers
import io.reactivex.rxjava3.core.Observable
import io.reactivex.rxjava3.schedulers.Schedulers
import com.hogriders.domain.usecase.InsertUseCase as InsertUseCase1

class MainActivityViewModel(app: Application): AndroidViewModel(app) {

    val users: LiveData<List<User>>
        get() =_users
    private val _users = MutableLiveData<List<User>>()

    var c_users by mutableStateOf(listOf<User>())
        private set

    private var getAllUseCase: GetAllUseCase
    private var insertUseCase: InsertUseCase1

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
            .subscribe {
                _users.value = it
                c_users = it
            }
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