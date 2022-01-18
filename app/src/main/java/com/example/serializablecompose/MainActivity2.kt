package com.example.serializablecompose

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.material.MaterialTheme
import androidx.compose.material.Surface
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.tooling.preview.Preview
import com.example.serializablecompose.ui.theme.SerializableComposeTheme
import kotlinx.serialization.ExperimentalSerializationApi
import kotlinx.serialization.decodeFromString
import kotlinx.serialization.json.Json

class MainActivity2 : ComponentActivity() {
    @ExperimentalSerializationApi
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            SerializableComposeTheme {
                // A surface container using the 'background' color from the theme
                    val danila = intent.getStringExtra("danila")
                    val belakov = Json.decodeFromString<List<belakov>>("""$danila""")
                    Greeting("${belakov[0].age} ${belakov[0].iq} ${belakov[1].age} ${belakov[1].iq}")

            }
        }
    }
}

@Composable
fun Greeting(name: String) {
    Text(text = "$name")
}

@Preview(showBackground = true)
@Composable
fun DefaultPreview() {
    SerializableComposeTheme {
        Greeting("Android")
    }
}