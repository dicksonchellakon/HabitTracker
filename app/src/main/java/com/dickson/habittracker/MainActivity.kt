package com.dickson.habittracker

import android.graphics.drawable.Icon
import android.media.Image
import android.os.Bundle
import android.widget.Toast
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.foundation.background
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.itemsIndexed
import androidx.compose.foundation.shape.CornerSize
import androidx.compose.material.*
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.*
import androidx.compose.runtime.Composable
import androidx.compose.runtime.collectAsState
import androidx.compose.runtime.getValue
import androidx.compose.runtime.rememberCoroutineScope
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.lifecycle.viewmodel.compose.viewModel
import com.dickson.habittracker.ui.theme.HabitTrackerTheme
import kotlinx.coroutines.launch

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            HomeScreen()
        }
    }
}

@Preview(showBackground = true)
@Composable
fun DefaultPreview() {
    HomeScreen()
}

@Composable
fun HomeScreen() {
    MaterialTheme {
        val ctx = LocalContext.current
        val viewModel = viewModel<HabitViewModel>()

        //val flowColor by viewModel.color.collectAsState()

        val scaffoldState = rememberScaffoldState()
        val scope = rememberCoroutineScope()
        Scaffold(
            scaffoldState = scaffoldState,
            drawerContent = {
                DrawerHeader()
                DrawerBody(items = listOf(
                    MenuItem("home", "Home", "Home", Icons.Default.Home),
                    MenuItem("habits", "Habits", "Habits", Icons.Default.Call),
                    MenuItem("addHabits", "Add Habits", "AddHabits", Icons.Default.Create),
                    MenuItem("home", "Home", "Home", Icons.Default.Home),
                    MenuItem("home", "Home", "Home", Icons.Default.Home)
                ), onItemClick = {
                    /*when(it.id){
                        "home" -> navigateToHomeScreen
                    }*/
                    println("Clicked on ${it.title}")
                })
            },
            //drawerGesturesEnabled = false,
            topBar = {
                     AppTopBar(
                         onNavigationIconClick = {
                             scope.launch { scaffoldState.drawerState.open() }
                         }
                     )
            },
            floatingActionButton = {
                /*FloatingActionButton(onClick = { /* ... */ }) {
                    /* FAB content */
                }*/
                ExtendedFloatingActionButton(
                    text = {
                        Text("+")
                    },
                    onClick = {
                        scope.launch {
                            scaffoldState.snackbarHostState
                                .showSnackbar(
                                    "Show SnackBar",
                                    actionLabel = "Retry",
                                    duration = SnackbarDuration.Indefinite
                                )
                        }
                    }
                )
            },
            floatingActionButtonPosition = FabPosition.End,
            isFloatingActionButtonDocked = true,
            bottomBar = {
                BottomNavigation(
                    elevation = 12.dp
                ) {
                    BottomNavigationItem(
                        selected = false,
                        onClick = { /*TODO*/ },
                        icon = { androidx.compose.material.Icon(
                            imageVector = Icons.Default.Home,
                            contentDescription = "Home"
                        ) }
                    )
                    BottomNavigationItem(
                        selected = false,
                        onClick = { /*TODO*/ },
                        icon = { androidx.compose.material.Icon(
                            imageVector = Icons.Default.Settings,
                            contentDescription = "Settings"
                        ) }
                    )
                    BottomNavigationItem(
                        selected = false,
                        onClick = { /*TODO*/ },
                        icon = { androidx.compose.material.Icon(
                            imageVector = Icons.Default.List,
                            contentDescription = "Listings"
                        ) }
                    )
                }
                /*BottomAppBar (
                    cutoutShape = MaterialTheme.shapes.small.copy(
                        CornerSize(percent = 50)
                    )
                ) { /* Bottom app bar content */ }*/
            }
        ) {
            it.calculateBottomPadding()
            /*Row(verticalAlignment = Alignment.CenterVertically) {
                //Image(sd)
                Column {
                    Text("Dickson")
                    Text("Active")
                }
            }

            Box(
                modifier = Modifier
                    .fillMaxSize()
                    .background(Color(flowColor))
                    .clickable {
                        viewModel.generateColor()
                    }
            )*/
            LazyColumn {
                itemsIndexed(
                    listOf("Tennis", "Cricket", "Running",)
                ) { _, string ->
                    //Text(text = string)
                    GreetingView(name = string) {
                        Toast.makeText(ctx, it, Toast.LENGTH_LONG).show()
                    }
                }
            }

        }

    }
}

@Composable
private fun GreetingView(name: String, onClick: (msg: String) -> Unit) {
    val msg = "Hello, $name"

    Card(
        backgroundColor = MaterialTheme.colors.primary,
        modifier = Modifier
            .padding(vertical = 4.dp, horizontal = 8.dp)
            .clickable { onClick(msg) }
    ) {
        Row(modifier = Modifier
            .padding(12.dp)
            .fillMaxWidth()) {
            Text(text = msg)
        }
    }
}