package com.example.businesscard

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.activity.enableEdgeToEdge
import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.PaddingValues
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.padding
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Call
import androidx.compose.material.icons.filled.Email
import androidx.compose.material.icons.filled.Share
import androidx.compose.material3.Icon
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.graphics.vector.ImageVector
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.example.businesscard.ui.theme.BusinessCardTheme

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContent {
            BusinessCardTheme {
                Scaffold(modifier = Modifier.fillMaxSize()) { innerPadding ->
                    BCard (
                        modifier = Modifier.padding(0.dp),
                        name = "Anders Swenson",
                        title = "Software Engineer",
                        innerPadding = innerPadding
                    )
                }
            }
        }
    }
}

@Composable
fun BCard(
    modifier: Modifier = Modifier,
    name: String,
    title: String,
    innerPadding: PaddingValues = PaddingValues(0.dp)
) {
    val image = painterResource(R.drawable.android_logo)
    Column (
        modifier = modifier
            .padding(innerPadding)
            .background(Color.DarkGray)
            .fillMaxSize()
    ) {
        Column(
            verticalArrangement = Arrangement.Center,
            horizontalAlignment = Alignment.CenterHorizontally,
            modifier = modifier
        ) {
            Image(
                painter = image,
                contentDescription = null,
                modifier = modifier
            )
            Text(
                text = name,
                fontWeight = FontWeight.Bold,
                color = Color.White,
                fontSize = 48.sp,
                modifier = Modifier.padding(top = 24.dp, bottom = 8.dp)
            )
            Text(
                text = title,
                fontSize = 24.sp,
                color = Color.White,
                modifier = Modifier
            )
        }

        Column(
            verticalArrangement = Arrangement.Bottom,
            horizontalAlignment = Alignment.CenterHorizontally,
            modifier = modifier
                .weight(1f)
                .fillMaxSize()
        ) {
            ContactInfo(
                info = "(978) 496-0784",
                infoType = "GitHub",
                iconItem = Icons.Filled.Call
            )
            ContactInfo(
                info = "@AndroidDev",
                infoType = "Share",
                iconItem = Icons.Filled.Share
            )
            ContactInfo(
                info = "anders.swenson@gmail.com",
                infoType = "e-Mail",
                iconItem = Icons.Filled.Email
            )
        }
    }


}

@Composable
fun ContactInfo(
    modifier: Modifier = Modifier,
    info: String,
    infoType: String,
    iconItem: ImageVector
) {
    Row(
        modifier = Modifier.padding(bottom = 8.dp)
    ) {
        Icon(
            imageVector = iconItem,
            contentDescription = infoType,
            tint = Color.White,
            modifier = modifier
        )
        Text(
            text = info,
            fontSize = 16.sp,
            color = Color.White,
            modifier = Modifier.padding(start = 8.dp)
        )
    }
}


@Preview(showBackground = true)
@Composable
fun GreetingPreview() {
    BusinessCardTheme {
        BCard (
            modifier = Modifier.padding(0.dp),
            name = "Anders Swenson",
            title = "Software Engineer"
        )
    }
}