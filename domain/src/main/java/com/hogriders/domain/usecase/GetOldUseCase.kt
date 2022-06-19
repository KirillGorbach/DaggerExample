package com.hogriders.domain.usecase


import com.hogriders.domain.model.User
import com.hogriders.domain.repository.UserRepository
import io.reactivex.rxjava3.core.Observable

class GetOldUseCase (
    private val userRepository: UserRepository
) {
    fun invoke(age: Int): Observable<List<User>> = userRepository.getOldPeople(age)
}