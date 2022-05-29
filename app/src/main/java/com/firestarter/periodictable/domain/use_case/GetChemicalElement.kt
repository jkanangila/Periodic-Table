package com.firestarter.periodictable.domain.use_case

import androidx.compose.ui.graphics.Color
import com.firestarter.periodictable.domain.model.ChemicalElement
import com.firestarter.periodictable.domain.repository.ChemicalElementsRepository
import com.firestarter.periodictable.domain.util.ColorMap

class GetChemicalElement(
    private val repository: ChemicalElementsRepository
) {
    suspend operator fun invoke(number: Int): ChemicalElement{
        val element = repository.getChemicalElement(number)
        element.color = ColorMap.groupBlockColor[element.groupBlock] ?: Color.White

        return element
    }
}