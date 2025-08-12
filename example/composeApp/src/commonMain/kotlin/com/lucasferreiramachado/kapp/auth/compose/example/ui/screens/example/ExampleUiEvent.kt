package com.lucasferreiramachado.kapp.auth.compose.example.ui.screens.example

import com.lucasferreiramachado.kapp.auth.compose.example.domain.model.ExampleItem

sealed class ExampleUiEvent {
    data class ItemSelected(val item: ExampleItem) : ExampleUiEvent()
}