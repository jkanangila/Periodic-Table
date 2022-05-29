package com.firestarter.periodictable.data.data_source.entity

import androidx.room.Entity
import androidx.room.Ignore
import androidx.room.PrimaryKey
import com.firestarter.periodictable.domain.model.ElectronDistribution
import com.google.gson.annotations.SerializedName

@Entity
data class ChemicalElementDetails @JvmOverloads constructor(
    val appearance: String,
    @SerializedName("atomic_mass")
    val atomicMass: Int,
    @SerializedName("atomic_radius")
    val atomicRadius: String,
    val boil: Int,
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
    val ionizationEnergies: List<Float>,
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
    val oxidationStates: List<Int>,
    val period: Int,
    val phase: String,
    val shells: List<Int>,
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
    val yPos: Int,
    @Transient @Ignore var electronConfigurationBoxNotation: Map<Int, List<ElectronDistribution>>? = null,
)