package com.example.serializablecompose

import android.content.Intent
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
import kotlinx.serialization.Serializable
import kotlinx.serialization.encodeToString
import kotlinx.serialization.json.Json

@Serializable
data class belakov(var age:Int,var iq:Int)

class MainActivity : ComponentActivity() {
    @ExperimentalSerializationApi
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            SerializableComposeTheme {
                // A surface container using the 'background' color from the theme

                val danila = belakov(16,100)
                val danila1 = belakov(16,100)

                val list = listOf(
                    danila,
                    danila1
                )

                val letter = Json.encodeToString(list)

                val intent = Intent(this, MainActivity2::class.java).apply {
                    putExtra("danila",letter)
                }

                startActivity(intent)
            }
        }
    }
}
