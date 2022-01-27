package com.firestarter.periodictable.domain.model

import androidx.room.PrimaryKey
import com.google.gson.annotations.SerializedName

data class ElementDetails(
    val appearance: String,
    val atomicMass: Int,
    val atomicRadius: String,
    val boil: Int,
    val category: String,
    val cpkHex: String,
    val density: Float,
    val discoveredBy: String,
    val electronAffinity: Float,
    val electronConfiguration: String,
    var electronConfigurationBoxNotation: Map<Int, List<ElectronDistribution>>,
    val electronConfigurationSemantic: String,
    var electronsPerShell: List<Int>, // number of electrons on each shell
    val electronegativityPauling: Float,
    val groupBlock: String,
    val ionizationEnergies: List<Float>,
    val ironRadius: String,
    val molarHeat: Float,
    val name: String,
    val namedBy: String,
    val number: Int,
    val oxidationStates: List<Int>,
    val period: Int,
    val phase: String,
    val shells: List<Int>,
    val source: String,
    val spectralImg: String,
    val standardState: String,
    val summary: String,
    val symbol: String,
    val vanDelWaalsRadius: String,
    val xPos: Int,
    val yPos: Int
)
