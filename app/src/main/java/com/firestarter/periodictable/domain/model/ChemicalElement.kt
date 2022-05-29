package com.firestarter.periodictable.domain.model

import androidx.compose.ui.graphics.Color
import androidx.room.Ignore

data class ChemicalElement(
    val name: String,
    val number: Int,
    val symbol: String,
    val groupBlock: String,
    @Ignore var color: Color?
){
    constructor(name: String, number: Int, symbol: String, groupBlock: String):
            this(name, number, symbol, groupBlock, null)
}
