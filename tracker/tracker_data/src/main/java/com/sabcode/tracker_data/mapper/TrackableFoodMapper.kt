package com.sabcode.tracker_data.mapper

import com.sabcode.tracker_data.remote.dto.Product
import com.sabcode.tracker_domain.model.TrackableFood
import kotlin.math.roundToInt

fun Product.toTrackableFood(): TrackableFood? {
    val carbsPer100g = nutriments.carbohydrates100g
    val proteinPer100g = nutriments.proteins100g
    val fatPer100g = nutriments.fat100g
    val caloriesPer100g = nutriments.energyKcal100g

    return TrackableFood(
        name = productName ,
        carbsPer100g = carbsPer100g.roundToInt(),
        proteinPer100g = proteinPer100g.roundToInt(),
        fatPer100g = fatPer100g.roundToInt(),
        caloriesPer100g = caloriesPer100g.roundToInt(),
        imageUrl = imageFrontThumbUrl
    )
}