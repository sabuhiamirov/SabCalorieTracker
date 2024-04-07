package com.sabcode.sabcalorietracker.navigation

import androidx.navigation.NavController
import com.sabcode.core.util.UiEvent

fun NavController.navigate(event: UiEvent.Navigate) {
    this.navigate(event.route)
}