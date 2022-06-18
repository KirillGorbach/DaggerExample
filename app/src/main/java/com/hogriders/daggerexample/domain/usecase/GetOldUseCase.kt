package com.hogriders.daggerexample.domain.usecase


import com.hogriders.daggerexample.domain.model.User
import com.hogriders.daggerexample.domain.repository.UserRepository
import io.reactivex.rxjava3.core.Observable

class GetOldUseCase(
    private val userRepository: UserRepository
) {
    fun invoke(): Observable<List<User>> = userRepository.getAllUsers()
}