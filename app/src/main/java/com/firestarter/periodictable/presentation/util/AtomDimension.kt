package com.firestarter.periodictable.presentation.util

import androidx.compose.ui.unit.dp

object AtomDimension {
    val ShellSpacing = mapOf(
        7 to 35,
        6 to 40,
        5 to 45,
        4 to 50,
        3 to 55,
        2 to 60,
        1 to 65
    )
    const val ShellThickness = 6F

    fun electronRadius(period: Int) = run {
        when {
            period < 3 -> 20F
            period in 4..5 -> 15F
            else -> 10F
        }
    }
}