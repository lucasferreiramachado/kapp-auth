package com.lucasferreiramachado.kapp.auth.compose.di

import com.lucasferreiramachado.kapp.auth.compose.example.ExampleCoordinator
import com.lucasferreiramachado.kcoordinator.KCoordinator

class ExampleCoordinatorFactory {
    fun create(
        parent: KCoordinator<*>,
    ): ExampleCoordinator = ExampleCoordinator(
        parent = parent
    )
}