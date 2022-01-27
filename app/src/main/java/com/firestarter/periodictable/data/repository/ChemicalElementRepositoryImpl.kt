package com.firestarter.periodictable.data.repository

import com.firestarter.periodictable.data.data_source.PeriodicTableDao
import com.firestarter.periodictable.data.data_source.entity.ElementDetailsEntity
import com.firestarter.periodictable.domain.model.Element
import com.firestarter.periodictable.domain.repository.ChemicalElementsRepository

class ChemicalElementRepositoryImpl(
    private val dao: PeriodicTableDao
): ChemicalElementsRepository {

    override suspend fun getChemicalElement(number: Int): Element {
        return dao.getChemicalElement(number)
    }

    override suspend fun getElementDetails(number: Int): ElementDetailsEntity {
        return dao.getElementDetails(number)
    }
}