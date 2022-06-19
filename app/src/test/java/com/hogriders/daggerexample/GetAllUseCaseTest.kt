package com.hogriders.daggerexample

import com.hogriders.domain.model.User
import com.hogriders.domain.repository.UserRepository
import com.hogriders.domain.usecase.GetAllUseCase
import io.reactivex.rxjava3.core.Observable
import org.junit.jupiter.api.Assertions
import org.junit.jupiter.api.Test
import org.mockito.Mockito
import org.mockito.kotlin.mock

class GetAllUseCaseTest {

    private val userRepository = mock<UserRepository>()

    @Test
    fun `should return data`() {
        val testUsers = Observable.fromArray(
            listOf(
                User(id = 1, name = "asd1", age = 10),
                User(id = 2, name = "asd2", age = 11),
                User(id = 3, name = "asd3", age = 12)
            )
        )

        Mockito.`when`(userRepository.getAllUsers()).thenReturn(testUsers)

        val getAllUseCase = GetAllUseCase(userRepository = userRepository)
        val actual = getAllUseCase.invoke()

        Assertions.assertEquals(testUsers, actual)
    }

}