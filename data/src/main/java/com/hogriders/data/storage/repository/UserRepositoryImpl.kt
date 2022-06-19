package com.hogriders.data.storage.repository

import com.hogriders.data.storage.local.dao.UsersDao
import com.hogriders.data.storage.local.mapper.UserDBtoUserMapper
import com.hogriders.data.storage.local.mapper.UserToUserDBMapper
import com.hogriders.domain.model.User
import com.hogriders.domain.repository.UserRepository
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

    override fun getOldPeople(age: Int): Observable<List<User>> {
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