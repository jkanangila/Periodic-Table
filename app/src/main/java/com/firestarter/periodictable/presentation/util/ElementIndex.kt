package com.firestarter.periodictable.presentation.util

object ElementIndex {
    // EACH ENTRY CORRESPONDS TO A COLUMN
    val GROUP_1A_2A = listOf(
        listOf(1,null),
        listOf(
            "1A\n(1)\nAlkali metals",
            "2A\n(2)\nAlkaline earth metals"
        ),
        listOf(3,4),
        listOf(11,12),
        listOf(19,20),
        listOf(37,38),
        listOf(55,56),
        listOf(87,88),
    )

    // EACH ENTRY CORRESPONDS TO A COLUMN
    val GROUP_3A_4A_5A_6A_7A_8A = listOf(
        listOf(
            "3A\n13\nBoron family",
            "4A\n(14)\nCarbon family",
            "5A\n(15)\nPnictogens",
            "6A\n(16)\nChalcogens",
            "7A\n(17)\nHalogens",
            "8A\n(18)\nNobel gases"
        ),
        listOf(null,null,null,null,null,2),
        listOf(5,6,7,8,9,10),
        listOf(13,14,15,16,17,18),
        listOf(31,32,33,34,35,36),
        listOf(49,50,51,52,53,54),
        listOf(81,82,83,84,85,86),
        listOf(113,114,115,null,118),
    )

    // EACH ENTRY CORRESPONDS TO A COLUMN
    val TRANSITION_METALS = listOf(
        listOf(
            listOf(
                "3B\n(3)\nScandium family",
                "4B\n(4)\nTitanium family",
                "5B\n(5)\nvanadium family",
                "6B\n(6)\nChromium family",
                "7B\n(7)\nManganese family",
                "8B\n(8)\nIron family",
                "8B\n(9)\nCobalt family",
                "8B\n(10)\nNickel family",
                "1B\n(11)\nCopper family",
                "2B\b(12)\nZinc family"
            ),
            listOf(21,39,57,89),
            listOf(22,40,72,104),
            listOf(23,41,73,105),
            listOf(24,42,74,106),
            listOf(25,43,75,107),
            listOf(26,44,76,108),
            listOf(27,45,77,109),
            listOf(28,46,78,110),
            listOf(29,47,79,111),
            listOf(30,48,80,112),
        )
    )

    val LANTHANIDES_ACTINIDES = listOf(
        listOf(58,90),
        listOf(59,91),
        listOf(60,92),
        listOf(61,93),
        listOf(62,94),
        listOf(63,95),
        listOf(64,96),
        listOf(65,97),
        listOf(66,98),
        listOf(67,99),
        listOf(68,100),
        listOf(69,101),
        listOf(70,102),
        listOf(71,103),
    )

    val LANTHANIDES = listOf(
        58,59,60,61,62,63,64,65,66,67,68,69,70,71
    )

    val ACTINIDES = listOf(
        90,91,92,93,94,95,96,97,98,99,100,101,102,103
    )
}