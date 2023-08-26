package com.firestarter.periodictable.presentation.chemical_element_details.components

import android.graphics.Color.parseColor
import androidx.compose.foundation.Canvas
import androidx.compose.foundation.layout.*
import androidx.compose.material.MaterialTheme
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.geometry.Offset
import androidx.compose.ui.geometry.center
import androidx.compose.ui.graphics.Brush
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.graphics.Color.Companion.Black
import androidx.compose.ui.graphics.Color.Companion.White
import androidx.compose.ui.graphics.drawscope.Stroke
import androidx.compose.ui.graphics.toArgb
import androidx.compose.ui.tooling.preview.Preview
import androidx.core.graphics.ColorUtils
import com.firestarter.periodictable.presentation.ui.theme.Dimens.atomNucleusSize
import com.firestarter.periodictable.presentation.ui.theme.Dimens.paddingLarge
import com.firestarter.periodictable.util.Atoms.ShellThickness
import com.firestarter.periodictable.util.Atoms.electronRadius
import com.firestarter.periodictable.util.Atoms.period3
import com.firestarter.periodictable.util.Atoms.shellSpacing
import kotlin.math.PI
import kotlin.math.cos
import kotlin.math.sin

@Preview(showBackground = true)
@Composable
fun AtomPreview() {
    Box(modifier = Modifier.padding(paddingLarge)) {
        Atom(
            symbol = period3.symbol,
            electronsPerShell = period3.electronsPerShel,
            cpkHex = period3.cpkHex
        )
    }
}

@Composable
fun Atom(
    symbol: String,
    electronsPerShell: List<Int>, // shells -> chemical_element_details
    cpkHex: String
) {
    val cpkColor = Color(parseColor("#$cpkHex"))
    val lineColor = Color(parseColor("#4e5063"))

    Box(contentAlignment = Alignment.Center) {
        Canvas(modifier = Modifier.size(atomNucleusSize)){
            val center = size.center
            val radius = size.minDimension / 2

            val period = electronsPerShell.size
            val spacing = shellSpacing(period)

            // radius of nucleus and increment to other shells shells
            val nucleusRadius = radius - ((period + 1) * spacing)
            val increment = (radius - nucleusRadius) / period

            // radius of electrons on each shell
            val electronRadius = electronRadius(period)

            // Draw Nucleus
            drawCircle(
                brush = Brush.radialGradient(
                    colors = listOf(
                        Color(
                            ColorUtils.blendARGB(cpkColor.toArgb(), White.toArgb(), .4f)
                        ),
                        cpkColor,
                        Color(
                            ColorUtils.blendARGB(cpkColor.toArgb(), Black.toArgb(), .5f)
                        )
                    ),
                    center = Offset(
                        center.x - nucleusRadius * .8f,
                        center.y - nucleusRadius * .8f,
                    ),
//                    radius = (circleRadius * .1).toFloat()
                ),
                center = center,
                radius = nucleusRadius
            )

            // Draw Inner circles
            repeat(period - 1){ idx ->
                val radiusInner = nucleusRadius + increment * (idx + 1)
                drawCircle(
                    style = Stroke(width = ShellThickness),
                    color = lineColor,
                    center = center,
                    radius = radiusInner
                )
                // Draw electrons on inner circles
                repeat(electronsPerShell[idx]) {
                    val angleIncrement = (2 * PI) / electronsPerShell[idx]
                    val xCord = center.x - radiusInner * cos(PI/2 + angleIncrement * it)
                    val yCord = center.y - radiusInner * sin(PI/2 + angleIncrement * it)

                    drawCircle(
                        brush = Brush.radialGradient(
                            colors = listOf(
                                Color(parseColor("#02386e")),
                                Color(parseColor("#00264d")),
                                Color(parseColor("#00172d")),
                            ),
                            center = Offset(
                                center.x - electronRadius * .5f,
                                center.y - electronRadius * .5f,
                            ),
                        ),
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
                style = Stroke(width = ShellThickness),
                color = lineColor,
                center = center,
                radius = radius
            )
            // Draw electrons on outermost circles
            repeat(electronsPerShell.last()){
                val angleIncrement = (2 * PI) / electronsPerShell.last()
                val xCord = center.x - radius * cos(PI/2 + angleIncrement * it)
                val yCord = center.y - radius * sin(PI/2 + angleIncrement * it)

                drawCircle(
                    brush = Brush.radialGradient(
                        colors = listOf(
                            Color(parseColor("#02386e")),
                            Color(parseColor("#00264d")),
                            Color(parseColor("#00172d")),
                        ),
                        center = Offset(
                            center.x - electronRadius * .5f,
                            center.y - electronRadius * .5f,
                        ),
                    ),
                    radius = electronRadius,
                    center = Offset(
                        x = xCord.toFloat(),
                        y = yCord.toFloat()
                    )
                )
            }
        }

        val typography = when (electronsPerShell.size) {
            1 -> MaterialTheme.typography.h2
            2 -> MaterialTheme.typography.h3
            3 -> MaterialTheme.typography.h3
            4 -> MaterialTheme.typography.h4
            5 -> MaterialTheme.typography.h6
            6 -> MaterialTheme.typography.body1
            7 -> MaterialTheme.typography.body1
            else -> MaterialTheme.typography.body1
        }

        Text(
            text = symbol,
            style = typography.copy(
                color = White
            )
        )

    }
}

