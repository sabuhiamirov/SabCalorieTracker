package com.sabcode.tracker_domain.usecase

import com.sabcode.tracker_domain.model.TrackableFood
import com.sabcode.tracker_domain.model.TrackedFood
import com.sabcode.tracker_domain.repository.TrackerRepository
import kotlinx.coroutines.flow.Flow
import java.time.LocalDate

class GetFoodsForDateUseCase(
    private val repository: TrackerRepository
) {
    suspend operator fun invoke(date: LocalDate): Flow<List<TrackedFood>> {
        return repository.getFoodForDate(date)
    }
}