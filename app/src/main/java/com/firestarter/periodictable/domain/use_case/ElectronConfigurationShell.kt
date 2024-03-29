package com.firestarter.periodictable.domain.use_case

import com.firestarter.periodictable.domain.model.ElectronDistribution

object ElectronConfigurationShell {

    fun boxNotation(electronConfiguration: String): Map<Int, List<ElectronDistribution>>{
        // e.g. electronConfiguration = "1s2 2s2 2p6 3s1"

        val boxNotation = mutableMapOf<Int, MutableList<ElectronDistribution>>()

        // map orbitals to their corresponding shells
        electronConfiguration.split(" ").forEach {
            // if the period is not in the map add an entry for it
            val period = it[0].toString().toInt()
            if (boxNotation[period].isNullOrEmpty()){
                boxNotation[period] = mutableListOf(electronDistributionSubshell(it))
            } else {
                // simply append otherwise append
                boxNotation[period]?.add(electronDistributionSubshell(it))
            }
        }
        return boxNotation
    }

    private fun numberOrbitalsPerSubShell(orbital: String) = when(orbital) {
        "s" -> 1
        "p" -> 3
        "d" -> 5
        "f" -> 7
        "g" -> 9
        "h" -> 11
        else -> 0
    }

    private fun electronDistributionSubshell(spdfString: String): ElectronDistribution{
        val numberElectrons = spdfString.subSequence(2, spdfString.length).toString().toInt()
        val subShellType = spdfString[1]
        val numberOrbitals = numberOrbitalsPerSubShell(subShellType.toString())

        return when{
            numberElectrons <= numberOrbitals -> {
                val emptyOrbital = numberOrbitals - numberElectrons
                val halfFilledOrbital = numberOrbitals - emptyOrbital

                ElectronDistribution(emptyOrbital = emptyOrbital, halfFilledOrbital = halfFilledOrbital, filledOrbital = 0, spdfNotation = spdfString)
            }

            numberElectrons > numberOrbitals -> {
                val filledOrbital = numberElectrons - numberOrbitals
                val halfFilledOrbital = numberOrbitals - filledOrbital

                ElectronDistribution(emptyOrbital = 0, halfFilledOrbital = halfFilledOrbital, filledOrbital = filledOrbital, spdfNotation = spdfString)
            }

            else -> ElectronDistribution(emptyOrbital = 0, halfFilledOrbital = 0, filledOrbital = 0, spdfNotation = "")
        }
    }
}