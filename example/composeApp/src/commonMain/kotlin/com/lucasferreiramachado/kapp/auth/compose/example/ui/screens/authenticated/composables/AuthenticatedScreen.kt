package com.lucasferreiramachado.kapp.auth.compose.example.ui.screens.authenticated.composables

import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.lifecycle.compose.collectAsStateWithLifecycle
import com.lucasferreiramachado.kapp.auth.compose.example.ui.screens.authenticated.AuthenticatedViewModel

@Composable
fun AuthenticatedScreen(
    viewModel: AuthenticatedViewModel
) {
    val state by viewModel.state.collectAsStateWithLifecycle()
    AuthenticatedView(
        state = state,
        onEvent = { event ->
            viewModel.onEvent(event)
        }
    )
}