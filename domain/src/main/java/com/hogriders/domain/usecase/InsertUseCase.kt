package com.hogriders.domain.usecase

import com.hogriders.domain.model.User
import com.hogriders.domain.repository.UserRepository

class InsertUseCase (
    private val userRepository: UserRepository
) {
    fun invoke(user: User): Boolean {
        return if(user.name.isNotEmpty()) {
            userRepository.insertUser(user)
            true
        } else false
    }
}