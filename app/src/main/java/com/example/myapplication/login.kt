package com.example.myapplication

import android.util.Log
import androidx.compose.foundation.Image
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.text.KeyboardOptions
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Check
import androidx.compose.material.icons.filled.Clear
import androidx.compose.material.icons.filled.Email
import androidx.compose.material.icons.filled.Lock
import androidx.compose.material3.AlertDialog
import androidx.compose.material3.Button
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.Icon
import androidx.compose.material3.IconButton
import androidx.compose.material3.Text
import androidx.compose.material3.TextButton
import androidx.compose.material3.TextField
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.input.KeyboardType
import androidx.compose.ui.text.input.PasswordVisualTransformation
import androidx.compose.ui.text.input.VisualTransformation
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.navigation.NavController
import androidx.navigation.compose.rememberNavController
import com.example.myapplication.ui.theme.MyApplicationTheme
import com.google.firebase.auth.FirebaseAuth
import com.google.firebase.auth.FirebaseAuthException
import kotlin.math.log

@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun Login(navController: NavController= rememberNavController()) {
    var email by remember { mutableStateOf("") }
    var password by remember { mutableStateOf("") }
    var isVisible by remember { mutableStateOf(value = false) }
    var setTransformation =
        if (isVisible) PasswordVisualTransformation() else VisualTransformation.None
    var showMessage by remember { mutableStateOf(false)}
    Column(
        modifier = Modifier
            .fillMaxSize()
            .padding(20.dp),
        verticalArrangement = Arrangement.Center,
        horizontalAlignment = Alignment.CenterHorizontally
    ) {
       if (showMessage) {

            AlertDialog(
                title = { Text(text = "Error") },
                text = { Text(text = "user not found or password is wrong")},
                onDismissRequest = {showMessage = false},
                confirmButton = {
                    Button(onClick = { Log.e("error","user not found")
                    showMessage = false
                    }) {
                        Text(text = "Confirm")
                    }
                }
            )
       }
        Image(
            painter = painterResource(id = R.drawable.show),
            contentDescription = "Show Image",
            modifier = Modifier.fillMaxWidth()
        )
        Text(
            text = "Welcome back again",
            color = Color.DarkGray,
            modifier = Modifier.padding(8.dp)
        )

            Text(
                text = "use form below to login",
                color = Color.Black,
                modifier = Modifier.padding(8.dp)
            )

            TextField(
                isError = email.isEmpty(),
                value = email,
                keyboardOptions = KeyboardOptions(
                    keyboardType = KeyboardType.Email
                ),
                leadingIcon = {
                    Icon(Icons.Filled.Email, contentDescription = "Email")
                },
                trailingIcon = {
                    IconButton(onClick = { email = "" }) {
                        Icon(Icons.Filled.Clear, contentDescription = "clear")
                    }
                },
                onValueChange = { email = it },
                label = { Text("Email") },
                modifier = Modifier
                    .fillMaxWidth()
                    .padding(8.dp)
            )

            TextField(
                isError = password.isEmpty(),
                value = password,
                onValueChange = { password = it },
                label = { Text("Password") },
                keyboardOptions = KeyboardOptions(
                    keyboardType = KeyboardType.Password
                ),
                leadingIcon = {
                    Icon(Icons.Filled.Lock, contentDescription = "Password")
                },
                trailingIcon = {
                    IconButton(onClick = {
                        isVisible = !isVisible
                    }) {
                        val icon = if (isVisible) Icons.Filled.Lock else Icons.Filled.Clear
                        Icon(icon, contentDescription = if (isVisible) "Hide password" else "Show password")
                    }

                },
                visualTransformation = setTransformation,
                modifier = Modifier
                    .fillMaxWidth()
                    .padding(8.dp)
            )

            Row(horizontalArrangement = Arrangement.End, modifier = Modifier.fillMaxWidth()) {

                TextButton(onClick = { }) {
                    Text(text = "Forget Password", color = Color.Gray, textAlign = TextAlign.End)

                }
            }

        Button(
            onClick = {
        if (email.isNotEmpty() && password.isNotEmpty()) {
            try {
                FirebaseAuth.getInstance().signInWithEmailAndPassword(email, password)
                    .addOnCompleteListener { task ->
                        if (task.isSuccessful) {
                            println("login success")
                        } else {
                            println("login failure")
                        }
                    }
            } catch (e: FirebaseAuthException) {
                Log.e("login", "$e")
            }
        }
            }
        ) {
            Text(text = "Login", textAlign = TextAlign.Center)
        }


        Row(
                horizontalArrangement = Arrangement.Center,
                modifier = Modifier.fillMaxWidth(),
                verticalAlignment = Alignment.CenterVertically
            ) {
                Text(text = "Don't have account?")
                TextButton(onClick = { navController.navigate("registerScreen") }) {
                    Text(text = "Register Now", color = Color.Blue, textAlign = TextAlign.End)

                               }
            }

    }
}

@Preview(showBackground = true)
@Composable
fun LoginPreview() {
    MyApplicationTheme {
        Login()
    }
}