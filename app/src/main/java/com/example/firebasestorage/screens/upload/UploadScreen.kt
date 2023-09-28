package com.example.firebasestorage.screens.upload


import android.annotation.SuppressLint
import android.content.Context
import android.text.TextUtils
import android.widget.Toast
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.*
import androidx.compose.material.*
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.ArrowBack
import androidx.compose.material3.Button
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.Text
import androidx.compose.material3.TextField
import androidx.compose.runtime.Composable
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.paint
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.TextStyle
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.navigation.NavController
import androidx.navigation.compose.rememberNavController
import com.example.firebasestorage.R
import com.example.firebasestorage.Upload
import com.example.firebasestorage.data.AuthViewModel
import com.example.firebasestorage.navigation.ROUT_LOGIN
import com.google.firebase.firestore.CollectionReference
import com.google.firebase.firestore.FirebaseFirestore


@SuppressLint("UnusedMaterial3ScaffoldPaddingParameter")
@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun UploadDataScreen(viewModel: AuthViewModel?, navController: NavController) {

    Column(
        modifier = Modifier
            .fillMaxSize()
            .paint(
                painterResource(id = R.drawable.bg_1),
                contentScale = ContentScale.FillBounds
            )
    ) {


        //TopAppBar
        TopAppBar(
            title = {
                androidx.compose.material.Text(text = "WELCOME TO All IN ONE")
            },
            navigationIcon = {
                IconButton(onClick = {
                    navController.navigate(ROUT_LOGIN)
                }) {
                    Icon(imageVector = Icons.Filled.ArrowBack, contentDescription = "arrowback")
                }
            },

            backgroundColor = Color.Cyan


        )

        firebaseUI(LocalContext.current)

    }


}



@SuppressLint("UnusedMaterial3ScaffoldPaddingParameter")
@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun firebaseUI(context: Context) {


    val IGhandle = remember {
        mutableStateOf("")
    }

    val Whatsappcontact = remember {

        mutableStateOf("")
    }

    val Description = remember {
        mutableStateOf("")
    }

    Column(

        modifier = Modifier
            .fillMaxHeight()
            .fillMaxWidth()
            .background(Color.White),
        verticalArrangement = Arrangement.Top, horizontalAlignment = Alignment.CenterHorizontally
    ) {



            TextField(

                value = IGhandle.value,
                onValueChange = { IGhandle.value = it },
                placeholder = { Text(text = "Enter business IGhandle") },
                modifier = Modifier
                    .padding(10.dp)
                    .fillMaxWidth(),
                textStyle = TextStyle(color = Color.Black, fontSize = 15.sp),
                singleLine = true,
            )

            Spacer(modifier = Modifier.height(10.dp))

            TextField(
                value = Whatsappcontact.value,
                onValueChange = { Whatsappcontact.value = it },
                placeholder = { Text(text = "Enter business whatsappcontact") },
                modifier = Modifier
                    .padding(10.dp)
                    .fillMaxWidth(),
                textStyle = TextStyle(color = Color.Black, fontSize = 15.sp),
                singleLine = true,
            )

            Spacer(modifier = Modifier.height(10.dp))

            TextField(
                value = Description.value,
                onValueChange = { Description.value = it },
                placeholder = { Text(text = "type business/product descripton") },
                modifier = Modifier
                    .padding(10.dp)
                    .fillMaxWidth(),
                textStyle = TextStyle(color = Color.Black, fontSize = 15.sp),
                singleLine = true,
            )

            Spacer(modifier = Modifier.height(10.dp))

            // on below line creating button to
            // add data to firebase firestore database.
            Button(

                onClick = {
                    // on below line we are validating user input parameters.
                    if (TextUtils.isEmpty(IGhandle.value.toString())) {
                        Toast.makeText(context, "Enter business IGhandle", Toast.LENGTH_SHORT)
                            .show()
                    } else if (TextUtils.isEmpty(Whatsappcontact.value.toString())) {
                        Toast.makeText(
                            context,
                            "Enter business whatsappcontact",
                            Toast.LENGTH_SHORT
                        )
                            .show()
                    } else if (TextUtils.isEmpty(Description.value.toString())) {
                        Toast.makeText(
                            context,
                            "type business/product descripton",
                            Toast.LENGTH_SHORT
                        )
                            .show()
                    } else {
                        // on below line adding data to
                        // firebase firestore database.
                        addDataToFirebase(
                            IGhandle.value,
                            Whatsappcontact.value,
                            Description.value, context
                        )
                    }
                },

                // on below line we are
                // adding modifier to our button.
                modifier = Modifier
                    .fillMaxWidth()
                    .padding(10.dp),


            ) {

                // on below line we are adding text for our button
                Text(text = "Upload product",Modifier.padding(start = 10.dp))
            }


        }
    }


fun addDataToFirebase(
    IGhandle: String,
    Whatsappcontact: String,
    Description: String,
    context: Context
) {
    // on below line creating an instance of firebase firestore.
    val db: FirebaseFirestore = FirebaseFirestore.getInstance()
    //creating a collection reference for our Firebase Firestore database.
    val dbCourses: CollectionReference = db.collection("Courses")
    //adding our data to our courses object class.
    val courses = Upload(IGhandle, Whatsappcontact, Description)

    //below method is use to add data to Firebase Firestore.
    dbCourses.add(courses).addOnSuccessListener {
        // after the data addition is successful
        // we are displaying a success toast message.
        Toast.makeText(
            context,
            "Your product has been added successfully",
            Toast.LENGTH_SHORT
        ).show()

    }.addOnFailureListener { e ->
        // this method is called when the data addition process is failed.
        // displaying a toast message when data addition is failed.
        Toast.makeText(context, "Fail to add product \n$e", Toast.LENGTH_SHORT).show()
    }

}


@Preview(showBackground = true)
@Composable
fun UploadDataScreenPreview() {




    UploadDataScreen(null, rememberNavController())
}


