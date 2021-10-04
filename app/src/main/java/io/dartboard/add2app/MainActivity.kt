package io.dartboard.add2app

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.material.Button
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import io.dartboard.add2app.ui.theme.Add2AppTheme
import io.dartboard.dart_board_core_plugin.DartBoardCorePlugin
import io.dartboard.dart_board_spacex_plugin.Api
import io.dartboard.dart_board_spacex_plugin.DartBoardSpacexPlugin


//import io.dartboard.dart_board_core_plugin.DartBoardNav
class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            MainScreen(launches = listOf())
        }
    }

    override fun onResume() {
        super.onResume()
        DartBoardSpacexPlugin.getApi().getLaunches {
            setContent {
                MainScreen(launches = it)
            }
        }
    }
}

@Composable
fun RouteButton(route: String) {
    val context = LocalContext.current
    Button(modifier = Modifier.padding(4.dp),
        onClick = {
        DartBoardCorePlugin.launchScreen(context, route)
    }) {
        Text(text = "$route")
    }
}

@Preview(showBackground = true)
@Composable
fun MainScreen(launches: List<Api.LaunchDataNative> = listOf()) {
    Add2AppTheme {
        LazyColumn (Modifier.fillMaxSize()) {
            item {
                Text(text = "Launch Flutter Screens")
            }
            item {
                Row (horizontalArrangement = Arrangement.SpaceEvenly, modifier = Modifier.fillMaxSize()){
                    RouteButton("/minesweep")
                    RouteButton("/launches")
                }
            }
            item {
                Text(text = "Data Fetched From Flutter")
            }
            items(launches.size) {
                RouteButton("/launches/${launches[it].missionName}")
            }


        }
    }
}