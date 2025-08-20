package com.lucasferreiramachado.kapp.auth.compose.example.ui.coordinator

import com.lucasferreiramachado.kcoordinator.KCoordinatorAction

sealed class ExampleCoordinatorAction: KCoordinatorAction {
    data object StartExample : ExampleCoordinatorAction()
    data object StartLoginFlow : ExampleCoordinatorAction()
}