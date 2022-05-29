package com.firestarter.periodictable.data.repository

import com.firestarter.periodictable.data.data_source.PeriodicTableDao
import com.firestarter.periodictable.data.data_source.entity.ChemicalElementDetails
import com.firestarter.periodictable.domain.model.ChemicalElement
import com.firestarter.periodictable.domain.repository.ChemicalElementsRepository

class ChemicalElementRepositoryImpl(
    private val dao: PeriodicTableDao
): ChemicalElementsRepository {

    override suspend fun getChemicalElement(number: Int): ChemicalElement {
        return dao.getChemicalElement(number)
    }

    override suspend fun getElementDetails(number: Int): ChemicalElementDetails {
        return dao.getElementDetails(number)
    }
}