package com.lucasferreiramachado.kapp.auth.login.ui.screens.login

import androidx.lifecycle.ViewModel
import com.lucasferreiramachado.kapp.auth.flow.login.ui.screens.login.LoginUiState
import com.lucasferreiramachado.kapp.auth.login.domain.usecases.AuthenticateUserUseCase
import com.lucasferreiramachado.kapp.auth.login.domain.usecases.ValidateLoginInputUseCase
import com.lucasferreiramachado.kapp.auth.login.domain.usecases.ValidatePasswordUseCase
import com.lucasferreiramachado.kapp.auth.login.domain.usecases.ValidateUsernameUseCase
import com.lucasferreiramachado.kapp.auth.login.ui.coordinator.AuthCoordinator
import com.lucasferreiramachado.kapp.auth.login.ui.coordinator.AuthCoordinatorAction
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.StateFlow
import kotlinx.coroutines.flow.asStateFlow
import kotlinx.coroutines.flow.update

open class LoginViewModel(
    initialState: LoginUiState = LoginUiState(),
    val coordinator: AuthCoordinator,
    val authenticateUserUseCase: AuthenticateUserUseCase,
    val validateUsernameUseCase: ValidateUsernameUseCase,
    val validatePasswordUseCase: ValidatePasswordUseCase,
    val validateLoginInputUseCase: ValidateLoginInputUseCase,
) : ViewModel() {
    private val _state = MutableStateFlow(initialState)

    val state: StateFlow<LoginUiState> = _state.asStateFlow()

    fun onEvent(event: LoginUiEvent) {
        when (event) {
            is LoginUiEvent.UsernameChanged -> {
                val username = event.username
                val usernameError = validateUsernameUseCase.execute(username)
                _state.update { state ->
                    state.copy(
                        username = username,
                        usernameError = usernameError
                    )
                }
            }
            is LoginUiEvent.PasswordChanged -> {
                val password = event.password
                val passwordError = validatePasswordUseCase.execute(password)
                _state.update { state ->
                    state.copy(
                        password = password,
                        passwordError = passwordError
                    )
                }
            }
            is LoginUiEvent.PasswordVisibilityChanged -> {
                _state.update { state ->
                    state.copy(
                        isVisiblePassword = !state.isVisiblePassword,
                    )
                }
            }
            is LoginUiEvent.SignInButtonPressed -> {
                val result = validateLoginInputUseCase.execute(
                    state.value.username,
                    state.value.password
                )
                _state.update { state ->
                    state.copy(
                        passwordError = result.passwordError,
                        usernameError = result.usernameError,
                    )
                }
                if (result.isValid) {
                    val authenticateUser = authenticateUserUseCase.execute(
                        username = state.value.username,
                        password = state.value.password,
                    )
                    when (authenticateUser) {
                        null -> {
                            _state.update { state ->
                                state.copy(
                                    password = "",
                                    passwordError = "Invalid credentials",
                                )
                            }
                        }
                        else -> {
                            coordinator.trigger(AuthCoordinatorAction.Authenticated(authenticateUser.name))
                        }
                    }
                }
            }
        }
    }
}

