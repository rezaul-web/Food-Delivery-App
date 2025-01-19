package com.example.fooddeliveryapp.ui.features.auth.login

import androidx.compose.foundation.Image
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.layout.width
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.automirrored.filled.ArrowBack
import androidx.compose.material.icons.filled.ArrowBack
import androidx.compose.material3.Button
import androidx.compose.material3.ButtonDefaults
import androidx.compose.material3.Icon
import androidx.compose.material3.IconButton
import androidx.compose.material3.Text
import androidx.compose.material3.TextButton
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
import androidx.compose.ui.text.input.VisualTransformation
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.navigation.NavHostController
import com.example.fooddeliveryapp.R
import com.example.fooddeliveryapp.ui.FoodHubTextField
import com.example.fooddeliveryapp.ui.LoginOption
import com.example.fooddeliveryapp.ui.SocialButtons
import com.example.fooddeliveryapp.ui.theme.Orange

@Composable
fun LogInScreen(modifier: Modifier = Modifier, navController: NavHostController) {

    var email by remember { mutableStateOf("") }

    var password by remember { mutableStateOf("") }
    var isPasswordVisible by remember { mutableStateOf(false) }
    Box {
        Image(
            painter = painterResource(R.drawable.ic_auth_bg),
            contentDescription = null,
            modifier = modifier.fillMaxSize()
        )
        IconButton(
            onClick = {
                navController.navigate("auth") {
                    launchSingleTop = true
                    popUpTo("auth") {
                        inclusive = true
                    }
                }
            },
            modifier = Modifier.align(Alignment.TopStart)
        ) {
            Icon(
                Icons.AutoMirrored.Filled.ArrowBack,
                contentDescription = null,
                tint = Color.Black
            )
        }
        Column(
            modifier = Modifier
                .fillMaxSize()
                .padding(16.dp),
            horizontalAlignment = Alignment.CenterHorizontally
        ) {
            Box(Modifier.weight(1f))
            Text(text = "Log In", fontSize = 45.sp)
            Spacer(Modifier.size(16.dp))
            FoodHubTextField(
                modifier = Modifier.fillMaxWidth(),
                value = email,
                onValueChange = { email = it },
                label = { Text("Email") })
            Spacer(Modifier.size(16.dp))
            FoodHubTextField(
                modifier = Modifier.fillMaxWidth(),
                value = password,
                onValueChange = { password = it },
                label = { Text("Password") },
                visualTransformation = if (!isPasswordVisible) {
                    PasswordVisualTransformation()
                } else VisualTransformation.None,
                trailingIcon = {
                    IconButton(onClick = {
                        isPasswordVisible = !isPasswordVisible
                    }) {
                        Icon(
                            painter = painterResource(R.drawable.ic_eye),
                            contentDescription = null
                        )
                    }
                },
                singleLine = true
            )
            Spacer(Modifier.size(16.dp))
            TextButton(onClick = {}) {
                Text(text = "Forgot password", color = Orange)
            }
            Spacer(Modifier.size(16.dp))

            Button(
                onClick = {
navController.navigate("verification")
                },
                modifier = Modifier
                    .align(Alignment.CenterHorizontally)
                    .width(200.dp),
                colors = ButtonDefaults.buttonColors(
                    containerColor = Orange,
                )
            ) {
                Text(text = "Log In")
            }
            LoginOption(
                onClick = {
                    navController.navigate("sign_up")
                },
                name = R.string.sign_up,
                text = R.string.do_not_have_account,
                colorName = Orange,
                colorText = Color.Black
            )
            SocialButtons(onClickGoogle = {}, onClickFacebook = {}, color = Color.Black)
        }
    }
}
