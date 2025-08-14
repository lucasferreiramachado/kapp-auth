package com.lucasferreiramachado.kapp.auth.login.di

import com.lucasferreiramachado.kapp.auth.login.domain.usecases.AuthenticateUserUseCase
import com.lucasferreiramachado.kapp.auth.login.domain.usecases.ValidateLoginInputUseCase
import com.lucasferreiramachado.kapp.auth.login.domain.usecases.ValidatePasswordUseCase
import com.lucasferreiramachado.kapp.auth.login.domain.usecases.ValidateUsernameUseCase
import com.lucasferreiramachado.kapp.auth.login.ui.coordinator.AuthCoordinator
import com.lucasferreiramachado.kapp.auth.login.ui.screens.login.LoginViewModel
import com.lucasferreiramachado.kapp.data.user.FakeUserRepository
import com.lucasferreiramachado.kapp.data.user.UserRepository
import com.lucasferreiramachado.kcoordinator.KCoordinator
import com.lucasferreiramachado.kcoordinator.KCoordinatorAction
import org.koin.core.module.Module
import org.koin.core.module.dsl.singleOf
import org.koin.core.module.dsl.viewModelOf
import org.koin.dsl.module

internal val previewModule: Module = module {
    single<AuthCoordinator> {
            AuthCoordinator(FakeCoordinator())
    }
    single<UserRepository> { FakeUserRepository() }
    singleOf(::AuthenticateUserUseCase)
    singleOf(::ValidateUsernameUseCase)
    singleOf(::ValidatePasswordUseCase)
    singleOf(::ValidateLoginInputUseCase)
    viewModelOf(::LoginViewModel)
}

private class FakeCoordinator() : KCoordinator<KCoordinatorAction> {
    override val parent: KCoordinator<*>? = null
    override fun handle(action: KCoordinatorAction) {}
}