package com.hogriders.domain.repository


import com.hogriders.domain.model.User
import io.reactivex.rxjava3.core.Observable

interface UserRepository {

    fun getAllUsers(): Observable<List<User>>
    fun getOldPeople(age: Int): Observable<List<User>>
    fun insertUser(user: User)
    fun deleteAllUsers()

}