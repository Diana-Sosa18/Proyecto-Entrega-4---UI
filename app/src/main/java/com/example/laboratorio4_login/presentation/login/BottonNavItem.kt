package com.example.laboratorio4_login.presentation.login


import androidx.annotation.DrawableRes
import com.example.laboratorio4_login.R


data class BottomNavItem(
    val label: String,
    @DrawableRes val iconResId: Int,

    val route: String
)