package com.firestarter.periodictable.domain.repository

import com.firestarter.periodictable.data.data_source.entity.ElementDetailsEntity
import com.firestarter.periodictable.domain.model.Element


interface ChemicalElementsRepository {

    suspend fun getChemicalElement(number: Int): Element

    suspend fun getElementDetails(number: Int): ElementDetailsEntity
}