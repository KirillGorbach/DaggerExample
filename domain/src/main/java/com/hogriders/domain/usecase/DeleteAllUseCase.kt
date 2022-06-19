package com.hogriders.domain.usecase

import com.hogriders.domain.repository.UserRepository

class DeleteAllUseCase(
    private val userRepository: UserRepository
) {
    fun invoke() {
        userRepository.deleteAllUsers()
    }
}