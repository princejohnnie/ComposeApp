package com.example.composeapp

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.*
import androidx.compose.material.Card
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
import androidx.compose.ui.text.font.FontWeight
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
                    ComposeQuadrantApp()
                }
            }
        }
    }
}

@Composable
fun ComposeQuadrantApp() {
    Column(Modifier.fillMaxWidth()) {
        Row(Modifier.weight(1f)) {
            ComposableInfoCard(title = stringResource(id = R.string.first_title),
            stringResource(id = R.string.first_description),
            Color.Green, Modifier.weight(1f))

            ComposableInfoCard(title = stringResource(id = R.string.second_title),
                stringResource(id = R.string.second_description),
                Color.Yellow, Modifier.weight(1f))
        }
        Row(Modifier.weight(1f)) {
            ComposableInfoCard(title = stringResource(id = R.string.third_title),
                stringResource(id = R.string.third_description),
                Color.Cyan, Modifier.weight(1f))

            ComposableInfoCard(title = stringResource(id = R.string.fourth_title),
                stringResource(id = R.string.fourth_description),
                Color.LightGray, Modifier.weight(1f))
        }

    }

}

@Composable
fun ComposableInfoCard(title: String,
                       description: String,
                       backgroundColor: Color,
                       modifier: Modifier = Modifier) {
    Column(modifier = modifier
        .fillMaxSize()
        .background(backgroundColor)
        .padding(16.dp),
    horizontalAlignment = Alignment.CenterHorizontally,
    verticalArrangement = Arrangement.Center) {

        Text(text = title, fontWeight = FontWeight.Bold, modifier = Modifier.padding(16.dp))
        Text(text = description, textAlign = TextAlign.Justify)

    }
}

@Composable
fun QuadrantText(header: String, text: String) {
    Column {
        Text(text = header, modifier = Modifier.padding(bottom = 16.dp)
            , fontWeight = FontWeight.Bold)
        Text(text = text, textAlign = TextAlign.Justify)
    }
}

@Composable
fun ComposeTask() {
    Column(modifier = Modifier
        .fillMaxWidth()
        .fillMaxHeight(),
        horizontalAlignment = Alignment.CenterHorizontally,
        verticalArrangement = Arrangement.Center
    ) {
        val image = painterResource(id = R.drawable.task_completed)
        Image(painter = image, contentDescription = null)
        Text(text = stringResource(id = R.string.task_complete_text),
            fontSize = 24.sp, textAlign = TextAlign.Center,
            modifier = Modifier.padding(top = 24.dp, bottom = 8.dp)
        )
        Text(text = stringResource(id = R.string.nice_work_text), fontSize = 16.sp
        )
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
            modifier = Modifier
                .fillMaxWidth()
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
fun ComposeTaskPreview() {
    ComposeQuadrantApp()
}

/*@Preview(showBackground = true)
@Composable
fun ComposeArticlePreview() {
    ComposeArticle()
}*/

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
