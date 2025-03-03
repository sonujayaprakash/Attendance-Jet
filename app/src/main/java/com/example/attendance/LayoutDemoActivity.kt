package com.example.attendance

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.activity.enableEdgeToEdge
import androidx.compose.runtime.Composable
import androidx.compose.ui.tooling.preview.Preview
import com.example.attendance.ui.theme.AttendanceTheme


class LayoutDemoActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContent {
            LayoutDemo()
        }
    }
}

@Composable
fun LayoutDemo(){


}

@Preview(showBackground = true)
@Composable
fun GreetingPreview() {
    AttendanceTheme {
        LayoutDemo()
    }
}