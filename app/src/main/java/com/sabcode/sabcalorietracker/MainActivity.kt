package com.sabcode.sabcalorietracker

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.material.Surface
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.tooling.preview.Preview
import com.sabcode.onboarding_presentation.welcome.WelcomeScreen
import com.sabcode.sabcalorietracker.ui.theme.SabCalorieTrackerTheme

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            SabCalorieTrackerTheme {
                WelcomeScreen()
            }
        }
    }
}