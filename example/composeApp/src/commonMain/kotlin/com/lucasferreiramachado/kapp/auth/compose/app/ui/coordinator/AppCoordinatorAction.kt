package com.lucasferreiramachado.kapp.auth.compose.app.ui.coordinator

import com.lucasferreiramachado.kcoordinator.KCoordinatorAction

sealed class AppCoordinatorAction: KCoordinatorAction {
    data object StartExample : AppCoordinatorAction()
    data object AppInitialized : AppCoordinatorAction()
}