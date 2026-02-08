package com.example.nebula

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.material3.Surface
import androidx.compose.ui.Modifier
import com.example.nebula.ui.NebulaApp
import com.example.nebula.ui.theme.NebulaTheme

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            NebulaTheme {
                Surface(modifier = Modifier) {
                    NebulaApp()
                }
            }
        }
    }
}
