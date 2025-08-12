package com.lucasferreiramachado.kapp.auth.login.ui.screens.login.composables

import androidx.compose.runtime.Composable
import com.lucasferreiramachado.kapp.auth.login.domain.usecases.ValidateLoginInputUseCase
import com.lucasferreiramachado.kapp.auth.login.domain.usecases.ValidatePasswordUseCase
import com.lucasferreiramachado.kapp.auth.login.domain.usecases.ValidateUsernameUseCase
import com.lucasferreiramachado.kapp.auth.flow.login.ui.screens.login.LoginUiState
import com.lucasferreiramachado.kapp.auth.login.ui.screens.login.LoginUiEvent
import com.lucasferreiramachado.kapp.auth.login.domain.usecases.AuthenticateUserUseCase
import com.lucasferreiramachado.kapp.auth.login.ui.coordinator.AuthCoordinatorAction
import com.lucasferreiramachado.kapp.auth.login.ui.screens.login.LoginViewModel
import com.lucasferreiramachado.kapp.data.user.UserRepository
import com.lucasferreiramachado.kapp.data.user.model.AuthenticatedUser
import com.lucasferreiramachado.kcoordinator.KCoordinator
import org.jetbrains.compose.ui.tooling.preview.Preview

@Composable
fun previewLoginScreen(
    state: LoginUiState,
    events: List<LoginUiEvent>
) {
    val viewModel = PreviewLoginViewModel(state)
    events.forEach {  event -> viewModel.onEvent(event) }
    LoginScreen(
        viewModel
    )
}

@Composable
@Preview
fun LoginScreenPreviewSuccessFlow(
    state: LoginUiState = LoginUiState(),
    events: List<LoginUiEvent> = listOf(
        LoginUiEvent.UsernameChanged("lucasferreiramachado"),
        LoginUiEvent.PasswordChanged("123456"),
        LoginUiEvent.PasswordVisibilityChanged
    )
) {
    previewLoginScreen(state, events)
}

@Composable
@Preview
fun LoginScreenPreviewOnShortUsernameError(
    state: LoginUiState = LoginUiState(),
    events: List<LoginUiEvent> = listOf(
        LoginUiEvent.UsernameChanged(" ")
    )
) {
    previewLoginScreen(state, events)
}

@Composable
@Preview
fun LoginScreenPreviewOnShortPasswordError(
    state: LoginUiState = LoginUiState(),
    events: List<LoginUiEvent> = listOf(
        LoginUiEvent.PasswordChanged("123")
    )
) {
    previewLoginScreen(state, events)
}

private class PreviewLoginViewModel(
    initialState: LoginUiState,
    coordinator: KCoordinator<AuthCoordinatorAction>? = null,
    authenticateUserUseCase: AuthenticateUserUseCase = AuthenticateUserUseCase(
        repository = PreviewUserRepository()
    ),
    validateUsernameUseCase: ValidateUsernameUseCase = ValidateUsernameUseCase(),
    validatePasswordUseCase: ValidatePasswordUseCase = ValidatePasswordUseCase(),
    validateLoginInputUseCase: ValidateLoginInputUseCase = ValidateLoginInputUseCase()
) : LoginViewModel(
    initialState,
    coordinator,
    authenticateUserUseCase,
    validateUsernameUseCase,
    validatePasswordUseCase,
    validateLoginInputUseCase
)

private class PreviewUserRepository(
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