package com.classicagames.myapplication


import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.material.*
import androidx.compose.runtime.*
import androidx.compose.ui.tooling.preview.Preview
import com.classicagames.myapplication.ui.screens.LandScreen
import com.classicagames.myapplication.ui.theme.YellowTheme


class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            YellowTheme { // A surface container using the 'background' color from the theme
                Surface(color = MaterialTheme.colors.primary) {
                    LandScreen()
                }

            }
        }
    }
    @Preview(showBackground = true)
    @Composable
    fun DefaultPreview() {
        YellowTheme { // A surface container using the 'background' color from the theme
            LandScreen()
        }
    }
}











