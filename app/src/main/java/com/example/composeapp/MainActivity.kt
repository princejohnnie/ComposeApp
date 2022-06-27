package com.example.composeapp

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.foundation.Image
import androidx.compose.foundation.layout.*
import androidx.compose.material.MaterialTheme
import androidx.compose.material.Surface
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.example.composeapp.ui.theme.ComposeAppTheme

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            ComposeAppTheme {
                // A surface container using the 'background' color from the theme
                Surface(color = MaterialTheme.colors.background) {
                    ComposeArticle()
                }
            }
        }
    }
}

@Composable
fun ComposeArticle() {
    Column {
        HeaderImage()
        ContentText()
    }
}

@Composable
fun HeaderImage() {
    val image = painterResource(id = R.drawable.compose_background)
    Image(painter = image, contentDescription = null,
        modifier = Modifier.fillMaxWidth())
}

@Composable
fun ContentText() {
    Column {
        Text(text = stringResource(id = R.string.topic_text), fontSize = 24.sp,
            modifier = Modifier.fillMaxWidth()
                .wrapContentWidth(Alignment.CenterHorizontally)
                .padding(16.dp))
        Text(text = stringResource(id = R.string.definition_text),
            modifier = Modifier.padding(start = 16.dp, end = 16.dp),
            textAlign = TextAlign.Justify)
        Text(text = stringResource(id = R.string.explanation_text),
            modifier = Modifier.padding(16.dp),
            textAlign = TextAlign.Justify)
    }
} 

@Composable
fun BirthdayGreetingWithImage(message: String, from: String) {
    val image = painterResource(id = R.drawable.androidparty)
    Box {
        Image(painter = image, contentDescription = null,
            modifier = Modifier
                .fillMaxHeight()
                .fillMaxWidth(),
            contentScale = ContentScale.Crop)
    }
    BirthdayGreetingsWithText(message = message, from = from)
}

@Composable
fun BirthdayGreetingsWithText(message: String, from: String) {
    Column {
        Text(text = message, fontSize = 36.sp,
            modifier = Modifier
                .fillMaxWidth()
                .wrapContentWidth(Alignment.CenterHorizontally)
                .padding(start = 16.dp, top = 16.dp))
        Text(text = from, fontSize = 24.sp,
        modifier = Modifier
            .fillMaxWidth()
            .wrapContentWidth(Alignment.CenterHorizontally)
            .padding(start = 16.dp, end = 16.dp))
    }
}

@Composable
fun Greeting(name: String) {
    Surface(color = Color.Gray) {
        Text(text = "Hello my name is $name!", modifier = Modifier.padding(20.dp, 20.dp))
    }
}

@Preview(showBackground = true)
@Composable
fun ComposeArticlePreview() {
    ComposeArticle()
}

/*
@Preview(showBackground = true)
@Composable
fun BirthdayGreetingWithTextPreview() {
    BirthdayGreetingWithImage(message = stringResource(id = R.string.happy_birthday_text),
        stringResource(id = R.string.signature_text))
}
*/

/*
@Preview(showBackground = true)
@Composable
fun DefaultPreview() {
    ComposeAppTheme {
        Greeting("Johnny")
    }
}*/
