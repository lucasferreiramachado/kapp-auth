package com.lucasferreiramachado.kapp.auth.compose.di

import com.lucasferreiramachado.kapp.auth.compose.example.ExampleCoordinator
import com.lucasferreiramachado.kapp.auth.login.domain.usecases.AuthenticateUserUseCase
import com.lucasferreiramachado.kapp.auth.login.ui.coordinator.AuthCoordinator
import com.lucasferreiramachado.kapp.auth.login.ui.coordinator.AuthCoordinatorFactoryI
import com.lucasferreiramachado.kapp.data.user.UserRepository
import com.lucasferreiramachado.kapp.data.user.model.AuthenticatedUser
import com.lucasferreiramachado.kcoordinator.KCoordinator

class ExampleCoordinatorFactory {

    fun create(
        parent: KCoordinator<*>,
    ): ExampleCoordinator {
        val repository = ExampleUserRepositoryFactory.create()
        val authenticateUserUseCase = AuthenticateUserUseCase(repository)
        return ExampleCoordinator(
            AuthCoordinatorFactory(authenticateUserUseCase),
            parent = parent
        )
    }
}

class AuthCoordinatorFactory(
    override val authenticateUserUseCase: AuthenticateUserUseCase
) : AuthCoordinatorFactoryI {
    override fun create(
        parent: KCoordinator<*>,
    ): AuthCoordinator = AuthCoordinator(
        this,
        parent = parent
    )
}

object ExampleUserRepositoryFactory {
    private val repository: UserRepository = ExampleUserRepository()

    fun create(): UserRepository {
        return repository
    }
}

private class ExampleUserRepository(
    private var authenticatedUser: AuthenticatedUser? = null
): UserRepository {

    override fun authenticate(
        username: String,
        password: String,
    ): AuthenticatedUser? {
        authenticatedUser = AuthenticatedUser(
            id = "123",
            username = username,
            name = "{user's firstname}"
        )
        return authenticatedUser
    }

    override fun loggedUser(): AuthenticatedUser? = authenticatedUser
}