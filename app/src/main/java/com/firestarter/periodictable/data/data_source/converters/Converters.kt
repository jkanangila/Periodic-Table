package com.firestarter.periodictable.data.data_source.converters

import androidx.room.TypeConverter

class Converters {
    @TypeConverter
    fun toListFloat(value: String): List<Float> {
        val list = value.split(" ")
        return if (list.isEmpty()) emptyList()
        else list.map { it.toFloat() }
    }

    @TypeConverter
    fun toStringFromFloat(value: List<Float>): String {
        return value.joinToString(" ")
    }

    @TypeConverter
    fun toListInt(value: String): List<Int> {
        val list = value.split(" ")
        return if (list.isEmpty()) emptyList()
        else list.map { it.toInt() }
    }

    @TypeConverter
    fun toStringFromInt(value: List<Int>): String {
        return value.joinToString(" ")
    }
}