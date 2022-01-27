package com.firestarter.periodictable.presentation.chemical_element_details.components

import android.graphics.Color
import android.graphics.Typeface
import androidx.compose.foundation.Canvas
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.lazy.LazyRow
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Paint
import androidx.compose.ui.graphics.drawscope.drawIntoCanvas
import androidx.compose.ui.graphics.drawscope.rotate
import androidx.compose.ui.graphics.nativeCanvas
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp

@Preview(showBackground = true)
@Composable
fun IonizationEnergies() {
    Canvas(modifier = Modifier.size(400.dp)){
        val height = size.height
        val width = size.width

        //AXIS TITLES
        val textSizePx = 16.sp.toPx()

        val textPaint = Paint().asFrameworkPaint().apply {
            isAntiAlias = true
            textSize = textSizePx
            color = Color.DKGRAY
            typeface = Typeface.create(Typeface.SANS_SERIF, Typeface.ITALIC)
        }

        // Draw y-axis title
        rotate(degrees = -90F){
            drawIntoCanvas {
                it.nativeCanvas.drawText(
                    "Ionization energies",
                    width / 3.5f,
                    textSizePx,
                    textPaint
                )
            }
        }
    }
}

@Preview(showBackground = true)
@Composable
fun IonizationEnergies2(){
    LazyRow(
        modifier = Modifier
            .height(400.dp)
            .fillMaxWidth(),
//        verticalAlignment = Alignment.CenterVertically
    ){
        item {
            Canvas(modifier = Modifier.fillMaxSize()){
                var string = ""
                repeat(200){
                    string += " ${(it + 1)}"
                }

                val textPaint = Paint().asFrameworkPaint().apply {
                    isAntiAlias = true
                    textSize = 16.sp.toPx()
                    color = Color.DKGRAY
                    typeface = Typeface.create(Typeface.SANS_SERIF, Typeface.ITALIC)
                }

                drawIntoCanvas {
                    it.nativeCanvas.drawText(
                        string,
                        0f,
                        16.sp.toPx(),
                        textPaint
                    )
                }
            }
        }
    }
}