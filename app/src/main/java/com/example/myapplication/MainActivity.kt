package com.example.myapplication
import Home
import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Surface
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.tooling.preview.Preview
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import androidx.navigation.compose.rememberNavController
import com.example.myapplication.ui.theme.MyApplicationTheme

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            MyApplicationTheme {
                // A surface container using the 'background' color from the theme
                Surface(
                    modifier = Modifier.fillMaxSize(),
                    color = MaterialTheme.colorScheme.background
                ) {
                    myApp()
                }
            }
        }
    }
}
@Composable
fun myApp(){
    val navController = rememberNavController()
    NavHost(navController = navController, startDestination =  "welcomeScreen")
    {
        composable("welcomeScreen")
        {
            welcomeScreen(navController= navController)
        }
        composable("loginScreen")
        {
            Login(navController= navController)
        }
        composable("registerScreen")
        {
            Register(navController= navController)
        }
        composable("Home")
        {
            Home(navController= navController)
        }
        composable("search")
        {
            Search(navController= navController)
        }
        composable("profile")
        {
            Profile(navController= navController)
        }
        composable("homeScreen")


        { HomeScreen(navController = navController) }
    }
}

@Preview(showBackground = true)
@Composable
fun DefaultPreview() {
    myApp()
}

