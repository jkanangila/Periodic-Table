package com.firestarter.periodictable.data.data_source.entity

import androidx.room.Entity
import androidx.room.PrimaryKey
import com.firestarter.periodictable.domain.model.ElectronDistribution
import com.firestarter.periodictable.domain.model.ElementDetails
import com.google.gson.annotations.SerializedName

@Entity
data class ElementDetailsEntity(
    val appearance: String,
    @SerializedName("atomic_mass")
    val atomicMass: Int,
    @SerializedName("atomic_radius")
    val atomicRadius: String,
    val boil: Int,
//    val color: Any,
    val category: String,
    @SerializedName("cpk-hex")
    val cpkHex: String,
    val density: Float,
    @SerializedName("discovered_by")
    val discoveredBy: String,
    @SerializedName("electron_affinity")
    val electronAffinity: Float,
    @SerializedName("electron_configuration")
    val electronConfiguration: String,
    @SerializedName("electron_configuration_semantic")
    val electronConfigurationSemantic: String,
    @SerializedName("electronegativity_pauling")
    val electronegativityPauling: Float,
    @SerializedName("group_block")
    val groupBlock: String,
    @SerializedName("ionization_energies")
    val ionizationEnergies: String, // List of int
    @SerializedName("iron_radius")
    val ironRadius: String,
    val melt: Float,
    @SerializedName("molar_heat")
    val molarHeat: Float,
    val name: String,
    @SerializedName("named_by")
    val namedBy: String,
    @PrimaryKey val number: Int,
    @SerializedName("oxidation_states")
    val oxidationStates: String,
    val period: Int,
    val phase: String,
    val shells: String, // List of int
    val source: String,
    @SerializedName("spectral_img")
    val spectralImg: String,
    @SerializedName("standard_state")
    val standardState: String,
    val summary: String,
    val symbol: String,
    @SerializedName("vanDelWaals_radius")
    val vanDelWaalsRadius: String,
    @SerializedName("xpos")
    val xPos: Int,
    @SerializedName("ypos")
    val yPos: Int
){
    fun toElementDetails(): ElementDetails{
        return ElementDetails(
            appearance = appearance,
            atomicMass = atomicMass,
            atomicRadius = atomicRadius,
            boil = boil,
            category = category,
            cpkHex = cpkHex,
            density = density,
            discoveredBy = discoveredBy,
            electronAffinity = electronAffinity,
            electronConfiguration = electronConfiguration,
            electronConfigurationBoxNotation = mutableMapOf(),
            electronConfigurationSemantic = electronConfigurationSemantic,
            electronsPerShell = emptyList(),
            electronegativityPauling = electronegativityPauling,
            groupBlock = groupBlock,
            ionizationEnergies = if (ionizationEnergies.split(" ").isNotEmpty())
                ionizationEnergies.split(" ").map { it.toFloat() } else emptyList(),
            ironRadius = ironRadius,
            molarHeat = molarHeat,
            name = name,
            namedBy = namedBy,
            number = number,
            oxidationStates = if (oxidationStates.split(" ").isNotEmpty())
                oxidationStates.split(" ").map { it.toInt() } else emptyList(),
            period = period,
            phase = phase,
            shells = if (shells.split(" ").isNotEmpty())
                shells.split(" ").map { it.toInt() } else emptyList(),
            source = source,
            spectralImg = spectralImg,
            standardState = standardState,
            summary = summary,
            symbol = symbol,
            vanDelWaalsRadius = vanDelWaalsRadius,
            xPos = xPos,
            yPos = yPos
        )
    }
}
