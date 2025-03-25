package com.example.thefourcompose

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.activity.enableEdgeToEdge
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.PaddingValues
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxHeight
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Surface
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import com.example.thefourcompose.ui.theme.TheFourComposeTheme

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContent {
            TheFourComposeTheme {
                Scaffold(modifier = Modifier.fillMaxSize()) { innerPadding ->
                    FourCompose(innerPadding,
                        modifier = Modifier.run { padding(0.dp) }
                    )
                }
            }
        }
    }
}


@Composable
fun FourCompose(innerPadding: PaddingValues = PaddingValues(0.dp), modifier: Modifier = Modifier) {
    val textCompose = stringResource(R.string.text_composable)
    val imageCompose = stringResource(R.string.image_composable)
    val rowCompose = stringResource(R.string.row_composable)
    val columnCompose = stringResource(R.string.column_composable)
    val textInfo = stringResource(R.string.text_info)
    val imageInfo = stringResource(R.string.image_info)
    val rowInfo = stringResource(R.string.row_info)
    val columnInfo = stringResource(R.string.columnInfo)

    Column(
        modifier = modifier
            .padding(innerPadding)
            .fillMaxWidth()
    ) {
        Row(
            modifier = modifier.weight(1f)
        ) {

            SingleCompose(
                textCompose,
                textInfo,
                Color(0xFFEADDFF),
                modifier.weight(1f))

            SingleCompose(
                imageCompose,
                imageInfo,
                Color(0xFFD0BCFF),
                modifier.weight(1f))

        }

        Row(
            modifier = modifier.weight(1f)
        ) {

            SingleCompose(
                rowCompose,
                rowInfo,
                Color(0xFFD0BCFF),
                modifier.weight(1f))

            SingleCompose(
                columnCompose,
                columnInfo,
                Color(0xFFEADDFF),
                modifier.weight(1f))

        }

    }
}


@Composable
fun SingleCompose(composeType: String, composeInfo: String, composeColor: Color, modifier: Modifier = Modifier) {
    Column(
        modifier = modifier
            .fillMaxSize()
            .background(composeColor)
            .padding(16.dp),
        verticalArrangement = Arrangement.Center,
        horizontalAlignment = Alignment.CenterHorizontally

    ) {
        Text(
            text = composeType,
            fontWeight = FontWeight.Bold,
            modifier = Modifier.padding(bottom = 16.dp)
        )
        Text(
            text = composeInfo,
            textAlign = TextAlign.Justify
            //Looks better without TextAlign.Justify
        )
    }
}

@Preview(showBackground = true)
@Composable
fun GreetingPreview() {
    TheFourComposeTheme {
        FourCompose()
    }
}