package com.example.composenavigation

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.foundation.isSystemInDarkTheme
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Surface
import androidx.compose.runtime.Composable
import androidx.compose.runtime.SideEffect
import com.example.composenavigation.screen.NavGraphs
import com.example.composenavigation.ui.theme.ComposeNavigationTheme
import com.google.accompanist.systemuicontroller.rememberSystemUiController
import com.ramcosta.composedestinations.DestinationsNavHost

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            ComposeNavigationTheme {
                Surface(color = MaterialTheme.colorScheme.background) {
                    DefineStatusBarColor()
                    DestinationsNavHost(navGraph = NavGraphs.root)
                }
            }
        }
    }

    @Composable
    private fun DefineStatusBarColor() {
        val systemUiController = rememberSystemUiController()
        val useDarkIcons = !isSystemInDarkTheme()
        val systemBarColor = MaterialTheme.colorScheme.background
        SideEffect {
            systemUiController.setSystemBarsColor(
                color = systemBarColor,
                darkIcons = useDarkIcons
            )
        }
    }
}