package com.hogriders.daggerexample.data.storage.repository

import com.hogriders.daggerexample.data.storage.local.dao.UsersDao
import com.hogriders.daggerexample.data.storage.local.mapper.UserDBtoUserMapper
import com.hogriders.daggerexample.data.storage.local.mapper.UserToUserDBMapper
import com.hogriders.daggerexample.domain.model.User
import com.hogriders.daggerexample.domain.repository.UserRepository
import io.reactivex.rxjava3.core.Observable

class UserRepositoryImpl (
    private val usersDao: UsersDao
): UserRepository {

    private val userDBtoUserMapper = UserDBtoUserMapper()
    private val userToUserDBMapper = UserToUserDBMapper()

    override fun getAllUsers(): Observable<List<User>> {
        return usersDao.getAllUsers().map {
            it.map(userDBtoUserMapper)
        }
    }

    override fun getOldPeopleBeers(age: Int): Observable<List<User>> {
        return usersDao.getOldPeopleBeers(age).map {
            it.map(userDBtoUserMapper)
        }
    }

    override fun insertUser(user: User) {
        usersDao.insertUser(userToUserDBMapper(user))
    }

    override fun deleteAllUsers() {
        usersDao.deleteAllUsers()
    }

}