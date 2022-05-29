package com.firestarter.periodictable.presentation.util


object AtomDimension {

    fun shellSpacing(period: Int) = when (period) {
        7 -> 35
        6 -> 40
        5 -> 45
        4 -> 50
        3 -> 55
        2 -> 60
        1 -> 65
        else -> 0
    }

    const val ShellThickness = 6F

    fun electronRadius(period: Int) = run {
        when {
            period < 3 -> 20F
            period in 4..5 -> 15F
            else -> 10F
        }
    }
}