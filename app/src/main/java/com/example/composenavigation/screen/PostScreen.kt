package com.example.composenavigation.screen

import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import com.example.composenavigation.model.User

@Composable
fun PostScreen(user: User) {
    Box(
        contentAlignment = Alignment.Center,
        modifier = Modifier.fillMaxSize()
    ) {
        val text = "Current user:\n" +
                "Name --> ${user.name}\n" +
                "Age --> ${user.age}\n" +
                "email --> ${user.email}"
        Text(text = text)
    }
}