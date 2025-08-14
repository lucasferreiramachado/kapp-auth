package com.lucasferreiramachado.kapp.app.coordinators.app.ui.screens

import androidx.compose.foundation.layout.*
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.LaunchedEffect
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import kotlinx.coroutines.CoroutineScope
import org.jetbrains.compose.ui.tooling.preview.Preview

@Composable
@Preview
fun SplashScreen(
    onSplashScreenLaunched: suspend CoroutineScope.() -> Unit
) {
    Box(
        modifier = Modifier
            .fillMaxSize()
            .safeContentPadding(),
        contentAlignment = Alignment.Center
    ) {

        Column(
            modifier = Modifier.fillMaxWidth().align(Alignment.Center)
        ) {
            Text(text = "KAppAuth",
                modifier = Modifier.fillMaxWidth().padding(),
                textAlign = TextAlign.Center,
                fontSize = 32.sp,
                color = MaterialTheme.colorScheme.primary,
            )

            Text(text = "Example Compose App",
                modifier = Modifier.fillMaxWidth().padding(),
                textAlign = TextAlign.Center,
                fontSize = 16.sp,
                color = MaterialTheme.colorScheme.primary,
            )
        }
    }

    LaunchedEffect(key1 = "splashScreenLaunched") {
        onSplashScreenLaunched()
    }
}