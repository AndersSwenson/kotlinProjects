package com.example.artspace

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.activity.enableEdgeToEdge
import androidx.compose.foundation.Image
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.PaddingValues
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.automirrored.rounded.ArrowBack
import androidx.compose.material.icons.automirrored.rounded.ArrowForward
import androidx.compose.material3.Button
import androidx.compose.material3.ButtonColors
import androidx.compose.material3.Icon
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.remember
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import com.example.artspace.ui.theme.ArtSpaceTheme
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.setValue
import androidx.compose.ui.graphics.painter.Painter

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContent {
            ArtSpaceTheme {
                Scaffold(modifier = Modifier.fillMaxSize()) { innerPadding ->
                    ArtSpaceView(
                        modifier = Modifier.padding(0.dp),
                        innerPadding = innerPadding
                    )
                }
            }
        }
    }
}

@Composable
fun ArtSpaceView(
    modifier: Modifier = Modifier,
    innerPadding: PaddingValues = PaddingValues(0.dp)
) {
    var imageName by remember { mutableStateOf("a") }

    val title = getTitle(imageName)
    val artist = "Anders Swenson"
    val year = "2025"
    val image = getImage(imageName)
    Column(
        horizontalAlignment = Alignment.CenterHorizontally,
        modifier = modifier
            .padding(innerPadding)
    ) {
        Image(
            painter = image,
            contentDescription = title,
            modifier = modifier.weight(2F)
        )
        Row(
            verticalAlignment = Alignment.CenterVertically,
            horizontalArrangement = Arrangement.SpaceBetween,
            modifier = modifier
                .weight(1F)
                .fillMaxWidth()
        ) {
            Button(
                onClick = { imageName = getPreviousImage(imageName) },
                colors = ButtonColors(
                    containerColor = Color.Black,
                    contentColor = Color.White,
                    disabledContainerColor = Color.DarkGray,
                    disabledContentColor = Color.White
                    )
            ) {
                Icon(
                    imageVector = Icons.AutoMirrored.Rounded.ArrowBack,
                    contentDescription = stringResource(id = R.string.previous)
                )
            }
            Column (
                horizontalAlignment = Alignment.CenterHorizontally
            ){
                Text(text = title)
                Text(text = artist)
                Text(text = year)
            }
            Button(
                onClick = { imageName = getNextImage(imageName) },
                colors = ButtonColors(
                    containerColor = Color.Black,
                    contentColor = Color.White,
                    disabledContainerColor = Color.DarkGray,
                    disabledContentColor = Color.White
                )
            ) {
                Icon(
                    imageVector = Icons.AutoMirrored.Rounded.ArrowForward,
                    contentDescription = stringResource(id = R.string.next)
                )
            }
        }
    }
}

fun getNextImage(imageName: String): String {
    return if (imageName == "a") {
        "b"
    } else {
        "a"
    }
}

fun getPreviousImage(imageName: String): String {
    return if (imageName == "b") {
        "a"
    } else {
        "b"
    }
}

fun getTitle(imageName: String): String {
    return "The Letter " + imageName.uppercase()
}

@Composable
fun getImage(imageName: String): Painter {
    var id = R.drawable.a
    if (imageName == "b") {
        id = R.drawable.b
    }
    return painterResource(id = id)
}

@Preview(showBackground = true)
@Composable
fun GreetingPreview() {
    ArtSpaceTheme {
        ArtSpaceView()
    }
}