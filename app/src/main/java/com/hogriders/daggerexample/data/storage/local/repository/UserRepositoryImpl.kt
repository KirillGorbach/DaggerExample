package com.hogriders.daggerexample.data.storage.local.repository

import com.hogriders.daggerexample.domain.model.User
import com.hogriders.daggerexample.domain.repository.UserRepository
import io.reactivex.rxjava3.core.Observable

class UserRepositoryImpl: UserRepository {

    override fun getAllUsers(): Observable<List<User>> {
        TODO("Not yet implemented")
    }

    override fun getOldPeopleBeers(age: Int): Observable<List<User>> {
        TODO("Not yet implemented")
    }

    override fun insertUser(user: User) {
        TODO("Not yet implemented")
    }

    override fun deleteAllUsers() {
        TODO("Not yet implemented")
    }

}