package com.hogriders.daggerexample

import com.hogriders.domain.model.User
import com.hogriders.domain.repository.UserRepository
import com.hogriders.domain.usecase.InsertUseCase
import org.junit.jupiter.api.AfterEach
import org.junit.jupiter.api.Assertions
import org.junit.jupiter.api.Test
import org.mockito.Mockito
import org.mockito.kotlin.mock


class InsertUseCaseTest {

    private val userRepository = mock<UserRepository>()

    @AfterEach
    fun reuseMockObject(){
        Mockito.reset(userRepository)
    }

    @Test
    fun `should return true if name is not empty`() {
        val testUser = User(id = 1, name = "asd", age = 10)
        val insertUseCase = InsertUseCase(userRepository = userRepository)
        val actual = insertUseCase.invoke(testUser)
        val expected = true
        Assertions.assertEquals(expected, actual)
    }

    @Test
    fun `should return false if name empty`() {
        val testUser = User(id = 1, name = "", age = 10)

        val insertUseCase = InsertUseCase(userRepository = userRepository)

        val actual = insertUseCase.invoke(testUser)
        val expected = false

        Assertions.assertEquals(expected, actual)
    }

}