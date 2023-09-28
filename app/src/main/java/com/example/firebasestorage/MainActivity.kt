package com.example.firebasestorage

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.ui.platform.LocalContext
import androidx.navigation.compose.rememberNavController
import com.example.firebasestorage.data.AuthViewModel
import com.example.firebasestorage.navigation.AppNavHost
import com.google.firebase.FirebaseApp

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        FirebaseApp.initializeApp(this)

        setContent {
            var context = LocalContext.current
            var authViewModel = AuthViewModel(rememberNavController(),context)
AppNavHost(viewModel = authViewModel)


        }
    }
}
