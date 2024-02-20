package com.example.assignment7_bmiwithviewmodel

import androidx.compose.runtime.mutableStateOf
import androidx.lifecycle.ViewModel
import androidx.compose.runtime.getValue
import androidx.compose.runtime.setValue

class BmiViewModel: ViewModel() {
    var heightInput by mutableStateOf("")
    var weightInput by mutableStateOf("")
    val height: Float
        get() {
            return heightInput.toFloatOrNull() ?: 0.0f
        }
    val weight: Int
        get() {
            return weightInput.toIntOrNull() ?: 0
        }
    val bmi: Float
        get() {
            return calculateBmi()
        }
    fun changeHeightInput(newHeight: String) {
        heightInput = newHeight
    }
    fun changeWeightInput(newWeight: String) {
        weightInput = newWeight
    }
    private fun calculateBmi(): Float {
        return if (weight > 0 && height > 0) weight / (height * height) else 0.0f
    }
}