package com.example.composepractice

sealed class Screens(val screen: String){
    data object Home: Screens("home")
    data object Profile: Screens("profile")
    data object Settings: Screens("settings")
    data object Notifications: Screens("notifications")
    data object Post: Screens("post")
}