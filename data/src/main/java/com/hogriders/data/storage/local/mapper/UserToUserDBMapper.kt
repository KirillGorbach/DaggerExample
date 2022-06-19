package com.hogriders.data.storage.local.mapper

import com.hogriders.data.storage.local.model.UserDB
import com.hogriders.domain.model.User

class UserToUserDBMapper: (User) -> UserDB {
    override fun invoke(p1: User): UserDB {
        return UserDB(
            id = p1.id,
            name = p1.name,
            age = p1.age
        )
    }
}