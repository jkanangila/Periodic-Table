package com.firestarter.periodictable.data.data_source

import androidx.room.Dao
import androidx.room.Insert
import androidx.room.OnConflictStrategy
import androidx.room.Query
import com.firestarter.periodictable.data.data_source.entity.ElementDetailsEntity
import com.firestarter.periodictable.domain.model.Element

@Dao
interface PeriodicTableDao {

    @Insert(onConflict = OnConflictStrategy.REPLACE)
    suspend fun insertElement(element: ElementDetailsEntity)

    @Query("SELECT name, number, symbol, groupBlock FROM elementdetailsentity WHERE number = :number")
    suspend fun getChemicalElement(number: Int): Element

    @Query("SELECT * FROM elementdetailsentity WHERE number = :number")
    suspend fun getElementDetails(number: Int): ElementDetailsEntity
}