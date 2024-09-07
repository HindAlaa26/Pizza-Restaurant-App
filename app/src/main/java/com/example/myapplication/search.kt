package com.example.myapplication

import androidx.compose.foundation.Image
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.navigation.NavController
import androidx.navigation.compose.rememberNavController

@Composable
fun Search(navController: NavController = rememberNavController())
{
    Column(
//        modifier = Modifier
//            .fillMaxSize().padding(top = 50.dp),
        verticalArrangement = Arrangement.spacedBy( 120.dp),
        horizontalAlignment = Alignment.CenterHorizontally

    ) {
        Text(
            text = "Search",
            color = Color.Gray,
            fontSize = 25.sp,
            modifier = Modifier.padding(bottom = 8.dp)
        )
    }

}

@Preview
@Composable
fun SearchPreview() {
    Search()
}