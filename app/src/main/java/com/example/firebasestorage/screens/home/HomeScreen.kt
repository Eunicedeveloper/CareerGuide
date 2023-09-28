package com.example.firebasestorage.screens.home

import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.height
import androidx.compose.material.Button
import androidx.compose.material.Icon
import androidx.compose.material.IconButton
import androidx.compose.material.Text
import androidx.compose.material.TopAppBar
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.ArrowBack
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.paint
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.navigation.NavHostController
import androidx.navigation.compose.rememberNavController



import com.example.firebasestorage.R
import com.example.firebasestorage.data.AuthViewModel
import com.example.firebasestorage.navigation.ROUT_EXPLORE
import com.example.firebasestorage.navigation.ROUT_LOGIN
import com.example.firebasestorage.navigation.ROUT_UPLOAD

@Composable
fun HomeScreen(viewModel: AuthViewModel?, navController: NavHostController) {
    val mContext= LocalContext.current
    Column(modifier = Modifier
        .fillMaxSize()
        .paint(painterResource(id = R.drawable.logo), contentScale = ContentScale.FillBounds)) {


        //TopAppBar
        TopAppBar(title = { Text(text = "WELCOME TO All IN ONE")
                          },
            navigationIcon = {
                IconButton(onClick = {
                    navController.navigate(ROUT_LOGIN)
                }) {
                    Icon(imageVector = Icons.Filled.ArrowBack , contentDescription = "arrowback")
                }
            },

            backgroundColor = Color.Cyan)
        Spacer(modifier = Modifier.height(20.dp))

        Button(onClick = {
            navController.navigate(ROUT_EXPLORE)
        }) {
            Text(text = "Explore Products & Services")
        }


        Spacer(modifier = Modifier.height(20.dp))

        Button(onClick = {
            navController.navigate(ROUT_UPLOAD)

        }) {
            Text(text = "Upload Product/Services")
        }



    }


}

@Preview(showBackground = true)
@Composable
fun HomeScreenPreview() {
        HomeScreen(null, rememberNavController())

}

