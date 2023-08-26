package com.firestarter.periodictable.presentation.ui.theme

import androidx.compose.material.Typography
import androidx.compose.ui.text.SpanStyle
import androidx.compose.ui.text.TextStyle
import androidx.compose.ui.text.font.Font
import androidx.compose.ui.text.font.FontFamily
import androidx.compose.ui.text.font.FontStyle
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.font.FontWeight.Companion.Bold
import androidx.compose.ui.text.font.FontWeight.Companion.Light
import androidx.compose.ui.text.font.FontWeight.Companion.Normal
import androidx.compose.ui.text.style.BaselineShift
import androidx.compose.ui.unit.sp
import com.firestarter.periodictable.R

val lora = FontFamily(
    Font(R.font.lora_regular, Normal, FontStyle.Normal),
    Font(R.font.lora_italic, Normal, FontStyle.Italic),
    Font(R.font.lora_bold, Bold, FontStyle.Normal),
    Font(R.font.lora_bold_italic, Bold, FontStyle.Italic)
)
val quicksand = FontFamily(
    Font(R.font.quicksand_book, Normal, FontStyle.Normal),
    Font(R.font.quicksand_light, Light, FontStyle.Normal),
    Font(R.font.quicksand_bold, Bold, FontStyle.Normal),
)
// Set of Material typography styles to start with
val SuperscriptStyle = SpanStyle(baselineShift = BaselineShift.Superscript, fontSize = 12.sp)

val Typography = Typography(
    body1 = TextStyle(
        fontFamily = FontFamily.Default,
        fontWeight = Normal,
        fontSize = 16.sp
    )
    /* Other default text styles to override
    button = TextStyle(
        fontFamily = FontFamily.Default,
        fontWeight = FontWeight.W500,
        fontSize = 14.sp
    ),
    caption = TextStyle(
        fontFamily = FontFamily.Default,
        fontWeight = FontWeight.Normal,
        fontSize = 12.sp
    )
    */
)