package com.example.firebasestorage.navigation

import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.navigation.NavHostController
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import androidx.navigation.compose.rememberNavController
import com.example.firebasestorage.data.AuthViewModel
import com.example.firebasestorage.screens.Explore.ExploreScreen
import com.example.firebasestorage.screens.home.HomeScreen
import com.example.firebasestorage.screens.login.LoginScreen
import com.example.firebasestorage.screens.signup.SignupScreen
import com.example.firebasestorage.screens.upload.UploadDataScreen


@Composable
fun AppNavHost(
    viewModel: AuthViewModel,
    modifier: Modifier = Modifier,
    navController: NavHostController = rememberNavController(),
    startDestination: String = ROUT_LOGIN
) {
    NavHost(
        modifier = modifier,
        navController = navController,
        startDestination = startDestination
    ) {
        composable(ROUT_LOGIN) {
            LoginScreen(viewModel, navController)
        }
        composable(ROUT_SIGNUP) {
            SignupScreen(viewModel, navController)
        }
        composable(ROUT_HOME) {
            HomeScreen(viewModel, navController)
        }

        composable(ROUT_UPLOAD) {
            UploadDataScreen(viewModel, navController)
        }

        composable(ROUT_EXPLORE) {
            ExploreScreen(viewModel, navController)
        }




    }
}



