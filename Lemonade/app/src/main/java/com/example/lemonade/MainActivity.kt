package com.example.lemonade

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.activity.enableEdgeToEdge
import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.PaddingValues
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.wrapContentSize
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.Button
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableIntStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.example.lemonade.ui.theme.LemonadeTheme

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContent {
            LemonadeTheme {
                Scaffold(modifier = Modifier.fillMaxSize()) { innerPadding ->
                    LemonTreeProgression(
                        modifier = Modifier.run { padding(0.dp) },
                        innerPadding
                    )
                }
            }
        }
    }
}

val lemonTree = LemonTree(1)

@Composable
fun LemonTreeProgression(
    modifier: Modifier = Modifier,
    innerPadding: PaddingValues = PaddingValues(0.dp)
) {
    var stage by remember { mutableIntStateOf(lemonTree.stage)}
    Column(
        modifier = modifier
            .padding(innerPadding)
            .background(Color.DarkGray)
            .fillMaxSize()
    ) {
        Column(
            modifier = modifier
                .background(Color.Yellow)
                .fillMaxWidth(),
            verticalArrangement = Arrangement.Top,
            horizontalAlignment = Alignment.CenterHorizontally
        ) {
            Text (
                text = stringResource(R.string.app_name),
                fontSize = 48.sp,
                color = Color(0xFF1A1C19),
                modifier = modifier
            )
        }


        Column(
            modifier = modifier.fillMaxSize(),
            verticalArrangement = Arrangement.Center,
            horizontalAlignment = Alignment.CenterHorizontally
        ) {
            Button(
                onClick = { stage = lemonTree.updateStage() },
                shape = RoundedCornerShape(16.dp),
            ) {
                Column(
                    horizontalAlignment = Alignment.CenterHorizontally
                ) {

                    Image(
                        painter = painterResource(getImageResource(stage)),
                        contentDescription = getImageDescription(stage)
                    )
                    Spacer(modifier = Modifier.height(16.dp))
                    Text(instructionText(stage))
                }
            }
        }
    }
}


@Composable
fun getImageResource(stage: Int): Int {
    return when (stage) {
        1 -> R.drawable.lemon_tree
        2 -> R.drawable.lemon_squeeze
        3 -> R.drawable.lemon_drink
        else -> R.drawable.lemon_restart
    }
}

@Composable
fun getImageDescription(stage: Int): String {
    return when (stage) {
        1 -> stringResource(R.string.lemon_tree)
        2 -> stringResource(R.string.lemon)
        3 -> stringResource(R.string.glass_of_lemonade)
        else -> stringResource(R.string.empty_glass)
    }
}

@Composable
fun instructionText(stage: Int): String {
    return when (stage) {
        1 -> stringResource(R.string.tap_tree)
        2 -> stringResource(R.string.keep_tapping)
        3 -> stringResource(R.string.tap_lemonade)
        else -> stringResource(R.string.tap_glass)
    }
}

@Preview(showBackground = true)
@Composable
fun GreetingPreview() {
    LemonadeTheme {
        LemonTreeProgression()
    }
}