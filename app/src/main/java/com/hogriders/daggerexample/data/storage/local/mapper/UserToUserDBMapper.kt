package com.hogriders.daggerexample.data.storage.local.mapper

import com.hogriders.daggerexample.data.storage.local.model.UserDB
import com.hogriders.daggerexample.domain.model.User

class UserToUserDBMapper: (User) -> UserDB {
    override fun invoke(p1: User): UserDB {
        return UserDB(
            id = p1.id,
            name = p1.name,
            age = p1.age
        )
    }
}