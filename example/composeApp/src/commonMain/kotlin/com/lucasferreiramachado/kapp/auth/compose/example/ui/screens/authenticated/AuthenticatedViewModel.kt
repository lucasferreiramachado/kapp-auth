package com.lucasferreiramachado.kapp.auth.compose.example.ui.screens.authenticated

import androidx.lifecycle.ViewModel
import com.lucasferreiramachado.kapp.auth.AuthCoordinatorAction
import com.lucasferreiramachado.kapp.auth.compose.example.ExampleCoordinatorAction
import com.lucasferreiramachado.kcoordinator.KCoordinator
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.StateFlow
import kotlinx.coroutines.flow.asStateFlow

class AuthenticatedViewModel(
    initialState: AuthenticatedUiState,
    val coordinator: KCoordinator<ExampleCoordinatorAction>? = null,
) : ViewModel() {
    private val _state = MutableStateFlow(initialState)

    val state: StateFlow<AuthenticatedUiState> = _state.asStateFlow()

    fun onEvent(event: AuthenticatedUiEvent) { }
}

