package com.hogriders.daggerexample.data.storage.local.mapper

import com.hogriders.daggerexample.data.storage.local.model.UserDB
import com.hogriders.daggerexample.domain.model.User

class UserDBtoUserMapper: (UserDB) -> User {
    override fun invoke(p1: UserDB): User {
        return User(
            id = p1.id,
            name = p1.name,
            age = p1.age
        )
    }
}