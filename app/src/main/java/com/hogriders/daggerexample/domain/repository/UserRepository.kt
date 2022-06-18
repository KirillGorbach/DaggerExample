package com.hogriders.daggerexample.domain.repository


import com.hogriders.daggerexample.domain.model.User
import io.reactivex.rxjava3.core.Observable

interface UserRepository {

    fun getAllUsers(): Observable<List<User>>
    fun getOldPeopleBeers(age: Int): Observable<List<User>>
    fun insertUser(user: User)
    fun deleteAllUsers()

}