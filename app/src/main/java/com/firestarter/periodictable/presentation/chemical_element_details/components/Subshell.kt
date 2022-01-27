package com.firestarter.periodictable.presentation.chemical_element_details.components

import androidx.compose.foundation.layout.*
import androidx.compose.material.Icon
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.painter.Painter
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.buildAnnotatedString
import androidx.compose.ui.text.withStyle
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.firestarter.periodictable.R
import com.firestarter.periodictable.domain.model.ElectronDistribution
import com.firestarter.periodictable.presentation.ui.theme.SuperscriptStyle

@Composable
fun Subshell(
    electronDist: ElectronDistribution
) {
    Column(horizontalAlignment = Alignment.CenterHorizontally){
        Row {
            repeat(electronDist.filledOrbital){
                Orbital(painter = painterResource(id = R.drawable.ic_orbital_full))
            }
            repeat(electronDist.halfFilledOrbital){
                Orbital(painter = painterResource(id = R.drawable.ic_orbital_half))
            }
            repeat(electronDist.emptyOrbital){
                Orbital(painter = painterResource(id = R.drawable.ic_orbital_empty))
            }
        }
        Text(
            modifier = Modifier.padding(top = 5.dp),
            fontSize = 18.sp,
            text = buildAnnotatedString {
                append(electronDist.spdfNotation.subSequence(0, 2).toString())
                withStyle(SuperscriptStyle){
                    append(electronDist.spdfNotation
                        .subSequence(2, electronDist.spdfNotation.length).toString())
                }
            }
        )
    }
}

@Composable
fun Orbital(
    painter: Painter
) {
    Icon(
        modifier = Modifier
            .width(35.dp)
            .padding(end = 1.dp),
        painter = painter,
        contentDescription = ""
    )
}