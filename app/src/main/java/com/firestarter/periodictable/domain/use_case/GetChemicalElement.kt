package com.firestarter.periodictable.domain.use_case

import com.firestarter.periodictable.domain.model.Element
import com.firestarter.periodictable.domain.repository.ChemicalElementsRepository
import com.firestarter.periodictable.domain.util.ElementColorMap

class GetChemicalElement(
    private val repository: ChemicalElementsRepository
) {
    suspend operator fun invoke(number: Int): Element{
        val element = repository.getChemicalElement(number)

        // Add Color
//        element.color = ElementColorMap.COLOR[element.groupBlock]!!

        return element
    }
}