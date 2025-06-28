package com.example.calendar.navigation


import androidx.compose.runtime.Composable
import androidx.navigation.NavHostController
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import com.example.calendar.ui.screens.home.HomeScreen

object Routes {
    const val HOME = "home"
    const val DETAIL = "detail"
    const val FORECAST = "forecast"
    const val NOTIFICATION = "notification"
    const val ONBOARDING = "onboarding"
}

@Composable
fun AppNavigation(navController: NavHostController) {
    NavHost(navController = navController, startDestination = Routes.HOME) {
        composable(Routes.HOME) {
            HomeScreen()
        }

        // Các màn hình khác bạn thêm sau, ví dụ:
        /*
        composable(Routes.FORECAST) { ForecastScreen() }
        composable(Routes.NOTIFICATION) { NotificationScreen() }
        composable(Routes.ONBOARDING) { OnboardingScreen() }
        */
    }
}
