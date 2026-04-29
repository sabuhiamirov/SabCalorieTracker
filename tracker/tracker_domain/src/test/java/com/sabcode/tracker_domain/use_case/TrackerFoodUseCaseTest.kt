package com.sabcode.tracker_domain.use_case

import com.google.common.base.CharMatcher.any
import com.sabcode.core.domain.preferences.Preferences
import com.sabcode.tracker_domain.model.MealType
import com.sabcode.tracker_domain.model.TrackableFood
import com.sabcode.tracker_domain.repository.TrackerRepository
import com.sabcode.tracker_domain.usecase.TrackFoodUseCase
import io.mockk.Runs
import io.mockk.coEvery
import io.mockk.coVerify
import io.mockk.every
import io.mockk.just
import io.mockk.mockk
import kotlinx.coroutines.ExperimentalCoroutinesApi
import kotlinx.coroutines.test.runTest
import org.junit.Before
import org.junit.Test
import java.time.LocalDate

@OptIn(ExperimentalCoroutinesApi::class)
class TrackerFoodUseCaseTest {

    private lateinit var trackerFoodUseCase: TrackFoodUseCase
    private lateinit var repository: TrackerRepository

    @Before
    fun setUp() {
        repository = mockk<TrackerRepository>(relaxed = true)

        coEvery { repository.insertTrackedFood(any()) } just Runs

        trackerFoodUseCase = TrackFoodUseCase(repository)
    }


    @Test
    fun `Tracker food use case test`() = runTest {

        trackerFoodUseCase(
            food = TrackableFood(
                name = "Apple",
                carbsPer100g = 50,
                proteinPer100g = 10,
                fatPer100g = 5,
                caloriesPer100g = 200,
                imageUrl = null
            ),
            amount = 150,
            mealType = MealType.Lunch,
            date = LocalDate.now()
        )

        coVerify {
            repository.insertTrackedFood(
                match { food ->
                    food.carbs == 75 &&       // (50/100) * 150
                            food.protein == 15 &&     // (10/100) * 150
                            food.fat == 8 &&          // (5/100) * 150
                            food.calories == 300 &&   // (200/100) * 150
                            food.name == "Apple" &&
                            food.amount == 150 &&
                            food.mealType == MealType.Lunch
                }
            )
        }
    }
}