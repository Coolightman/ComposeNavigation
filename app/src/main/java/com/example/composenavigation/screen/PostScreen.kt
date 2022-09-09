package com.example.composenavigation.screen

import android.annotation.SuppressLint
import android.os.Build
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import com.example.composenavigation.model.User
import com.ramcosta.composedestinations.annotation.Destination
import java.text.SimpleDateFormat
import java.time.Instant
import java.time.LocalDateTime
import java.time.ZoneId
import java.util.*

@SuppressLint("SimpleDateFormat")
@Destination
@Composable
fun PostScreen(user: User) {
    Box(
        contentAlignment = Alignment.Center,
        modifier = Modifier.fillMaxSize()
    ) {
        val date = if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.O) {
            LocalDateTime.ofInstant(
                Instant.ofEpochMilli(user.created), ZoneId.systemDefault()
            )
        } else {
            SimpleDateFormat("MM/dd/yyyy HH:mm").format(Date(user.created))
        }
        val text = "Created user:\n" +
                "Name --> ${user.name}\n" +
                "Age --> ${user.age}\n" +
                "email --> ${user.email}\n" +
                "date --> $date"
        Text(text = text)
    }
}