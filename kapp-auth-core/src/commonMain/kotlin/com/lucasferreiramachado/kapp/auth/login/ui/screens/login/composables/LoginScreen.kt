package com.lucasferreiramachado.kapp.auth.login.ui.screens.login.composables

import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.lifecycle.compose.collectAsStateWithLifecycle
import com.lucasferreiramachado.kapp.auth.login.ui.screens.login.LoginViewModel

@Composable
fun LoginScreen(
    viewModel: LoginViewModel
) {
    val state by viewModel.state.collectAsStateWithLifecycle()
    LoginView(
        state = state,
        onEvent = { event ->
            viewModel.onEvent(event)
        }
    )
}