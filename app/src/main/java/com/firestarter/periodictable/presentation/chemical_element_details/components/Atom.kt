package com.firestarter.periodictable.presentation.chemical_element_details.components

import androidx.compose.foundation.Canvas
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.size
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.geometry.Offset
import androidx.compose.ui.geometry.center
import androidx.compose.ui.graphics.Brush
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.graphics.drawscope.Stroke
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.sp
import com.firestarter.periodictable.presentation.util.AtomDimension
import com.firestarter.periodictable.util.Constants
import kotlin.math.PI
import kotlin.math.cos
import kotlin.math.sin

@Composable
fun Atom(
    symbol: String,
    electrons: List<Int>,
    cpkHex: String
) {
    Box(contentAlignment = Alignment.Center) {
        Canvas(modifier = Modifier.size(Constants.figureSize)){
            val center = size.center
            val radius = size.minDimension / 2

            val period = electrons.size
            val spacing = AtomDimension.ShellSpacing[period]!!

            // radius of nucleus and increment to other shells shells
            val nucleusRadius = radius - ((period + 1) * spacing)
            val increment = (radius - nucleusRadius) / period

            // radius of electrons on each shell
            val electronRadius = AtomDimension.electronRadius(period)

            // Draw Nucleus
            drawCircle(
                color = Color.Red,
                center = center,
                radius = nucleusRadius // 200
            )
            drawCircle(
                brush = Brush.radialGradient(colors = listOf(Color.Transparent, Color.White)),
                center = center,
                radius = nucleusRadius // 200
            )

            // Draw Inner circles
            repeat(period - 1){ idx ->
                val radiusInner = nucleusRadius + increment * (idx + 1)
                drawCircle(
                    style = Stroke(width = AtomDimension.ShellThickness),
                    color = Color.DarkGray,
                    center = center,
                    radius = radiusInner
                )
                // Draw electrons on inner circles
                repeat(electrons[idx]){
                    val angleIncrement = (2 * PI) / electrons[idx]
                    val xCord = center.x - radiusInner * cos(PI/2 + angleIncrement * it)
                    val yCord = center.y - radiusInner * sin(PI/2 + angleIncrement * it)

                    drawCircle(
                        color = Color.DarkGray,
                        radius = electronRadius,
                        center = Offset(
                            x = xCord.toFloat(),
                            y = yCord.toFloat()
                        )
                    )
                }
            }

            // Draw outermost circle
            drawCircle(
                style = Stroke(width = AtomDimension.ShellThickness),
                color = Color.DarkGray,
                center = center,
                radius = radius
            )
            // Draw electrons on outermost circles
            repeat(electrons.last()){
                val angleIncrement = (2 * PI) / electrons.last()
                val xCord = center.x - radius * cos(PI/2 + angleIncrement * it)
                val yCord = center.y - radius * sin(PI/2 + angleIncrement * it)

                drawCircle(
                    color = Color.DarkGray,
                    radius = electronRadius,
                    center = Offset(
                        x = xCord.toFloat(),
                        y = yCord.toFloat()
                    )
                )
            }
        }

        Text(text = symbol, fontSize = 24.sp, color = Color.White, fontWeight = FontWeight.Black)

    }
}

