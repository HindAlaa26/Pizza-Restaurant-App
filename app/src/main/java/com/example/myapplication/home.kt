import androidx.compose.foundation.Image
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.rememberScrollState
import androidx.compose.foundation.verticalScroll
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
import com.example.myapplication.R

@Composable
fun Home(navController: NavController = rememberNavController())
{
    Column(
//        modifier = Modifier
//            .fillMaxSize().padding(top = 50.dp),
        verticalArrangement = Arrangement.spacedBy(20.dp),
        horizontalAlignment = Alignment.CenterHorizontally

    ) {
        Image(modifier = Modifier
            .fillMaxWidth()
            .padding(bottom = 20.dp),painter = painterResource(id = R.drawable.logo), contentDescription = "logo")
        Text(
            text = "Welcome to Pizza Restaurant",
            color = Color.Gray,
            fontSize = 25.sp,
            modifier = Modifier.padding(bottom = 8.dp)
        )
    }
}

@Preview
@Composable
fun HomePreview()
{
    Home()
}