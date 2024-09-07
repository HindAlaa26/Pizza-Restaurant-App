package com.example.myapplication

import Home
import android.annotation.SuppressLint
import androidx.compose.foundation.Image
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.rememberScrollState
import androidx.compose.foundation.verticalScroll
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Add
import androidx.compose.material.icons.filled.ExitToApp
import androidx.compose.material.icons.filled.Home
import androidx.compose.material.icons.filled.Menu
import androidx.compose.material.icons.filled.Person
import androidx.compose.material.icons.filled.Search
import androidx.compose.material.icons.outlined.Home
import androidx.compose.material.icons.outlined.Person
import androidx.compose.material.icons.outlined.Search
import androidx.compose.material3.BottomAppBar
import androidx.compose.material3.DrawerValue
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.FabPosition
import androidx.compose.material3.FloatingActionButton
import androidx.compose.material3.Icon
import androidx.compose.material3.IconButton
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.ModalDrawerSheet
import androidx.compose.material3.ModalNavigationDrawer
import androidx.compose.material3.NavigationBar
import androidx.compose.material3.NavigationBarItem
import androidx.compose.material3.NavigationDrawerItem
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Text
import androidx.compose.material3.TopAppBar
import androidx.compose.material3.TopAppBarDefaults
import androidx.compose.material3.rememberDrawerState
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.rememberCoroutineScope
import androidx.compose.runtime.setValue
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.graphics.vector.ImageVector
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.navigation.NavController
import androidx.navigation.compose.rememberNavController
import com.example.myapplication.ui.theme.MyApplicationTheme
import kotlinx.coroutines.launch

@SuppressLint("UnusedMaterial3ScaffoldPaddingParameter")
@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun HomeScreen(navController: NavController= rememberNavController())
{
    data class bottomItem (var title:String,var selectedIcon: ImageVector,var unselectedIcon: ImageVector,
    )
    val bottomItems = arrayListOf(
        bottomItem("Home", Icons.Filled.Home, Icons.Outlined.Home),
        bottomItem("Profile", Icons.Filled.Person, Icons.Outlined.Person),
        bottomItem("search", Icons.Filled.Search, Icons.Outlined.Search),

    )
    var selectedIndex by remember { mutableStateOf(0) }
    data class drawerItem (var title:String,var icon: ImageVector,var value: String,
    )
    val drawerItems = arrayListOf(
        drawerItem("Home", Icons.Filled.Home, "home screen"),
        drawerItem("Profile", Icons.Filled.Person, "profile screen"),
        drawerItem("search", Icons.Filled.Search, "search screen"),

    )

    val drawerState = rememberDrawerState(DrawerValue.Closed )
    val selecteddrawerIndex by remember { mutableStateOf(0) }
    val scope = rememberCoroutineScope()
    ModalNavigationDrawer(
        drawerState = drawerState,
        drawerContent = {
ModalDrawerSheet {
    drawerItems.forEachIndexed { index, item -> NavigationDrawerItem(
        icon = { Icon(imageVector = item.icon, contentDescription =null )},
        label = { Text(text = item.title)},
        selected = index == selecteddrawerIndex,
        onClick = {
            selectedIndex = index
            scope.launch { drawerState.close() }
        }
    ) }
}
        }) {
        Scaffold(
            topBar = {
                TopAppBar(
                    colors = TopAppBarDefaults.largeTopAppBarColors(
                        containerColor = Color(0xFF0D47A1),
                        titleContentColor = Color.White,
                        navigationIconContentColor = Color.White,
                    ),
                    navigationIcon = {
                        IconButton(onClick = {
                            scope.launch {
                                drawerState.open()
                            }
                        }) {
                            Icon(Icons.Filled.Menu,contentDescription = null)
                        }
                    },
                    title = {
                        Text("Pizza Restaurant")
                    }
                )
            },
            bottomBar = {
                BottomAppBar(
                    containerColor = MaterialTheme.colorScheme.primaryContainer,
                    contentColor = Color.White,
                    tonalElevation = 4.dp,
                    actions = {   bottomItems.forEachIndexed { index, bottomItem ->
                        NavigationBarItem(selected = selectedIndex == index,
                            label = {
                                Text(bottomItem.title, fontSize = 16.sp)
                            },
                            onClick = { selectedIndex = index},
                            icon = {
                                Icon(if (selectedIndex == index) {bottomItem.selectedIcon}else bottomItem.unselectedIcon ,
                                    contentDescription = null)
                            }
                        )
                    }}
                )
            },
            floatingActionButton = {
                FloatingActionButton(
                    onClick = { /* Handle FAB click */ },
                    containerColor = MaterialTheme.colorScheme.primary,
                    contentColor = Color.White
                ) {
                    Icon(Icons.Filled.Add, contentDescription = "Add")
                }
            },
            floatingActionButtonPosition = FabPosition.End,
        ) {
            Column(
                modifier = Modifier
                    .padding(top = 250.dp)


            ) {
                when(selectedIndex)
                {
                    0->  Home()
                    1-> Profile()
                    2-> Search()
                    else -> Home()
                }
            }
        }
    }


}

@Preview(showBackground = true)
@Composable
fun HomePreview() {
    MyApplicationTheme {
        HomeScreen()
    }
}