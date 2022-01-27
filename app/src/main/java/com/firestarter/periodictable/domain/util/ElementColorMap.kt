package com.firestarter.periodictable.domain.util

import com.firestarter.periodictable.presentation.ui.theme.*

object ElementColorMap {
    val COLOR = mapOf(
        "alkali metal" to MainGroupMetals,
        "alkaline earth metal" to MainGroupMetals,
        "metal" to MainGroupMetals,
        "transition metal" to TransitionMetals,
        "metalloid" to Metalloids,
        "nonmetal" to NonMetals,
        "halogen" to NonMetals,
        "noble gas" to NobleGas,
        "lanthanoid" to TransUranium,
        "actinoid" to TransUranium,
        "post-transition metal" to TransUranium
    )
}