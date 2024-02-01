package com.example.assignment4_theming

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.Button
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.OutlinedTextField
import androidx.compose.material3.Surface
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import com.example.assignment4_theming.ui.theme.Assignment4_ThemingTheme


class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            Assignment4_ThemingTheme {
                // A surface container using the 'background' color from the theme
                Surface(
                    modifier = Modifier.fillMaxSize(),
                    color = MaterialTheme.colorScheme.background
                ) {
                    MyApp()
                }
            }
        }
    }
}

@Composable
fun MyApp() {
    val appModifier = Modifier.fillMaxWidth().padding(8.dp)
    Column {
        Text(
            text = "My Title",
            style = MaterialTheme.typography.bodyLarge,
            modifier = appModifier
        )
        OutlinedTextField(
            value = "",
            onValueChange = {/*TODO*/},
            modifier = appModifier
        )
        Button(
            onClick = { /*TODO*/ },
            shape = MaterialTheme.shapes.medium,
            modifier = appModifier
        ) {
            Text(text = "Submit")
        }
    }

}

@Preview(showBackground = true)
@Composable
fun MyAppPreview() {
    Assignment4_ThemingTheme {
        MyApp()
    }
}