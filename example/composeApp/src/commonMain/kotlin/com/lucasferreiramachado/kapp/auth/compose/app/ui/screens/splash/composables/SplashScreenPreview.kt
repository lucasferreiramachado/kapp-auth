package com.lucasferreiramachado.kapp.auth.compose.app.ui.screens.splash.composables

import androidx.compose.runtime.Composable
import com.lucasferreiramachado.kapp.auth.compose.app.ui.screens.splash.SplashUiEvent
import com.lucasferreiramachado.kapp.auth.compose.app.ui.screens.splash.SplashUiState
import com.lucasferreiramachado.kapp.auth.compose.app.ui.screens.splash.SplashViewModel

@Composable
fun previewSplashScreen(
    state: SplashUiState,
    events: List<SplashUiEvent>
) {
    val viewModel = SplashViewModel(state)
    events.forEach {  event -> viewModel.onEvent(event) }
    SplashScreen(
        viewModel
    )
}