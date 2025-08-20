package com.lucasferreiramachado.kapp.auth.login.ui.screens.login.composables

import androidx.compose.runtime.Composable
import com.lucasferreiramachado.kapp.auth.flow.login.ui.screens.login.LoginUiState
import com.lucasferreiramachado.kapp.auth.login.di.previewModule
import com.lucasferreiramachado.kapp.auth.login.ui.screens.login.LoginUiEvent
import com.lucasferreiramachado.kapp.auth.login.ui.screens.login.LoginViewModel
import org.jetbrains.compose.ui.tooling.preview.Preview
import org.koin.compose.KoinApplicationPreview
import org.koin.compose.viewmodel.koinViewModel
import org.koin.core.parameter.parametersOf

@Composable
fun previewLoginScreen(
    state: LoginUiState,
    events: List<LoginUiEvent>
) {
    KoinApplicationPreview(
        application = { modules(previewModule) }
    ) {
        val viewModel: LoginViewModel = koinViewModel<LoginViewModel> {
            parametersOf(state)
        }
        events.forEach { event -> viewModel.onEvent(event) }
        LoginScreen(viewModel)
    }
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