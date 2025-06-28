package com.example.calendar.ui.screens.home

import androidx.compose.runtime.*
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import kotlinx.coroutines.delay
import kotlinx.coroutines.launch

class HomeViewModel : ViewModel() {

    var city by mutableStateOf("Semarang")
        private set

    var date by mutableStateOf("Today, 12 September")
        private set

    var temperature by mutableStateOf("29°")
        private set

    var description by mutableStateOf("Cloudy")
        private set

    var windSpeed by mutableStateOf("10 km/h")
        private set

    var humidity by mutableStateOf("54%")
        private set

    // Giả lập fetch API
    fun fetchWeather() {
        viewModelScope.launch {
            delay(1000) // Giả delay
            // Giả lập dữ liệu từ server
            city = "Semarang"
            date = "Today, 12 September"
            temperature = "29°"
            description = "Cloudy"
            windSpeed = "10 km/h"
            humidity = "54%"
        }
    }
}
