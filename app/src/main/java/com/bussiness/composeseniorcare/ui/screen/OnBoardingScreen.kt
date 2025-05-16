package com.bussiness.composeseniorcare.ui.screen

//import androidx.compose.foundation.clickable
//import androidx.compose.foundation.layout.Arrangement
//import androidx.compose.foundation.layout.Column
//import androidx.compose.foundation.layout.Row
//import androidx.compose.foundation.layout.Spacer
//import androidx.compose.foundation.layout.fillMaxWidth
//import androidx.compose.foundation.layout.height
//import androidx.compose.foundation.layout.padding
//import androidx.compose.foundation.layout.size
//import androidx.compose.foundation.layout.width
//import androidx.compose.foundation.shape.RoundedCornerShape
//import androidx.compose.material.icons.Icons
//import androidx.compose.material.icons.filled.Email
//import androidx.compose.material.icons.filled.Lock
//import androidx.compose.material.icons.filled.Visibility
//import androidx.compose.material3.Button
//import androidx.compose.material3.ButtonDefaults
//import androidx.compose.material3.Icon
//import androidx.compose.material3.MaterialTheme
//import androidx.compose.material3.OutlinedButton
//import androidx.compose.material3.OutlinedTextField
//import androidx.compose.material3.Text
//import androidx.compose.ui.Alignment
//import androidx.compose.ui.Modifier
//import androidx.compose.ui.graphics.Color
//import androidx.compose.ui.res.painterResource
//import androidx.compose.ui.text.font.FontWeight
//import androidx.compose.ui.text.input.PasswordVisualTransformation
//import androidx.compose.ui.text.style.TextAlign
//import androidx.compose.ui.unit.dp
//import com.bussiness.composeseniorcare.R
//
//Card(
//modifier = Modifier
//.fillMaxWidth()
//.padding(horizontal = 20.dp, vertical = 12.dp),
//shape = RoundedCornerShape(32.dp),
//elevation = CardDefaults.cardElevation(4.dp)
//) {
//    Column(
//        modifier = Modifier
//            .padding(24.dp)
//            .fillMaxWidth(),
//        horizontalAlignment = Alignment.CenterHorizontally
//    ) {
//        Text("Login", style = MaterialTheme.typography.headlineSmall)
//
//        Spacer(modifier = Modifier.height(6.dp))
//
//        Text(
//            "Log in to your account and explore senior\nliving options tailored to your needs.",
//            textAlign = TextAlign.Center,
//            style = MaterialTheme.typography.bodySmall,
//            color = Color.Gray
//        )
//
//        Spacer(modifier = Modifier.height(20.dp))
//
//        OutlinedTextField(
//            value = "",
//            onValueChange = {},
//            label = { Text("Your Email/Phone") },
//            placeholder = { Text("Your Email/Phone") },
//            leadingIcon = {
//                Icon(Icons.Default.Email, contentDescription = null)
//            },
//            modifier = Modifier.fillMaxWidth()
//        )
//
//        Spacer(modifier = Modifier.height(12.dp))
//
//        OutlinedTextField(
//            value = "",
//            onValueChange = {},
//            label = { Text("Your Password") },
//            placeholder = { Text("Your Password") },
//            leadingIcon = {
//                Icon(Icons.Default.Lock, contentDescription = null)
//            },
//            trailingIcon = {
//                Icon(Icons.Default.Visibility, contentDescription = null)
//            },
//            visualTransformation = PasswordVisualTransformation(),
//            modifier = Modifier.fillMaxWidth()
//        )
//
//        Spacer(modifier = Modifier.height(6.dp))
//
//        Row(
//            modifier = Modifier.fillMaxWidth(),
//            horizontalArrangement = Arrangement.End
//        ) {
//            Text(
//                text = "Forgot Password?",
//                style = MaterialTheme.typography.bodySmall,
//                color = MaterialTheme.colorScheme.primary,
//                modifier = Modifier.clickable { onForgotPasswordClick() }
//            )
//        }
//
//        Spacer(modifier = Modifier.height(16.dp))
//
//        Button(
//            onClick = onLoginClick,
//            modifier = Modifier
//                .fillMaxWidth()
//                .height(48.dp),
//            shape = RoundedCornerShape(12.dp),
//            colors = ButtonDefaults.buttonColors(containerColor = Color(0xFF5A2A60))
//        ) {
//            Text("Login")
//        }
//
//        Spacer(modifier = Modifier.height(10.dp))
//
//        Row {
//            Text("Don't you have an account?")
//            Text(
//                text = " Sign Up",
//                color = MaterialTheme.colorScheme.primary,
//                modifier = Modifier.clickable { onSignUpClick() },
//                fontWeight = FontWeight.Bold
//            )
//        }
//
//        Spacer(modifier = Modifier.height(10.dp))
//
//        Text("Or login with")
//
//        Spacer(modifier = Modifier.height(10.dp))
//
//        OutlinedButton(
//            onClick = onGoogleLoginClick,
//            modifier = Modifier.fillMaxWidth(),
//            shape = RoundedCornerShape(12.dp)
//        ) {
//            Icon(
//                painter = painterResource(id = R.drawable.google_ic), // Add Google logo in drawable
//                contentDescription = "Google Logo",
//                modifier = Modifier.size(20.dp)
//            )
//            Spacer(modifier = Modifier.width(8.dp))
//            Text("Google")
//        }
//    }
//}