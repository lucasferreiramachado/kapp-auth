package com.lucasferreiramachado.kapp.auth.compose.example.ui.screens.authenticated.composables

import androidx.compose.foundation.background
import androidx.compose.foundation.layout.*
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.lucasferreiramachado.kapp.auth.compose.example.ui.screens.authenticated.AuthenticatedUiEvent
import com.lucasferreiramachado.kapp.auth.compose.example.ui.screens.authenticated.AuthenticatedUiState
import org.jetbrains.compose.ui.tooling.preview.Preview


@Composable
@Preview
fun AuthenticatedScreenPreview(
    state: AuthenticatedUiState = AuthenticatedUiState(),
    events: List<AuthenticatedUiEvent> = emptyList()
) {
    previewAuthenticatedScreen(state, events)
}

@Composable
fun AuthenticatedView(
    state: AuthenticatedUiState,
    onEvent: (AuthenticatedUiEvent) -> Unit
) {
    Box(
        modifier = Modifier
            .fillMaxSize()
            .safeContentPadding()
            .background(MaterialTheme.colorScheme.background),
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
                modifier = Modifier.fillMaxWidth().padding(24.dp)

            )
            Text(
                text = "Welcome to the\nauthenticated page.",
                fontSize = 28.sp, color = MaterialTheme.colorScheme.primary,
                letterSpacing = 2.sp,
                lineHeight = 32.sp,
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