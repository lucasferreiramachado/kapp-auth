package com.lucasferreiramachado.kapp.auth.compose.example.domain.model

import com.lucasferreiramachado.kcoordinator.KCoordinatorAction

class ExampleItem(
    val name: String = "",
    val action: KCoordinatorAction
)