package com.example.composenavigation.screen

import androidx.compose.foundation.layout.*
import androidx.compose.foundation.text.KeyboardOptions
import androidx.compose.material3.Button
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.OutlinedTextField
import androidx.compose.material3.Text
import androidx.compose.runtime.*
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.text.input.KeyboardType
import androidx.compose.ui.unit.dp
import com.example.composenavigation.model.User
import com.example.composenavigation.screen.destinations.PostScreenDestination
import com.ramcosta.composedestinations.annotation.Destination
import com.ramcosta.composedestinations.navigation.DestinationsNavigator

@OptIn(ExperimentalMaterial3Api::class)
@Destination
@Composable
fun DetailScreen(
    navigator: DestinationsNavigator,
    name: String
) {
    Column(
        verticalArrangement = Arrangement.Center,
        horizontalAlignment = Alignment.CenterHorizontally,
        modifier = Modifier
            .fillMaxSize()
            .padding(15.dp)
    ) {
        Box(
            contentAlignment = Alignment.Center,
            modifier = Modifier
                .fillMaxWidth()
                .height(100.dp)
        ) {
            val text = "Hello, $name!\nIt's your detail screen"
            Text(text = text)
        }

        val userName by remember { mutableStateOf(name) }
        var age by remember { mutableStateOf("") }
        var email by remember { mutableStateOf("") }

        OutlinedTextField(
            value = age,
            label = { Text(text = "Your age..") },
            maxLines = 1,
            keyboardOptions = KeyboardOptions(keyboardType = KeyboardType.Number),
            onValueChange = {
                if (it.isNotEmpty()) {
                    age = it
                }
            },
            modifier = Modifier.width(200.dp)
        )
        Spacer(modifier = Modifier.height(12.dp))
        OutlinedTextField(
            value = email,
            label = { Text(text = "Your e-mail..") },
            maxLines = 1,
            onValueChange = {
                email = it
            },
            modifier = Modifier.width(200.dp)
        )
        Spacer(modifier = Modifier.height(12.dp))
        Button(modifier = Modifier
            .align(Alignment.CenterHorizontally),
            onClick = {
                if (isValidData(userName, age, email)) {
                    val user = User(userName, age.toInt(), email, System.currentTimeMillis())
                    navigator.navigate(PostScreenDestination(user))

                }
            }) {
            Text(text = "Create user")
        }
    }
}

private fun isValidData(
    userName: String,
    age: String,
    email: String
) = userName.isNotEmpty() && age.isNotEmpty() && email.isNotEmpty()