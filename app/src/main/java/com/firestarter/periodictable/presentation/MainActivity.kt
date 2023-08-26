package com.firestarter.periodictable.presentation

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.foundation.Canvas
import androidx.compose.foundation.layout.*
import androidx.compose.material.*
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.shadow
import androidx.compose.ui.geometry.Offset
import androidx.compose.ui.geometry.center
import androidx.compose.ui.graphics.Brush
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.text.font.FontStyle
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.tooling.preview.Devices
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.firestarter.periodictable.presentation.ui.theme.*
import com.firestarter.periodictable.presentation.ui.theme.Dimens.paddingLarge

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            PeriodicTableTheme {
                // A surface container using the 'background' color from the theme
                Surface(color = MaterialTheme.colors.background) {
                }
            }
        }
    }
}

@OptIn(ExperimentalMaterialApi::class)
@Preview(showBackground = true, device = Devices.PIXEL)
@Composable
fun Nucleus() {
    Box(contentAlignment = Alignment.Center, modifier = Modifier.fillMaxSize()) {
        Card(
            modifier = Modifier.padding(horizontal = 40.dp),
            elevation = 20.dp,
            shape = Shapes.medium,
            onClick = { /*TODO*/ }
        ) {
            Column(
                modifier = Modifier.fillMaxWidth(),
                horizontalAlignment = Alignment.CenterHorizontally
            ) {
                Spacer(modifier = Modifier.height(40.dp))
                Text(
                    text = "1", // atomic number
                    fontFamily = quicksand,
                    fontWeight = FontWeight.Bold,
                    fontSize = 20.sp,
                    color = darkGray
                )
                Text(
                    text = "H",
                    fontFamily = lora,
                    fontWeight = FontWeight.Bold,
                    fontSize = 96.sp,
                    color = darkGray
                )
                Text(
                    text = "Hydrogen",
                    fontFamily = quicksand,
                    fontWeight = FontWeight.Normal,
                    fontSize = 24.sp,
                    color = darkGray
                )
                Text(
                    modifier = Modifier.padding(top = paddingLarge),
                    text = "1.001", // atomic weight
                    fontFamily = quicksand,
                    fontWeight = FontWeight.Normal,
                    fontSize = 16.sp,
                    color = darkGray
                )
                Spacer(modifier = Modifier.height(40.dp))
            }
        }
    }
}