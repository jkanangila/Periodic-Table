package com.firestarter.periodictable.data.data_source

import androidx.room.Dao
import androidx.room.Insert
import androidx.room.OnConflictStrategy
import androidx.room.Query
import com.firestarter.periodictable.data.data_source.entity.ChemicalElementDetails
import com.firestarter.periodictable.domain.model.ChemicalElement

@Dao
interface PeriodicTableDao {

    @Insert(onConflict = OnConflictStrategy.REPLACE)
    suspend fun insertElement(chemicalElement: ChemicalElementDetails)

    @Query("SELECT name, number, symbol, groupBlock FROM chemicalelementdetails WHERE number = :number")
    suspend fun getChemicalElement(number: Int): ChemicalElement

    @Query("SELECT * FROM chemicalelementdetails WHERE number = :number")
    suspend fun getElementDetails(number: Int): ChemicalElementDetails
}