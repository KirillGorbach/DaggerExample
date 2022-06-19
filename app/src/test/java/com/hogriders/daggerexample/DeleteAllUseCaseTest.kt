package com.hogriders.daggerexample

import com.hogriders.domain.repository.UserRepository
import com.hogriders.domain.usecase.DeleteAllUseCase
import org.junit.jupiter.api.Test
import org.mockito.Mockito
import org.mockito.kotlin.mock

class DeleteAllUseCaseTest {

    private val userRepository = mock<UserRepository>()

    @Test
    fun `should call repository method`(){
        val deleteAllUseCase = DeleteAllUseCase(userRepository = userRepository)
        deleteAllUseCase.invoke()
        Mockito.verify(userRepository, Mockito.times(1)).deleteAllUsers()
    }

}