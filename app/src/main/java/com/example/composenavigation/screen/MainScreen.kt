package com.example.composenavigation.screen

import androidx.compose.foundation.layout.*
import androidx.compose.material3.Button
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.OutlinedTextField
import androidx.compose.material3.Text
import androidx.compose.runtime.*
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.dp
import com.example.composenavigation.screen.destinations.DetailScreenDestination
import com.ramcosta.composedestinations.annotation.Destination
import com.ramcosta.composedestinations.navigation.DestinationsNavigator

@OptIn(ExperimentalMaterial3Api::class)
@Destination
@Composable
fun MainScreen(
    navigator: DestinationsNavigator
) {
    var text by remember { mutableStateOf("") }

    Column(
        verticalArrangement = Arrangement.Center,
        horizontalAlignment = Alignment.CenterHorizontally,
        modifier = Modifier
            .fillMaxSize()
            .padding(15.dp)
    ) {
        OutlinedTextField(
            value = text,
            label = { Text(text = "Your name..") },
            maxLines = 1,
            onValueChange = {
                text = it
            },
            modifier = Modifier.fillMaxWidth(0.8f)
        )
        Spacer(modifier = Modifier.height(12.dp))
        Button(modifier = Modifier
            .align(Alignment.CenterHorizontally),
            onClick = {
                if (text.isNotEmpty()) {
                    navigator.navigate(DetailScreenDestination(text))
                }
            }) {
            Text(text = "To detail screen")
        }
    }
}