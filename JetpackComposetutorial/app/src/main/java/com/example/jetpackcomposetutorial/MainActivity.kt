package com.example.jetpackcomposetutorial

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.activity.enableEdgeToEdge
import androidx.compose.foundation.Image
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.example.jetpackcomposetutorial.ui.theme.JetpackComposeTutorialTheme

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContent {
            JetpackComposeTutorialTheme {
                Scaffold(modifier = Modifier.fillMaxSize()) { innerPadding ->
                    JpTutorialScreen(
                        modifier = Modifier.padding(innerPadding)
                    )
                }
            }
        }
    }
}


@Composable
fun JpTutorialScreen(modifier: Modifier = Modifier) {
    val title = stringResource(R.string.app_name)
    val description = stringResource(R.string.jp_description)
    val task = stringResource(R.string.jp_task)
    val image = painterResource(R.drawable.bg_compose_background)
    Column(
        verticalArrangement = Arrangement.Center,
        modifier = modifier
    ) {
        Image(
            painter = image,
            contentDescription = null,
            contentScale = ContentScale.FillWidth,
            modifier = modifier
        )
        Text(
            text = title,
            fontSize = 24.sp,
            modifier = Modifier.padding(16.dp)
        )
        Text(
            text = description,
            textAlign = TextAlign.Left,
            modifier = Modifier.padding(start = 16.dp, end = 16.dp)
        )
        Text(
            text = task,
            textAlign = TextAlign.Left,
            modifier = Modifier.padding(16.dp)
        )
    }
}


@Preview(showBackground = true)
@Composable
fun GreetingPreview() {
    JetpackComposeTutorialTheme {
        JpTutorialScreen()
    }
}