package com.example.myapplication
import androidx.compose.foundation.Image
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.material3.Button
import androidx.compose.material3.ButtonDefaults
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.example.myapplication.ui.theme.MyApplicationTheme

@Composable
fun welcomeScreen(){
 LazyColumn(
     modifier = Modifier.fillMaxSize() ,
     horizontalAlignment = Alignment.CenterHorizontally,
    verticalArrangement = Arrangement.Center
 )
 {
     item {
         Text(text = "pizza Restaurant", color = androidx.compose.ui.graphics.Color.DarkGray, fontSize = 25.sp, modifier = Modifier.padding(22.dp))
     }
   item {
       Image(painter = painterResource(id = R.drawable.logo), contentDescription = "Piza Logo" , modifier = Modifier
           .fillMaxWidth()
           .padding(10.dp))
   }
     item {
       Text(text = "pizza is always the answer")
     }
     item {
Button(onClick = { }, modifier = Modifier.padding(29.dp),colors = ButtonDefaults.buttonColors(containerColor = androidx.compose.ui.graphics.Color.Black)) {
    Text(text = "Let's Start")
}
     }

 }
}
@Preview(showBackground = true)
@Composable
fun WelcomePreview() {
    MyApplicationTheme {
        welcomeScreen()
    }
}