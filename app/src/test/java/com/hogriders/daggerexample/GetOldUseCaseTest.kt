package com.hogriders.daggerexample

import com.hogriders.domain.model.User
import com.hogriders.domain.repository.UserRepository
import com.hogriders.domain.usecase.GetOldUseCase
import io.reactivex.rxjava3.core.Observable
import org.junit.jupiter.api.Assertions
import org.junit.jupiter.api.Test
import org.mockito.Mockito
import org.mockito.kotlin.mock

class GetOldUseCaseTest {

    private val userRepository = mock<UserRepository>()

    @Test
    fun `should return data`() {
        val testUsers = Observable.fromArray(
            listOf(
                User(id = 1, name = "asd1", age = 13),
                User(id = 2, name = "asd2", age = 11),
                User(id = 3, name = "asd3", age = 12)
            )
        )
        val minAge = 10

        Mockito.`when`(userRepository.getOldPeople(minAge)).thenReturn(testUsers)

        val getOldUseCase = GetOldUseCase(userRepository = userRepository)
        val actual = getOldUseCase.invoke(minAge)

        Assertions.assertEquals(testUsers, actual)
    }
}