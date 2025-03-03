package com.example.attendance

import android.content.Intent
import android.os.Bundle
import android.widget.Toast
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.activity.enableEdgeToEdge
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.ExperimentalLayoutApi
import androidx.compose.foundation.layout.FlowRow
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Menu
import androidx.compose.material3.Button
import androidx.compose.material3.Card
import androidx.compose.material3.CenterAlignedTopAppBar
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.Icon
import androidx.compose.material3.IconButton
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Text
import androidx.compose.material3.TopAppBarDefaults
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.rememberCoroutineScope
import androidx.compose.runtime.setValue
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import com.example.attendance.ui.theme.AttendanceTheme
import kotlinx.coroutines.launch

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContent {
            AttendanceTheme {
                MainDemo()
            }
        }
    }
}

@kotlin.OptIn(ExperimentalMaterial3Api::class, ExperimentalLayoutApi::class)
@Composable
fun MainDemo(modifier: Modifier = Modifier) {

    val context = LocalContext.current
    val scope = rememberCoroutineScope()

    var onSelected by remember { mutableStateOf<String?>(null) }

    Scaffold(topBar = {
        CenterAlignedTopAppBar(
            title = {
                Text(text = "Jetpack Compose Demo", color = Color.White)
            }, colors = TopAppBarDefaults.topAppBarColors(containerColor = MaterialTheme.colorScheme.primary),
            navigationIcon = {
                IconButton(onClick = {

                    scope.launch {
                        Toast.makeText(context,"This is menu",Toast.LENGTH_SHORT).show()
                    }

                }) {
                    Icon(Icons.Default.Menu,contentDescription = "menu",tint = Color.White)
                }
            }
        )
    }){
            paddingValues ->
        Column(modifier = Modifier.fillMaxSize().padding(paddingValues).padding(16.dp))
        {

            FlowRow(modifier = Modifier.fillMaxWidth(),
                horizontalArrangement = Arrangement.spacedBy(8.dp)){
                Card {
                    Button(onClick = {
                        onSelected = "Layout Demo"

                    }) {
                        Text(text = "Layout Demo", textAlign = TextAlign.Center)
                    }
                }


                Card {
                    Button(onClick = {
                        onSelected = "ROOM"

                    }) {
                        Text(text = "Login/Register(ROOM)", textAlign = TextAlign.Center)
                    }
                }


                Card {
                    Button(onClick = {
                        onSelected ="Mongo"

                    }) {
                        Text(text = "Login/Register(Retrofit/MongoDB)", textAlign = TextAlign.Center)
                    }
                }


            }

            //Switch Condition
            when(onSelected){
                "Layout Demo"->{
                    val intent = Intent(context,LayoutDemoActivity::class.java)
                    context.startActivity(intent)
                }
            }

        }
    }

}

@Preview(showBackground = true)
@Composable
fun MainDemoPreview() {

    MainDemo()

}