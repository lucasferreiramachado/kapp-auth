package com.lucasferreiramachado.kapp.auth.login.ui.coordinator

import com.lucasferreiramachado.kapp.auth.login.domain.usecases.AuthenticateUserUseCase
import com.lucasferreiramachado.kapp.auth.login.domain.usecases.ValidateLoginInputUseCase
import com.lucasferreiramachado.kapp.auth.login.domain.usecases.ValidatePasswordUseCase
import com.lucasferreiramachado.kapp.auth.login.domain.usecases.ValidateUsernameUseCase
import com.lucasferreiramachado.kcoordinator.KCoordinator

interface AuthCoordinatorFactoryI {
    val authenticateUserUseCase: AuthenticateUserUseCase
    val validateUsernameUseCase: ValidateUsernameUseCase
        get() = ValidateUsernameUseCase()
    val validatePasswordUseCase: ValidatePasswordUseCase
        get() = ValidatePasswordUseCase()
    val validateLoginInputUseCase: ValidateLoginInputUseCase
        get() = ValidateLoginInputUseCase()

    fun create(parent: KCoordinator<*>): AuthCoordinator
}