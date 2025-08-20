package com.lucasferreiramachado.kapp.auth.compose.di

import com.lucasferreiramachado.kapp.auth.compose.app.ui.coordinator.AppCoordinator
import com.lucasferreiramachado.kapp.auth.compose.example.ui.coordinator.ExampleCoordinator
import com.lucasferreiramachado.kapp.auth.login.di.authModule
import com.lucasferreiramachado.kapp.auth.compose.di.modules.dataModule
import org.koin.core.module.Module
import org.koin.dsl.module

val appModule: Module = module {

    includes(dataModule)
    includes(authModule)

    single<ExampleCoordinator> { (parent: AppCoordinator) -> ExampleCoordinator(parent) }
    single<AppCoordinator> { AppCoordinator() }
}