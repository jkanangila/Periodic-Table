package com.firestarter.periodictable.domain.use_case

import com.firestarter.periodictable.data.data_source.entity.ChemicalElementDetails
import com.firestarter.periodictable.domain.repository.ChemicalElementsRepository

class GetChemicalElementDetails(
    private val repository: ChemicalElementsRepository,
) {
    suspend operator fun invoke(number: Int): ChemicalElementDetails {
        val elementDetails = repository.getElementDetails(number)
        // Add electron configuration
        elementDetails.electronConfigurationBoxNotation = ElectronConfigurationShell
            .boxNotation(elementDetails.electronConfiguration)

        return elementDetails
    }
}