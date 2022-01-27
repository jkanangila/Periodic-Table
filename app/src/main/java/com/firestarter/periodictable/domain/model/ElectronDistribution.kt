package com.firestarter.periodictable.domain.model

data class ElectronDistribution(
    val emptyOrbital: Int = 0,
    val halfFilledOrbital: Int = 0,
    val filledOrbital: Int = 0,
    val spdfNotation: String
)
