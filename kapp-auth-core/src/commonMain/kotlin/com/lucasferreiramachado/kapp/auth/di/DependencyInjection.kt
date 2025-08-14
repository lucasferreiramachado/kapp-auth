package com.lucasferreiramachado.kapp.auth.di

import com.lucasferreiramachado.kapp.auth.AuthCoordinator
import com.lucasferreiramachado.kcoordinator.KCoordinator
import com.lucasferreiramachado.kapp.data.user.FakeUserRepository
import com.lucasferreiramachado.kapp.data.user.UserRepository

class AuthCoordinatorFactory {
    fun create(
        parent: KCoordinator<*>,
    ): AuthCoordinator = AuthCoordinator(
        parent
    )
}

object UserRepositoryFactory {
    private val repository: UserRepository = FakeUserRepository()

    fun create(): UserRepository {
        return repository
    }
}