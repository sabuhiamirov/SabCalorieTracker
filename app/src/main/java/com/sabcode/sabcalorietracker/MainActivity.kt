package com.sabcode.sabcalorietracker

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.material.Scaffold
import androidx.compose.material.rememberScaffoldState
import androidx.compose.ui.Modifier
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import androidx.navigation.compose.rememberNavController
import com.sabcode.core.navigation.Route
import com.sabcode.onboarding_presentation.age.AgeScreen
import com.sabcode.onboarding_presentation.gender.GenderScreen
import com.sabcode.onboarding_presentation.welcome.WelcomeScreen
import com.sabcode.sabcalorietracker.navigation.navigate
import com.sabcode.sabcalorietracker.ui.theme.SabCalorieTrackerTheme
import dagger.hilt.android.AndroidEntryPoint

@AndroidEntryPoint
class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            SabCalorieTrackerTheme {
                val navController = rememberNavController()
                val scaffoldState = rememberScaffoldState()
                Scaffold (
                    modifier = Modifier.fillMaxSize(),
                    scaffoldState = scaffoldState
                ){
                    NavHost(
                        navController = navController,
                        startDestination = Route.WELCOME
                    ) {
                        composable(Route.WELCOME) {
                            WelcomeScreen (
                                onNavigate = navController::navigate
                            )
                        }
                        composable(Route.AGE) {
                            AgeScreen(
                                scaffoldState =scaffoldState,
                                onNavigate = navController::navigate)
                        }
                        composable(Route.GENDER) {
                            GenderScreen(onNavigate = navController::navigate)
                        }
                        composable(Route.HEIGHT) {

                        }
                        composable(Route.WEIGHT) {

                        }
                        composable(Route.NUTRIENT_GOAL) {

                        }
                        composable(Route.ACTIVITY) {

                        }
                        composable(Route.GOAL) {

                        }
                        composable(Route.TRACKER_OVERVIEW) {

                        }
                        composable(Route.SEARCH) {

                        }
                    }
                }
            }
        }
    }
}