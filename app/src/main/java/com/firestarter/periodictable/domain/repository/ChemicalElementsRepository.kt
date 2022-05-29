package com.firestarter.periodictable.domain.repository

import com.firestarter.periodictable.data.data_source.entity.ChemicalElementDetails
import com.firestarter.periodictable.domain.model.ChemicalElement


interface ChemicalElementsRepository {

    suspend fun getChemicalElement(number: Int): ChemicalElement

    suspend fun getElementDetails(number: Int): ChemicalElementDetails
}