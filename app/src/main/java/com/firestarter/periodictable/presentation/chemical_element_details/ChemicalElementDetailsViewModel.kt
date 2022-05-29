package com.firestarter.periodictable.presentation.chemical_element_details

import androidx.compose.runtime.State
import androidx.compose.runtime.mutableStateOf
import androidx.lifecycle.SavedStateHandle
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.firestarter.periodictable.data.data_source.entity.ChemicalElementDetails
import com.firestarter.periodictable.domain.use_case.UseCases
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.launch
import javax.inject.Inject

@HiltViewModel
class ChemicalElementDetailsViewModel @Inject constructor(
    private val useCases: UseCases,
    savedStateHandle: SavedStateHandle
): ViewModel() {

    private val _state = mutableStateOf(ElementState())
    val state: State<ElementState> = _state

    init {
        savedStateHandle.get<String>("number")?.let { idx ->
            getElementDetails(idx.toInt())
        }
    }

    private fun getElementDetails(int: Int) {
        viewModelScope.launch {
            useCases.getChemicalElementDetails(int).also { elementDetails ->
                _state.value = _state.value.copy(
                    elementDetails = elementDetails
                )
            }
        }
    }

    companion object {
        data class ElementState(
            val elementDetails: ChemicalElementDetails? = null
        )
    }
}