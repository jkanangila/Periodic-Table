package com.firestarter.periodictable.domain.use_case

import com.firestarter.periodictable.domain.model.ElementDetails
import com.firestarter.periodictable.domain.repository.ChemicalElementsRepository

class GetChemicalElementDetails(
    private val repository: ChemicalElementsRepository,
    private val useCase: ElectronConfigurationShell
) {
    suspend operator fun invoke(number: Int): ElementDetails {
        val elementDetails = repository.getElementDetails(number).toElementDetails()
        // Add electron configuration
        elementDetails.electronConfigurationBoxNotation = useCase
            .boxNotation(elementDetails.electronConfiguration)
        // Add list of electrons per shell
        elementDetails.electronsPerShell = useCase
            .numberElectronsPerShell(elementDetails.electronConfiguration)

        return elementDetails
    }
}