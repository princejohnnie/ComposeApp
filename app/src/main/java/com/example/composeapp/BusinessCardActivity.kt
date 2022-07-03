package com.example.composeapp

import android.media.Image
import androidx.compose.foundation.Image
import androidx.compose.foundation.layout.*
import androidx.compose.material.Divider
import androidx.compose.material.Icon
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.graphics.ImageBitmap
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.unit.TextUnit
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp

@Composable
fun BusinessCardApp() {
    Box {
        Column(horizontalAlignment = Alignment.CenterHorizontally,
            verticalArrangement = Arrangement.Center,
            modifier = Modifier.fillMaxSize()
        ) {
            CenterDetails("John Uzodinma", "Android Developer Extraordinaire")
            Spacer(modifier = Modifier
                .fillMaxWidth()
                .height(100.dp))
        }

        Column(horizontalAlignment = Alignment.Start,
            verticalArrangement = Arrangement.Bottom,
            modifier = Modifier
                .fillMaxSize()
                .padding(bottom = 36.dp)
        ) {
            ContactDetail(icon = R.drawable.call_icon_colored, contact = "08109514619")
            ContactDetail(icon = R.drawable.share_icon, contact = "@princejohnc30")
            ContactDetail(icon = R.drawable.mail_icon, contact = "princejohnc35@gmail.com")
        }
    }

}

@Composable
private fun CenterDetails(name: String, title: String) {
    Column(horizontalAlignment = Alignment.CenterHorizontally) {
        Image(painter = painterResource(id = R.drawable.resume_photo_reduced), contentDescription = null, modifier = Modifier.size(120.dp, 120.dp))
        Text(text = name, fontSize = 32.sp, color = Color.White)
        Text(text = title, fontSize = 16.sp, color = Color(0xFF3DDC84), modifier = Modifier.padding(top = 8.dp))
    }
}

@Composable
private fun ContactDetail(icon: Int, contact: String) {
    Column {
        Divider(color = Color.White)
        Row(horizontalArrangement = Arrangement.Start,
            modifier = Modifier.padding(0.dp, 8.dp, 0.dp, 8.dp)
        ) {
            Icon(painterResource(icon), contentDescription = null, Modifier.padding(start = 24.dp), tint = Color(61, 220, 132))
            Text(text = contact, Modifier.padding(start = 48.dp))
        }
    }
}