package com.lucasferreiramachado.kapp.auth.compose.di

import org.koin.dsl.koinConfiguration

val KoinApp = koinConfiguration {
    modules(
        appModule
    )
}