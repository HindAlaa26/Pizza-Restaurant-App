package com.example.myapplication

import androidx.compose.foundation.Image
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.material3.Button
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.OutlinedTextField
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
import androidx.compose.ui.text.input.PasswordVisualTransformation
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import com.example.myapplication.ui.theme.MyApplicationTheme

@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun Login() {
    var email by remember { mutableStateOf("") }
    var password by remember { mutableStateOf("") }

    LazyColumn (
        modifier = Modifier
            .fillMaxSize()
            .padding(20.dp),
        verticalArrangement = Arrangement.Center,
        horizontalAlignment = Alignment.CenterHorizontally
    ){

        item {
            Image(
                painter = painterResource(id = R.drawable.show),
                contentDescription = "Show Image" ,
                modifier = Modifier.fillMaxWidth()
            )
        }
        item {
            Text(text = "Welcome back again", color = Color.DarkGray, modifier = Modifier.padding(8.dp))
        }
        item {
            Text(text = "use form below to login", color = Color.Black, modifier = Modifier.padding(8.dp))
        }
        item {
            TextField(
                value = email,
                onValueChange = { email = it },
                label = { Text("Email") },
                modifier = Modifier
                    .fillMaxWidth()
                    .padding(8.dp)
            )
        }
        item {
            TextField(
                value = password,
                onValueChange = { password = it },
                label = { Text("Password") },
                visualTransformation = PasswordVisualTransformation(),
                modifier = Modifier
                    .fillMaxWidth()
                    .padding(8.dp)
            )        }
     item {
         Row(horizontalArrangement= Arrangement.End, modifier = Modifier.fillMaxWidth()) {

             TextButton(onClick = { }) {
                 Text(text = "Forget Password", color = Color.Gray, textAlign = TextAlign.End)

             }
         }
     }

        item {
            Button(
                onClick = {},
            ) {
                Text(text = "Login", textAlign = TextAlign.Center)
            }
        }
        item {
            Row(
                horizontalArrangement= Arrangement.Center,
                modifier = Modifier.fillMaxWidth(),
                verticalAlignment = Alignment.CenterVertically
            ) {
                Text(text = "Don't have account?")
                TextButton(onClick = { }) {
                    Text(text = "Register Now", color = Color.Blue, textAlign = TextAlign.End)

                }
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