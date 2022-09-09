package com.example.composenavigation.screen

import androidx.compose.foundation.layout.*
import androidx.compose.material3.*
import androidx.compose.runtime.*
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.dp
import androidx.navigation.NavController
import com.example.composenavigation.model.Screen

@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun MainScreen(navController: NavController) {
    var text by remember {
        mutableStateOf("")
    }

    Column(
        verticalArrangement = Arrangement.Center,
        horizontalAlignment = Alignment.CenterHorizontally,
        modifier = Modifier
            .fillMaxSize()
            .padding(15.dp)
    ) {
        OutlinedTextField(
            value = text,
            label = { Text(text = "Your name..")},
            maxLines = 1    ,
            onValueChange = {
                text = it
            },
            modifier = Modifier.width(200.dp)
        )
        Spacer(modifier = Modifier.height(12.dp))
        Button(modifier = Modifier
            .align(Alignment.CenterHorizontally),
            onClick = {
                if (text.isNotEmpty()) {
                    navController.navigate(Screen.DetailScreen.withArgs(text))
                }
            }) {
            Text(text = "To detail screen")
        }
    }
}