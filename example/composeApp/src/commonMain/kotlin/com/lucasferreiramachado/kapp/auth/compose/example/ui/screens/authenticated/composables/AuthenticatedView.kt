package com.lucasferreiramachado.kapp.auth.compose.example.ui.screens.authenticated.composables

import androidx.compose.foundation.layout.*
import androidx.compose.material3.*
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.lucasferreiramachado.kapp.auth.compose.example.ui.screens.authenticated.AuthenticatedUiState
import com.lucasferreiramachado.kapp.auth.compose.example.ui.screens.authenticated.AuthenticatedUiEvent


@Composable
fun AuthenticatedView(
    state: AuthenticatedUiState,
    onEvent: (AuthenticatedUiEvent) -> Unit
) {
    Box(
        modifier = Modifier
            .fillMaxSize()
            .safeContentPadding(),
    ) {

        Column(modifier = Modifier
            .fillMaxWidth()
            .padding(bottom = 32.dp)
            .align(Alignment.Center)
        ) {
            Text(
                text = "Congratulations!",
                fontSize = 24.sp, color = MaterialTheme.colorScheme.primary,
                textAlign = TextAlign.Center,
                modifier = Modifier.fillMaxWidth().padding(all = 24.dp)

            )
            Text(
                text = "Welcome to the\nauthenticated page.",
                fontSize = 32.sp, color = MaterialTheme.colorScheme.primary,
                textAlign = TextAlign.Center,
                modifier = Modifier.fillMaxWidth().padding()

            )
        }

        Text(text = "KAppAuth Example Compose App",
            modifier = Modifier.fillMaxWidth().padding(16.dp).align(Alignment.BottomCenter),
            textAlign = TextAlign.Center,
            fontSize = 14.sp,
            color = MaterialTheme.colorScheme.primary,
        )
    }
}