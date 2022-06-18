package com.hogriders.daggerexample.domain.usecase

import com.hogriders.daggerexample.domain.model.User
import com.hogriders.daggerexample.domain.repository.UserRepository

class InsertUseCase (
    private val userRepository: UserRepository
) {
    fun invoke(user: User) {
        if(user.name.isNotEmpty())
            userRepository.insertUser(user)
    }
}