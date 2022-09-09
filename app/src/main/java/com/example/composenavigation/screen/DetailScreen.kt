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
import androidx.navigation.NavController
import com.example.composenavigation.model.Screen
import com.example.composenavigation.model.User

@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun DetailScreen(
    navController: NavController,
    name: String
) {
    Column(
        verticalArrangement = Arrangement.Center,
        horizontalAlignment = Alignment.CenterHorizontally,
        modifier = Modifier
            .fillMaxSize()
            .padding(15.dp)
    ) {
        Greeting(name)

        val userName by remember {
            mutableStateOf(name)
        }
        var age by remember {
            mutableStateOf("")
        }
        var email by remember {
            mutableStateOf("")
        }
        OutlinedTextField(
            value = age,
            label = { Text(text = "Your age..") },
            maxLines = 1,
            onValueChange = {
                age = it
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
                    val user = User(userName, age, email)
                    navController.navigate(Screen.PostScreen.withArgs(user))
                }
            }) {
            Text(text = "Go to user info")
        }
    }
}

private fun isValidData(
    userName: String,
    age: String,
    email: String
) = userName.isNotEmpty() && age.isNotEmpty() && email.isNotEmpty()

@Composable
private fun Greeting(name: String) {
    Box(
        contentAlignment = Alignment.Center,
        modifier = Modifier
            .fillMaxWidth()
            .height(100.dp)
    ) {
        val text = "Hello, $name!\nIt's your detail screen"
        Text(text = text)
    }
}