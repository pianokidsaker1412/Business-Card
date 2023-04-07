package com.example.businesscard

import android.graphics.drawable.Icon
import android.media.tv.TvContract.Channels.Logo
import android.os.Bundle
import android.provider.ContactsContract.CommonDataKinds.Email
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.*
import androidx.compose.material.Icon
import androidx.compose.material.MaterialTheme
import androidx.compose.material.Surface
import androidx.compose.material.Text
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Call
import androidx.compose.material.icons.filled.Email
import androidx.compose.material.icons.filled.Share
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.example.businesscard.ui.theme.BusinessCardTheme

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            BusinessCardTheme {
                // A surface container using the 'background' color from the theme
                Surface(
                    modifier = Modifier.fillMaxSize(),
                    color = MaterialTheme.colors.background
                ) {
                    BusinessCardApp(backgroundColor = Color.DarkGray)
                }
            }
        }
    }
}
@Composable
fun BusinessCardApp(backgroundColor: Color) {
    Column(modifier = Modifier.background(backgroundColor)) {
        BusinessCardLogo(name = "Nguyen Thien",
                        title = "Android Developer Extraodinary",
                        phoneNumber = "0969083724",
                        link = "@Android.net",
                        emailAddress = "idngaothien1412@android.com"
        )

//
    }


}
@Composable
fun BusinessCardLogo(name: String,
                     title: String,
                     phoneNumber: String,
                     link: String,
                     emailAddress: String,
                     modifier: Modifier = Modifier ) {
    Column(
        modifier = modifier
            .fillMaxHeight()
            .fillMaxWidth()
            .padding(top = 50.dp),
        horizontalAlignment = Alignment.CenterHorizontally,
        verticalArrangement = Arrangement.Center   ) {
        val image = painterResource(id = R.drawable.android_logo)
        androidx.compose.foundation.Image(painter = image,
                                    contentDescription = null,
                                    modifier.height(120.dp).width(150.dp))
        Text(
            text = name,
            fontSize = 40.sp,
            color = Color.White
        )
        Text(
            text = title,
            fontSize = 16.sp,
            color = Color.Green
        )
        Column(modifier = modifier
            .padding(top = 100.dp, end = 50.dp)
        ){
            Row(){
                androidx.compose.material.Icon(
                    imageVector = Icons.Default.Call,
                    contentDescription = "Call",
                    tint = Color.Green
                )
                Text(
                    text = phoneNumber,
                    fontSize = 16.sp,
                    color = Color.White
                )

            }
            Spacer(Modifier.height(5.dp))
            Row() {
                androidx.compose.material.Icon(imageVector = Icons.Default.Share,
                    contentDescription ="Share",
                    tint = Color.Green)
                Text(
                    text = link,
                    fontSize = 16.sp,
                    color = Color.White
                )

            }
            Spacer(Modifier.height(5.dp))
            Row() {
                androidx.compose.material.Icon(imageVector = Icons.Default.Email,
                    contentDescription ="Email",
                    tint = Color.Green)
                Text(
                    text = emailAddress,
                    fontSize = 16.sp,
                    color = Color.White
                )

            }

        }


    }
    }


@Preview(showBackground = true)
@Composable
fun BusinessCardAppPreview() {
    BusinessCardTheme {
        BusinessCardApp(backgroundColor = Color.DarkGray)
    }
}