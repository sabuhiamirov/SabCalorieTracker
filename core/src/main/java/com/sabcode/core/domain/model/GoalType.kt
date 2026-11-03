package com.sabcode.core.domain.model

sealed class GoalType(val name: String) {
    object LoseWeight : GoalType("lose_weight")
    object KeepWeight : GoalType("keep_weight")
    object GainWeight : GoalType("gain_Weight")

    companion object {
        fun fromString(name: String): GoalType {
            return when (name) {
                "lose_weight" -> LoseWeight
                "keep_weight" -> KeepWeight
                "gain_Weight" -> GainWeight
                else -> KeepWeight
            }
        }
    }
}