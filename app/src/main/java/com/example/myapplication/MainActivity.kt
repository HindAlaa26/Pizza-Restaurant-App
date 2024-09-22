package com.example.myapplication

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.activity.viewModels
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.items
import androidx.compose.material3.Card
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Surface
import androidx.compose.material3.Text
import androidx.compose.runtime.*
import androidx.compose.ui.Modifier
import androidx.compose.ui.tooling.preview.Preview
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import androidx.navigation.compose.rememberNavController
import com.example.myapplication.ui.theme.MyApplicationTheme
import com.google.firebase.FirebaseApp
import com.google.firebase.auth.FirebaseAuth
import com.google.firebase.ktx.Firebase
import com.google.firebase.auth.ktx.auth

class MainActivity : ComponentActivity() {

    private lateinit var auth: FirebaseAuth

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        // Initialize Firebase Auth
        FirebaseApp.initializeApp(this)
        auth = Firebase.auth
        val vModel = MainApi()
        vModel.getAllNews()
        setContent {
            var news = vModel.newsResponse.collectAsState()
            MyApplicationTheme {
                Surface(
                    modifier = Modifier.fillMaxSize(),
                    color = MaterialTheme.colorScheme.background
                ) {
//                     val authViewModel: AuthViewModel by viewModels()
                   // MyApp(authViewModel = authViewModel)
                    Column(
                        modifier = Modifier.fillMaxSize()
                    ) {
                            Text("News Api")
                        LazyColumn{
                            items(news.value?.articles?: emptyList()){
                                    article -> Card() {
                                Text(text = article.title ?: "")
                            }
                            }
                        }

                    }
                }
            }
        }
    }
}


@Composable
fun MyApp() {
        val navController = rememberNavController()
    NavHost(navController = navController, startDestination = "welcomeScreen") {
        composable("welcomeScreen") {
            welcomeScreen(navController = navController)
        }
        composable("loginScreen") {
            Login(
                navController = navController
            )
        }
        composable("registerScreen") {
            Register(navController = navController)
        }
        composable("homeScreen") {
            HomeScreen(navController = navController)
        }
        composable("search") {
            Search(navController = navController)
        }
        composable("profile") {
            Profile(navController = navController)
        }
    }
}
// @Composable
//fun MyApp(authViewModel: AuthViewModel) {
//    val navController = rememberNavController()
//    val authState by authViewModel.authState.collectAsState()
//    val auth = FirebaseAuth.getInstance()
//    val currentUser = auth.currentUser
//
//    NavHost(navController = navController, startDestination = "welcomeScreen") {
//        composable("welcomeScreen") {
//            welcomeScreen(navController = navController)
//        }
//        composable("loginScreen") {
//            Login(
//                onLogin = { email, password -> authViewModel.login(email, password) },
//                navController = navController
//            )
//        }
//        composable("registerScreen") {
//            Register(navController = navController)
//        }
//        composable("homeScreen") {
//            HomeScreen(navController = navController)
//        }
//        composable("search") {
//            Search(navController = navController)
//        }
//        composable("profile") {
//            Profile(navController = navController)
//        }
//    }
//
//    // Navigate based on authentication state
//    LaunchedEffect(authState, currentUser) {
//        if (currentUser != null) {
//            navController.navigate("homeScreen") {
//                popUpTo("loginScreen") { inclusive = true }
//            }
//        } else {
//            // Handle other auth states
//            when (authState) {
//                is AuthState.LoggedIn -> {
//                    navController.navigate("homeScreen") {
//                        popUpTo("loginScreen") { inclusive = true }
//                    }
//                }
//                is AuthState.ErrorLoggedIn -> {
//                    // Show an error message or handle login error state
//                }
//                else -> {
//                    navController.navigate("loginScreen")
//                }
//            }
//        }
//    }
//
//}

@Preview(showBackground = true)
@Composable
fun DefaultPreview() {
//    val authViewModel = AuthViewModel()
//    MyApp(authViewModel = authViewModel)
  MyApp()
}
