package com.lucasferreiramachado.kapp.auth.compose.example.ui.screens.authenticated.composables

import androidx.compose.runtime.Composable
import com.lucasferreiramachado.kapp.auth.compose.example.ui.screens.authenticated.AuthenticatedUiEvent
import com.lucasferreiramachado.kapp.auth.compose.example.ui.screens.authenticated.AuthenticatedUiState
import com.lucasferreiramachado.kapp.auth.compose.example.ui.screens.authenticated.AuthenticatedViewModel
import org.jetbrains.compose.ui.tooling.preview.Preview

@Composable
fun previewAuthenticatedScreen(
    state: AuthenticatedUiState,
    events: List<AuthenticatedUiEvent>
) {
    val viewModel = AuthenticatedViewModel(state)
    events.forEach {  event -> viewModel.onEvent(event) }
    AuthenticatedScreen(
        viewModel
    )
}