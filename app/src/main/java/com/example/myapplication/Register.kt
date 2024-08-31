package com.example.myapplication

import androidx.compose.foundation.Image
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.material3.Button
import androidx.compose.material3.Checkbox
import androidx.compose.material3.ExperimentalMaterial3Api
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
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.navigation.NavController

@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun Register(navController: NavController) {
    var email by remember { mutableStateOf("") }
    var password by remember { mutableStateOf("") }
    var confirmPassword by remember { mutableStateOf("") }
    var isCheck:Boolean = false
    LazyColumn (
        modifier = Modifier.fillMaxSize().padding(top = 30.dp, start = 10.dp, end = 10.dp, bottom = 5.dp),
        verticalArrangement = Arrangement.spacedBy(18.dp),
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
            Text(text = "Welcome", color = Color.Black, modifier = Modifier.padding(8.dp), fontSize = 22.sp)
        }
        item {
            Text(text = "use form below to register", color = Color.DarkGray, modifier = Modifier.padding(8.dp))
        }
        item {
            TextField(
                isError = email.isEmpty(),
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
                isError = password.isEmpty(),
                value = password,
                onValueChange = { password = it },
                label = { Text("Password") },
                visualTransformation = PasswordVisualTransformation(),
                modifier = Modifier
                    .fillMaxWidth()
                    .padding(8.dp)
            )        }
        item {
            TextField(
                isError = confirmPassword.isEmpty(),
                value = confirmPassword,
                onValueChange = { confirmPassword = it },
                label = { Text("Confirm Password") },
                visualTransformation = PasswordVisualTransformation(),
                modifier = Modifier
                    .fillMaxWidth()
                    .padding(8.dp)
            )
        }
        item {
            Row(
                modifier= Modifier.fillMaxWidth(),
                verticalAlignment = Alignment.CenterVertically,
               horizontalArrangement = Arrangement.Start
            ) {
              Checkbox(checked = isCheck , onCheckedChange = { isChecked ->
                  isCheck = isChecked
              })
                Text(text = "Accept terms and conditions")
            }
        }
        item {
            Button(
                onClick = { },
            ) {
                Text(text = "Register " )
            }
        }
        item {
            Row(
                horizontalArrangement= Arrangement.Center,
                modifier = Modifier.fillMaxWidth(),
                verticalAlignment = Alignment.CenterVertically
            ) {
                Text(text = "have an account?")
                TextButton(onClick = {  navController.navigate("loginScreen")}) {
                    Text(text = "Login", color = Color.Blue, textAlign = TextAlign.End)

                }
            }
        }
    }
}


//@Preview(showBackground = true)
//@Composable
//fun RegisterPreview() {
//    MyApplicationTheme {
//        Register()
//    }
//}