package com.maneeshwar.loginscreen

import android.content.Context
import android.content.Intent
import android.net.Uri
import androidx.compose.runtime.*
import android.widget.Toast
import androidx.compose.foundation.Image
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.layout.width
import androidx.compose.material3.Button
import androidx.compose.material3.OutlinedTextField
import androidx.compose.material3.Text
import androidx.compose.material3.TextButton
import androidx.compose.runtime.Composable
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.font.FontFamily
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.input.PasswordVisualTransformation
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.navigation.NavHostController
import com.maneeshwar.loginscreen.R.drawable.loginlo

@Composable
fun loginscreen(navController: NavHostController) {
    var username by remember { mutableStateOf("") }
    var password by remember { mutableStateOf("") }
    var name by remember { mutableStateOf("") }

    Column(
        modifier = Modifier.fillMaxSize(),
        verticalArrangement = Arrangement.Center,
        horizontalAlignment = Alignment.CenterHorizontally
    ) {
        Image(
            painter = painterResource(id = loginlo),
            contentDescription = "Login image",
            modifier = Modifier.size(200.dp)
        )
        Spacer(modifier = Modifier.height(20.dp))
        Text(
            text = "Hey Welcome",
            fontSize = 30.sp,
            fontWeight = FontWeight.Bold,
            fontFamily = FontFamily.Cursive
        )
        Spacer(modifier = Modifier.height(15.dp))
        Text(
            text = "Login to your Account",
            fontSize = 15.sp,
            fontWeight = FontWeight.Black
        )
        OutlinedTextField(
            value = username,
            onValueChange = { username = it },
            label = { Text(text = "Username") }
        )
        Spacer(modifier = Modifier.height(5.dp))
        OutlinedTextField(
            value = password,
            onValueChange = { password = it },
            label = { Text(text = "Password") },
            visualTransformation = PasswordVisualTransformation()
        )
        Spacer(modifier = Modifier.height(5.dp))
        OutlinedTextField(
            value = name,
            onValueChange = { name = it },
            label = { Text(text = "Name") },
        )
        Spacer(modifier = Modifier.height(10.dp))
        val context = LocalContext.current
        Button(onClick = {navController.navigate("screen2/$name")
            Toast.makeText(context,"Button Clicked",Toast.LENGTH_SHORT).show()
        }) {
            Text(text = "Login")
        }
        TextButton(onClick = {}) {
            Text(
                text = "Forgot Password",
                fontFamily = FontFamily.Monospace,
                fontSize = 10.sp,
                fontWeight = FontWeight.Black
            )
        }
        Spacer(modifier = Modifier.height(2.dp))
        Text(
            text = "Or login with",
            fontWeight = FontWeight.Black,
            fontSize = 10.sp,
            fontFamily = FontFamily.Monospace
        )
        Spacer(modifier = Modifier.height(10.dp))
        Row {
            Image(
                painter = painterResource(id = R.drawable.fb),
                contentDescription = "Fb icon",
                modifier = Modifier
                    .size(35.dp)
                    .clickable {
                        val fbIntent =
                            Intent(Intent.ACTION_VIEW, Uri.parse("https://www.facebook.com/"))
                        context.startActivity(fbIntent)
                    }
            )
            Spacer(modifier = Modifier.width(5.dp))
            Image(
                painter = painterResource(id = R.drawable.google),
                contentDescription = "Google icon",
                modifier = Modifier
                    .size(40.dp)
                    .clickable {
                        val googleIntent =
                            Intent(Intent.ACTION_VIEW, Uri.parse("https://www.google.com/"))
                        context.startActivity(googleIntent)
                    }
            )
        }
    }
}

fun toast(context: Context) {
    Toast.makeText(context, "Button clicked", Toast.LENGTH_SHORT).show()
}

