package com.hogriders.daggerexample.domain.usecase

import com.hogriders.daggerexample.domain.repository.UserRepository

class DeleteAllUseCase(
    private val userRepository: UserRepository
) {
    fun invoke() {
        userRepository.deleteAllUsers()
    }
}