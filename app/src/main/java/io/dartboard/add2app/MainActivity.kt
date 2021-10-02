package io.dartboard.add2app

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.foundation.layout.Column
import androidx.compose.material.Button
import androidx.compose.material.MaterialTheme
import androidx.compose.material.Surface
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.tooling.preview.Preview
import io.dartboard.add2app.ui.theme.Add2AppTheme
//import io.dartboard.dart_board_core_plugin.DartBoardNav
class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            Add2AppTheme {
                Column() {
                    RouteButton("/minesweep")
                    RouteButton("/launches")
                }
            }
        }
    }
}

@Composable
fun RouteButton(route: String) {
    val context = LocalContext.current
    Button(onClick = {
        //DartBoardNav.launchRoute(route)
    }) {
        Text(text = "$route")
    }
}

@Preview(showBackground = true)
@Composable
fun DefaultPreview() {
    Add2AppTheme {
        Column() {
            RouteButton("/minesweep")
            RouteButton("/launches")
        }
    }
}