package com.lucasferreiramachado.kapp.auth.compose.example.ui.screens.example.composables

import androidx.compose.foundation.layout.*
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.items
import androidx.compose.material3.*
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.lucasferreiramachado.kapp.auth.compose.example.domain.model.ExampleItem
import com.lucasferreiramachado.kapp.auth.compose.example.ui.screens.example.ExampleUiState
import com.lucasferreiramachado.kapp.auth.compose.example.ui.screens.example.ExampleUiEvent


@Composable
fun ExampleView(
    state: ExampleUiState,
    onEvent: (ExampleUiEvent) -> Unit
) {
    Box(
        modifier = Modifier
            .fillMaxSize()
            .safeContentPadding(),
    ) {

        Column(modifier = Modifier
            .fillMaxHeight()
            .padding(40.dp)) {

            Text(text = "Hello,\nwelcome to the example page", fontSize = 25.sp, color = MaterialTheme.colorScheme.primary,
                modifier = Modifier.fillMaxWidth().padding(0.dp, 50.dp, 0.dp, 0.dp)
            )

            LazyColumn {
                items(items = state.items) { item ->
                    ItemRow(item.name) {
                        onEvent(ExampleUiEvent.ItemSelected(item))
                    }
                }
            }
        }

        Text(text = "KAppAuth Example Compose App",
            modifier = Modifier.fillMaxWidth().padding(16.dp).align(Alignment.BottomCenter),
            textAlign = TextAlign.Center,
            fontSize = 14.sp,
            color = MaterialTheme.colorScheme.primary,
        )
    }
}

@Composable
fun ItemRow(name: String, onClick: () -> Unit) {
    OutlinedButton(
        onClick = onClick,
        modifier = Modifier.fillMaxWidth().padding(0.dp, 25.dp, 0.dp, 0.dp),
        colors = ButtonColors(
            containerColor = MaterialTheme.colorScheme.primaryContainer,
            contentColor = MaterialTheme.colorScheme.onPrimaryContainer,
            disabledContainerColor = Color.Transparent,
            disabledContentColor = Color.Transparent
        ),
    ) {
        Text(
            text = name,
            modifier = Modifier
                .fillMaxWidth()
                .padding(5.dp),
            textAlign = TextAlign.Center,
            fontSize = 20.sp
        )
    }
}