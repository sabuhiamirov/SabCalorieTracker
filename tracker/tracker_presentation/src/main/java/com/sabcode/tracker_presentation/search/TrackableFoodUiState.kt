package com.sabcode.tracker_presentation.search

import com.sabcode.tracker_domain.model.TrackableFood


data class TrackableFoodUiState(
    val food: TrackableFood,
    val isExpanded: Boolean = false,
    val amount: String = ""
)